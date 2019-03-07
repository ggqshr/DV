package ggq.model;

public class VisitorDataModel {
    private String accessDate;
    private Double deep;
    private int user_type;
    private int num;

    public VisitorDataModel(String accessDate, Double deep, int user_type, int num) {
        this.accessDate = accessDate;
        this.deep = deep;
        this.user_type = user_type;
        this.num = num;
    }

    public VisitorDataModel() {
    }

    public String getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }

    public Double getDeep() {
        return deep;
    }

    public void setDeep(Double deep) {
        this.deep = deep;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "VisitorDataModel{" +
                "accessDate='" + accessDate + '\'' +
                ", deep=" + deep +
                ", user_type=" + user_type +
                ", num=" + num +
                '}';
    }
}
