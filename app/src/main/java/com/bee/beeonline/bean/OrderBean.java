package com.bee.beeonline.bean;

import java.util.List;

public class OrderBean {
    private int pay_status;
    private Consignee consignee;
    private String postscript;
    private int pay_id;
    private String pay_buyer_id;
    private String shipping_fee;
    private String money_paid;
    private String order_amount;
    private int is_wholesale;
    private String remark;
    private String admin_address;
    private String transfer_img;
    private String collect_img;
    private int transfer_man_id;
    private String transfer_man_name;
    private String transfer_time;
    private int billing_order;
    private String billing_remark;
    private int billing_duration;
    private int billing_expired_at;
    private int packman_id;
    private String packman_name;
    private String packman_img;
    private int packman_time;
    private int pickman_id;
    private String pickman_name;
    private String pickman_img;
    private int pickman_time;
    private String delivery_man;
    private String delivery_img;
    private String dadan_img;
    private String dadan_name;
    private int dadan_id;
    private int return_status;
    private int pre_paytime;
    private int id;
    private String sn;
    private int total;
    private Payment payment;
    private Shipping shipping;
    private Coupon coupon;
    private int status;
    private Status_text status_text;
    private long created_at;
    private long canceled_at;
    private String paied_at;
    private String shipping_at;
    private String finish_at;
    private List<Promos> promos;
    private String salesman;
    private String order_goods_number_total;
    private List<Goods> goods;

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public Consignee getConsignee() {
        return consignee;
    }

    public void setConsignee(Consignee consignee) {
        this.consignee = consignee;
    }

    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public String getPay_buyer_id() {
        return pay_buyer_id;
    }

    public void setPay_buyer_id(String pay_buyer_id) {
        this.pay_buyer_id = pay_buyer_id;
    }

    public String getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(String shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public String getMoney_paid() {
        return money_paid;
    }

    public void setMoney_paid(String money_paid) {
        this.money_paid = money_paid;
    }

    public String getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public int getIs_wholesale() {
        return is_wholesale;
    }

    public void setIs_wholesale(int is_wholesale) {
        this.is_wholesale = is_wholesale;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAdmin_address() {
        return admin_address;
    }

    public void setAdmin_address(String admin_address) {
        this.admin_address = admin_address;
    }

    public String getTransfer_img() {
        return transfer_img;
    }

    public void setTransfer_img(String transfer_img) {
        this.transfer_img = transfer_img;
    }

    public String getCollect_img() {
        return collect_img;
    }

    public void setCollect_img(String collect_img) {
        this.collect_img = collect_img;
    }

    public int getTransfer_man_id() {
        return transfer_man_id;
    }

    public void setTransfer_man_id(int transfer_man_id) {
        this.transfer_man_id = transfer_man_id;
    }

    public String getTransfer_man_name() {
        return transfer_man_name;
    }

    public void setTransfer_man_name(String transfer_man_name) {
        this.transfer_man_name = transfer_man_name;
    }

    public String getTransfer_time() {
        return transfer_time;
    }

    public void setTransfer_time(String transfer_time) {
        this.transfer_time = transfer_time;
    }

    public int getBilling_order() {
        return billing_order;
    }

    public void setBilling_order(int billing_order) {
        this.billing_order = billing_order;
    }

    public String getBilling_remark() {
        return billing_remark;
    }

    public void setBilling_remark(String billing_remark) {
        this.billing_remark = billing_remark;
    }

    public int getBilling_duration() {
        return billing_duration;
    }

    public void setBilling_duration(int billing_duration) {
        this.billing_duration = billing_duration;
    }

    public int getBilling_expired_at() {
        return billing_expired_at;
    }

    public void setBilling_expired_at(int billing_expired_at) {
        this.billing_expired_at = billing_expired_at;
    }

    public int getPackman_id() {
        return packman_id;
    }

    public void setPackman_id(int packman_id) {
        this.packman_id = packman_id;
    }

    public String getPackman_name() {
        return packman_name;
    }

    public void setPackman_name(String packman_name) {
        this.packman_name = packman_name;
    }

    public String getPackman_img() {
        return packman_img;
    }

    public void setPackman_img(String packman_img) {
        this.packman_img = packman_img;
    }

    public int getPackman_time() {
        return packman_time;
    }

    public void setPackman_time(int packman_time) {
        this.packman_time = packman_time;
    }

    public int getPickman_id() {
        return pickman_id;
    }

    public void setPickman_id(int pickman_id) {
        this.pickman_id = pickman_id;
    }

    public String getPickman_name() {
        return pickman_name;
    }

    public void setPickman_name(String pickman_name) {
        this.pickman_name = pickman_name;
    }

    public String getPickman_img() {
        return pickman_img;
    }

    public void setPickman_img(String pickman_img) {
        this.pickman_img = pickman_img;
    }

    public int getPickman_time() {
        return pickman_time;
    }

    public void setPickman_time(int pickman_time) {
        this.pickman_time = pickman_time;
    }

    public String getDelivery_man() {
        return delivery_man;
    }

    public void setDelivery_man(String delivery_man) {
        this.delivery_man = delivery_man;
    }

    public String getDelivery_img() {
        return delivery_img;
    }

    public void setDelivery_img(String delivery_img) {
        this.delivery_img = delivery_img;
    }

    public String getDadan_img() {
        return dadan_img;
    }

    public void setDadan_img(String dadan_img) {
        this.dadan_img = dadan_img;
    }

    public String getDadan_name() {
        return dadan_name;
    }

    public void setDadan_name(String dadan_name) {
        this.dadan_name = dadan_name;
    }

    public int getDadan_id() {
        return dadan_id;
    }

    public void setDadan_id(int dadan_id) {
        this.dadan_id = dadan_id;
    }

    public int getReturn_status() {
        return return_status;
    }

    public void setReturn_status(int return_status) {
        this.return_status = return_status;
    }

    public int getPre_paytime() {
        return pre_paytime;
    }

    public void setPre_paytime(int pre_paytime) {
        this.pre_paytime = pre_paytime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Status_text getStatus_text() {
        return status_text;
    }

    public void setStatus_text(Status_text status_text) {
        this.status_text = status_text;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getCanceled_at() {
        return canceled_at;
    }

    public void setCanceled_at(long canceled_at) {
        this.canceled_at = canceled_at;
    }

    public String getPaied_at() {
        return paied_at;
    }

    public void setPaied_at(String paied_at) {
        this.paied_at = paied_at;
    }

    public String getShipping_at() {
        return shipping_at;
    }

    public void setShipping_at(String shipping_at) {
        this.shipping_at = shipping_at;
    }

    public String getFinish_at() {
        return finish_at;
    }

    public void setFinish_at(String finish_at) {
        this.finish_at = finish_at;
    }

    public List<Promos> getPromos() {
        return promos;
    }

    public void setPromos(List<Promos> promos) {
        this.promos = promos;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getOrder_goods_number_total() {
        return order_goods_number_total;
    }

    public void setOrder_goods_number_total(String order_goods_number_total) {
        this.order_goods_number_total = order_goods_number_total;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
