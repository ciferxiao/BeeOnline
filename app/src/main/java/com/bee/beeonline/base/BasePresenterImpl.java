package com.bee.beeonline.base;

import android.util.Base64;

import com.beeonline.library.utils.DD;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by 59395 on 2018/3/3.
 */

public class BasePresenterImpl {

    public static String getSign(LinkedHashMap<String, Object> map) {
//            String signStr = "";
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                signStr = signStr + entry.getKey() + entry.getValue();
//            }
        String signStr = formatParamMap(map);
        String hmacSha1 = hmacSha1(signStr, "beecalmer.!");
        String str16 = str2HexStr(hmacSha1);
        return str16.toUpperCase();

    }

    public static String hmacSha1(String data, String key) {
        byte[] doFinals = new byte[0];
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            SecretKeySpec secret = new SecretKeySpec(key.getBytes("UTF-8"), mac.getAlgorithm());
            mac.init(secret);
            doFinals = mac.doFinal(data.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(doFinals, Base64.NO_WRAP);
    }

    /**
     * 字符串转换成十六进制字符串
     *
     * @return String 每个Byte之间空格分隔，如: [61 6C 6B]
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;

        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString().trim();
    }

    public static String formatParamMap(Map<String, Object> paraMap) {
        String buff = "";
        Map<String, Object> tmpMap = paraMap;
        try {
            List<Map.Entry<String, Object>> infoIds =
                    new ArrayList<Map.Entry<String, Object>>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>() {

                @Override
                public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                    return (o1.getKey() + o1.getValue()).compareTo(o2.getKey() + o2.getValue());
//                    return o1.getKey().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, Object> item : infoIds) {
                String key = item.getKey();
                String val = String.valueOf(item.getValue());
                buf.append(key);
                buf.append(val);
            }
            buff = buf.toString();
            DD.dd("BUFF", buff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buff;
    }

}
