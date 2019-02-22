package com.bee.beeonline.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class HintHelper {
    public static void showHintAction(Context context, String tit, String msg, DialogInterface.OnClickListener onOkListener) {
        if (context == null)
            return;
        new AlertDialog.Builder(context).setTitle(tit).setMessage(msg)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", onOkListener).show();
    }
}
