package ggq.model;


public class UserAgentTable {

  private String acdate;
  private String actime;
  private String platform;
  private long pnum;
  private String referdomain;
  private long dnum;
  private String useragent;
  private long anum;

  public UserAgentTable() {
  }

  @Override
  public String toString() {
    return "UserAgentTable{" +
            "acdate='" + acdate + '\'' +
            ", actime='" + actime + '\'' +
            ", platform='" + platform + '\'' +
            ", pnum=" + pnum +
            ", referdomain='" + referdomain + '\'' +
            ", dnum=" + dnum +
            ", useragent='" + useragent + '\'' +
            ", anum=" + anum +
            '}';
  }

  public UserAgentTable(String acdate, String actime, String platform, long pnum, String referdomain, long dnum, String useragent, long anum) {
    this.acdate = acdate;
    this.actime = actime;
    this.platform = platform;
    this.pnum = pnum;
    this.referdomain = referdomain;
    this.dnum = dnum;
    this.useragent = useragent;
    this.anum = anum;
  }

  public String getAcdate() {
    return acdate;
  }

  public void setAcdate(String acdate) {
    this.acdate = acdate;
  }


  public String getActime() {
    return actime;
  }

  public void setActime(String actime) {
    this.actime = actime;
  }


  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }


  public long getPnum() {
    return pnum;
  }

  public void setPnum(long pnum) {
    this.pnum = pnum;
  }


  public String getReferdomain() {
    return referdomain;
  }

  public void setReferdomain(String referdomain) {
    this.referdomain = referdomain;
  }


  public long getDnum() {
    return dnum;
  }

  public void setDnum(long dnum) {
    this.dnum = dnum;
  }


  public String getUseragent() {
    return useragent;
  }

  public void setUseragent(String useragent) {
    this.useragent = useragent;
  }


  public long getAnum() {
    return anum;
  }

  public void setAnum(long anum) {
    this.anum = anum;
  }

}
