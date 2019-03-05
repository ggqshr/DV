package ggq.model;

import org.apache.ibatis.type.Alias;

@Alias("webOverview")
public class websiteOverview {
    private Integer accesshour;
    private Integer PV;
    private Integer VV;
    private Integer IP;
    private Integer UV;

    public websiteOverview() {
    }

    public websiteOverview(Integer accesshour, Integer PV, Integer VV, Integer IP, Integer UV) {
        this.accesshour = accesshour;
        this.PV = PV;
        this.VV = VV;
        this.IP = IP;
        this.UV = UV;
    }

    public Integer getAccesshour() {
        return accesshour;
    }

    public void setAccesshour(Integer accesshour) {
        this.accesshour = accesshour;
    }

    public Integer getPV() {
        return PV;
    }

    public void setPV(Integer PV) {
        this.PV = PV;
    }

    public Integer getVV() {
        return VV;
    }

    public void setVV(Integer VV) {
        this.VV = VV;
    }

    public Integer getIP() {
        return IP;
    }

    public void setIP(Integer IP) {
        this.IP = IP;
    }

    public Integer getUV() {
        return UV;
    }

    public void setUV(Integer UV) {
        this.UV = UV;
    }

    @Override
    public String toString() {
        return "websiteOverview{" +
                "accesshour=" + accesshour +
                ", PV=" + PV +
                ", VV=" + VV +
                ", IP=" + IP +
                ", UV=" + UV +
                '}';
    }
    public websiteOverview addWebsiteOverview(websiteOverview ww){
        websiteOverview newObj = new websiteOverview();
        newObj.setIP(this.IP+ww.getIP());
        newObj.setPV(this.PV+ww.getPV());
        newObj.setUV(this.UV+ww.getUV());
        newObj.setVV(this.VV+ww.getVV());
        return newObj;
    }
}
