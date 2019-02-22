package com.bee.beeonline.bean;

import com.beeonline.library.httpapi.bean.BaseData;

import java.util.List;

public class SortCate extends BaseData {

    private List<SortCateBase> data;

    public List<SortCateBase> getData() {
        return data;
    }

    public void setData(List<SortCateBase> data) {
        this.data = data;
    }

    public class SortCateBase {
        private int cat_id;
        private String cat_name;
        private String photo_url;
        private String keywords;
        private String cat_desc;
        private int parent_id;
        private int sort_order;
        private String template_file;
        private String measure_unit;
        private int show_in_nav;
        private String style;
        private int is_show;
        private int grade;
        private String filter_attr;
        private List<SortCateBase> childs;
        private Avatar photos;
        private boolean isCheck = false;

        public Avatar getPhotos() {
            return photos;
        }

        public void setPhotos(Avatar photos) {
            this.photos = photos;
        }

        public List<SortCateBase> getChilds() {
            return childs;
        }

        public void setChilds(List<SortCateBase> childs) {
            this.childs = childs;
        }

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public int getCat_id() {
            return cat_id;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }

        public String getCat_name() {
            return cat_name;
        }

        public void setCat_name(String cat_name) {
            this.cat_name = cat_name;
        }

        public String getPhoto_url() {
            return photo_url;
        }

        public void setPhoto_url(String photo_url) {
            this.photo_url = photo_url;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getCat_desc() {
            return cat_desc;
        }

        public void setCat_desc(String cat_desc) {
            this.cat_desc = cat_desc;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public int getSort_order() {
            return sort_order;
        }

        public void setSort_order(int sort_order) {
            this.sort_order = sort_order;
        }

        public String getTemplate_file() {
            return template_file;
        }

        public void setTemplate_file(String template_file) {
            this.template_file = template_file;
        }

        public String getMeasure_unit() {
            return measure_unit;
        }

        public void setMeasure_unit(String measure_unit) {
            this.measure_unit = measure_unit;
        }

        public int getShow_in_nav() {
            return show_in_nav;
        }

        public void setShow_in_nav(int show_in_nav) {
            this.show_in_nav = show_in_nav;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public int getIs_show() {
            return is_show;
        }

        public void setIs_show(int is_show) {
            this.is_show = is_show;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getFilter_attr() {
            return filter_attr;
        }

        public void setFilter_attr(String filter_attr) {
            this.filter_attr = filter_attr;
        }
    }
}
