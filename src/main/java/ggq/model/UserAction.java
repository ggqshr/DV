package ggq.model;


public class UserAction {

  private long actionId;
  private String actionName;
  private String acdate;
  private long actionNum;


  public long getActionId() {
    return actionId;
  }

  public void setActionId(long actionId) {
    this.actionId = actionId;
  }


  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }


  public String getAcdate() {
    return acdate;
  }

  public void setAcdate(String acdate) {
    this.acdate = acdate;
  }


  public long getActionNum() {
    return actionNum;
  }

  public void setActionNum(long actionNum) {
    this.actionNum = actionNum;
  }

  @Override
  public String toString() {
    return "UserAction{" +
            "actionId=" + actionId +
            ", actionName='" + actionName + '\'' +
            ", acdate='" + acdate + '\'' +
            ", actionNum=" + actionNum +
            '}';
  }
}
