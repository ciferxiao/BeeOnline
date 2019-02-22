package com.bee.beeonline.bean;

import com.beeonline.library.httpapi.bean.BaseData;

import java.util.List;

public class HomeDataBean extends BaseData {
    public HomeData data;

    public HomeData getData() {
        return data;
    }

    public void setData(HomeData data) {
        this.data = data;
    }

    public class HomeData {
        private List<Brands> brands;

        private List<RushBuy> rushBuy;

        private List<Like> news;

        private List<Banner> banner;

        private List<Optimization> optimization;

        private List<Like> like;


        public List<Brands> getBrands() {
            return brands;
        }

        public void setBrands(List<Brands> brands) {
            this.brands = brands;
        }

        public List<RushBuy> getRushBuy() {
            return rushBuy;
        }

        public void setRushBuy(List<RushBuy> rushBuy) {
            this.rushBuy = rushBuy;
        }

        public List<Like> getNews() {
            return news;
        }

        public void setNews(List<Like> news) {
            this.news = news;
        }

        public List<Banner> getBanner() {
            return banner;
        }

        public void setBanner(List<Banner> banner) {
            this.banner = banner;
        }

        public List<Optimization> getOptimization() {
            return optimization;
        }

        public void setOptimization(List<Optimization> optimization) {
            this.optimization = optimization;
        }

        public List<Like> getLike() {
            return like;
        }

        public void setLike(List<Like> like) {
            this.like = like;
        }
    }


    public class Brands {

        private Avatar cover;
        private Integer id;
        private String name;
        private Avatar logo;
        private Avatar logo2;
        private String country;
        private String description;
        private Avatar country_logo;

        public Avatar getCover() {
            return cover;
        }

