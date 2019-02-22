package com.bee.beeonline.bean;

public class LimitInfo {

    private int act_id;
    private String act_name;
    private String start_time;
    private String end_time;
    private String created_at;
    private int time_remain_start;
    private int time_remain_end;
    private int status;

    public int getAct_id() {
        return act_id;
    }

    public void setAct_id(int act_id) {
        this.act_id = act_id;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getTime_remain_start() {
        return time_remain_start;
    }

    public void setTime_remain_start(int time_remain_start) {
        this.time_remain_start = time_remain_start;
    }

    public int getTime_remain_end() {
        return time_remain_end;
    }

    public void setTime_remain_end(int time_remain_end) {
        this.time_remain_end = time_remain_end;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
