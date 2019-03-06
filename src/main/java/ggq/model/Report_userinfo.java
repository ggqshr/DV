package ggq.model;

public class Report_userinfo {
    private String platform;

    private String acdate;

    private Integer type;

    private Integer num;

    private Integer datediff;

    public Report_userinfo(String platform, String acdate, Integer type, Integer num, Integer datediff) {
        this.platform = platform;
        this.acdate = acdate;
        this.type = type;
        this.num = num;
        this.datediff = datediff;
    }

    public Report_userinfo() {
        super();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getAcdate() {
        return acdate;
    }

    public void setAcdate(String acdate) {
        this.acdate = acdate == null ? null : acdate.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDatediff() {
        return datediff;
    }

    public void setDatediff(Integer datediff) {
        this.datediff = datediff;
    }

    @Override
    public String toString() {
        return "Report_userinfo{" +
                "platform='" + platform + '\'' +
                ", acdate='" + acdate + '\'' +
                ", type=" + type +
                ", num=" + num +
                ", datediff=" + datediff +
                '}';
    }
}