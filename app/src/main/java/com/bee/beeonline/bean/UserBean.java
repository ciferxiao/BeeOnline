package com.bee.beeonline.bean;

public class UserBean {

    private UserInfo user_id;

    public UserInfo getUser_id() {
        return user_id;
    }

    public void setUser_id(UserInfo user_id) {
        this.user_id = user_id;
    }

    public class UserInfo {
        private Integer id;
        private Integer age;
        private Integer gender;
        private String username;
        private String nickname;
        private String mobile;
        private boolean mobile_binded;
        private long joined_at;
        private boolean is_auth;
        private boolean is_completed;
        private Avatar avatar;

        public Avatar getAvatar() {
            return avatar;
        }

        public void setAvatar(Avatar avatar) {
            this.avatar = avatar;
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public boolean isMobile_binded() {
            return mobile_binded;
        }

        public void setMobile_binded(boolean mobile_binded) {
            this.mobile_binded = mobile_binded;
        }

        public long getJoined_at() {
            return joined_at;
        }

        public void setJoined_at(long joined_at) {
            this.joined_at = joined_at;
        }

        public boolean isIs_auth() {
            return is_auth;
        }

        public void setIs_auth(boolean is_auth) {
            this.is_auth = is_auth;
        }

        public boolean isIs_completed() {
            return is_completed;
        }

        public void setIs_completed(boolean is_completed) {
            this.is_completed = is_completed;
        }
    }
}
