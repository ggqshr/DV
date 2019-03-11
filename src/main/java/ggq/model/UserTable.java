package ggq.model;


public class UserTable {

  private String userName;
  private String userPassword;

  @Override
  public String toString() {
    return "UserTable{" +
            "userName='" + userName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            '}';
  }

  public UserTable() {
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public UserTable(String userName, String userPassword) {
    this.userName = userName;
    this.userPassword = userPassword;
  }
}