        public void setCover(Avatar cover) {
            this.cover = cover;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Avatar getLogo() {
            return logo;
        }

        public void setLogo(Avatar logo) {
            this.logo = logo;
        }

        public Avatar getLogo2() {
            return logo2;
        }

        public void setLogo2(Avatar logo2) {
            this.logo2 = logo2;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Avatar getCountry_logo() {
            return country_logo;
        }

        public void setCountry_logo(Avatar country_logo) {
            this.country_logo = country_logo;
        }
    }


    public class RushBuy {
        private Integer act_id;
        private String act_name;
        private String start_time;
        private String end_time;
        private String created_at;
        private Integer status;
        private List<Products> products;

        public Integer getAct_id() {
            return act_id;
        }

        public void setAct_id(Integer act_id) {
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

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public List<Products> getProducts() {
            return products;
        }

        public void setProducts(List<Products> products) {
            this.products = products;
        }
    }


    public class Banner {
        private Integer ca_id;
        private Avatar url;
        private Integer sort_order;
        private Integer is_display;
        private Integer app_type;
        private Integer type;

        public Integer getCa_id() {
            return ca_id;
        }

        public void setCa_id(Integer ca_id) {
            this.ca_id = ca_id;
        }

        public Avatar getUrl() {
            return url;
        }

        public void setUrl(Avatar url) {
            this.url = url;
        }

        public Integer getSort_order() {
            return sort_order;
        }

        public void setSort_order(Integer sort_order) {
            this.sort_order = sort_order;
        }

        public Integer getIs_display() {
            return is_display;
        }

        public void setIs_display(Integer is_display) {
            this.is_display = is_display;
        }

        public Integer getApp_type() {
            return app_type;
        }

        public void setApp_type(Integer app_type) {
            this.app_type = app_type;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }


    public class Optimization {
        private Carousel carousel;
        private List<Like> goods;

        public Carousel getCarousel() {
            return carousel;
        }

        public void setCarousel(Carousel carousel) {
            this.carousel = carousel;
        }

        public List<Like> getGoods() {
            return goods;
        }

        public void setGoods(List<Like> goods) {
            this.goods = goods;
        }
    }

    public class Like {
        private String goods_title;
        private int goods_sales;
        private String goods_brief;
        private String goods_desc;
        private int is_on_sale;
        private boolean isLeft;
        private int is_shipping;
        private int is_delete;
        private int id;
        private int category;
        private int brand;
        private String brand_name;
        private goodsPhoto goods_photo;
        private String sku;
        private Avatar default_photo;
        private List<Avatar> photos;
        private String name;
        private String price;
        private String current_price;
        private Object discount;
        private String sales_count;
        private int good_stock;
        private int comment_count;
        private int is_liked;
        private String review_rate;
        private String share_url;
        private long created_at;
        private WeightBean weight;
        private long updated_at;
        private boolean is_ovsea;
        private List<GoodSpro> goodspro;


        public goodsPhoto getGoods_photo() {
            return goods_photo;
        }

        public void setGoods_photo(goodsPhoto goods_photo) {
            this.goods_photo = goods_photo;
        }

        public boolean isLeft() {
            return isLeft;
        }

        public void setLeft(boolean left) {
            isLeft = left;
        }

        public String getGoods_title() {
            return goods_title;
        }

        public void setGoods_title(String goods_title) {
            this.goods_title = goods_title;
        }

        public int getGoods_sales() {
            return goods_sales;
        }

        public void setGoods_sales(int goods_sales) {
            this.goods_sales = goods_sales;
        }

        public String getGoods_brief() {
            return goods_brief;
        }

        public void setGoods_brief(String goods_brief) {
            this.goods_brief = goods_brief;
        }

        public String getGoods_desc() {
            return goods_desc;
        }

        public void setGoods_desc(String goods_desc) {
            this.goods_desc = goods_desc;
        }

        public int getIs_on_sale() {
            return is_on_sale;
        }

        public void setIs_on_sale(int is_on_sale) {
            this.is_on_sale = is_on_sale;
        }

        public int getIs_shipping() {
            return is_shipping;
        }

        public void setIs_shipping(int is_shipping) {
            this.is_shipping = is_shipping;
        }

        public int getIs_delete() {
            return is_delete;
        }

        public void setIs_delete(int is_delete) {
            this.is_delete = is_delete;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getBrand() {
            return brand;
        }

        public void setBrand(int brand) {
            this.brand = brand;
        }

        public String getBrand_name() {
            return brand_name;
        }

        public void setBrand_name(String brand_name) {
            this.brand_name = brand_name;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public Avatar getDefault_photo() {
            return default_photo == null ? new Avatar() : default_photo;
        }

        public void setDefault_photo(Avatar default_photo) {
            this.default_photo = default_photo;
        }

        public List<Avatar> getPhotos() {
            return photos;
        }

        public void setPhotos(List<Avatar> photos) {
            this.photos = photos;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCurrent_price() {
            return current_price;
        }

        public void setCurrent_price(String current_price) {
            this.current_price = current_price;
        }

        public Object getDiscount() {
            return discount;
        }

        public void setDiscount(Object discount) {
            this.discount = discount;
        }

        public String getSales_count() {
            return sales_count;
        }

        public void setSales_count(String sales_count) {
            this.sales_count = sales_count;
        }

        public int getGood_stock() {
            return good_stock;
        }

        public void setGood_stock(int good_stock) {
            this.good_stock = good_stock;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getIs_liked() {
            return is_liked;
        }

        public void setIs_liked(int is_liked) {
            this.is_liked = is_liked;
        }

        public String getReview_rate() {
            return review_rate;
        }

        public void setReview_rate(String review_rate) {
            this.review_rate = review_rate;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public long getCreated_at() {
            return created_at;
        }

        public void setCreated_at(long created_at) {
            this.created_at = created_at;
        }

        public WeightBean getWeight() {
            return weight;
        }

        public void setWeight(WeightBean weight) {
            this.weight = weight;
        }

        public long getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(long updated_at) {
            this.updated_at = updated_at;
        }

        public boolean isIs_ovsea() {
            return is_ovsea;
        }

        public void setIs_ovsea(boolean is_ovsea) {
            this.is_ovsea = is_ovsea;
        }

        public List<GoodSpro> getGoodspro() {
            return goodspro;
        }

        public void setGoodspro(List<GoodSpro> goodspro) {
            this.goodspro = goodspro;
        }
    }
}
