package ggq.model;

import java.util.List;

public class AgentDataModel {

    /**
     * acdate : ["2019-03-05T04:04:50.282Z","2019-03-07T04:04:50.282Z"]
     * platform : 1
     * referdomain : 1
     * useragent : 1
     */

    private String platform;
    private String referdomain;
    private String useragent;
    private List<String> acdate;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getReferdomain() {
        return referdomain;
    }

    public void setReferdomain(String referdomain) {
        this.referdomain = referdomain;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    public List<String> getAcdate() {
        return acdate;
    }

    public void setAcdate(List<String> acdate) {
        this.acdate = acdate;
    }

    @Override
    public String toString() {
        return "AgentDataModel{" +
                "platform='" + platform + '\'' +
                ", referdomain='" + referdomain + '\'' +
                ", useragent='" + useragent + '\'' +
                ", acdate=" + acdate +
                '}';
    }
}
