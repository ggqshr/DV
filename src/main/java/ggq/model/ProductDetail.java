package ggq.model;


public class ProductDetail {

    private long proId;
    private String proName;
    private long proClickNum;
    private long proBuyNum;
    private int rank;


    public ProductDetail(long proId, String proName, long proClickNum, long proBuyNum, int rank) {
        this.proId = proId;
        this.proName = proName;
        this.proClickNum = proClickNum;
        this.proBuyNum = proBuyNum;
        this.rank = rank;
    }

    public long getProId() {
        return proId;
    }

    public void setProId(long proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public long getProClickNum() {
        return proClickNum;
    }

    public void setProClickNum(long proClickNum) {
        this.proClickNum = proClickNum;
    }

    public long getProBuyNum() {
        return proBuyNum;
    }

    public void setProBuyNum(long proBuyNum) {
        this.proBuyNum = proBuyNum;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proClickNum=" + proClickNum +
                ", proBuyNum=" + proBuyNum +
                ", rank=" + rank +
                '}';
    }

    public ProductDetail() {
    }
}
