package ggq.model;


public class ProductDetail {

    private long pro_id;
    private String pro_name;
    private long pro_click_num;
    private long pro_buy_num;
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public long getPro_id() {
        return pro_id;
    }

    public void setPro_id(long pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public long getPro_click_num() {
        return pro_click_num;
    }

    public void setPro_click_num(long pro_click_num) {
        this.pro_click_num = pro_click_num;
    }

    public long getPro_buy_num() {
        return pro_buy_num;
    }

    public void setPro_buy_num(long pro_buy_num) {
        this.pro_buy_num = pro_buy_num;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "pro_id=" + pro_id +
                ", pro_name='" + pro_name + '\'' +
                ", pro_click_num=" + pro_click_num +
                ", pro_buy_num=" + pro_buy_num +
                ", rank=" + rank +
                '}';
    }

    public ProductDetail(long pro_id, String pro_name, long pro_click_num, long pro_buy_num, int rank) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_click_num = pro_click_num;
        this.pro_buy_num = pro_buy_num;
        this.rank = rank;
    }

    public ProductDetail() {
    }
}
