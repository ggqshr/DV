package ggq.model;



public class oldUserAndNewUserModel {
    private String accessDate;
    private int oldNum;
    private int newNum;

    public oldUserAndNewUserModel(String accessDate, int oldNum, int newNum) {
        this.accessDate = accessDate;
        this.oldNum = oldNum;
        this.newNum = newNum;
    }

    public oldUserAndNewUserModel() {
    }

    public String getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }

    public int getOldNum() {
        return oldNum;
    }

    public void setOldNum(int oldNum) {
        this.oldNum = oldNum;
    }

    public int getNewNum() {
        return newNum;
    }

    public void setNewNum(int newNum) {
        this.newNum = newNum;
    }

    @Override
    public String toString() {
        return "oldUserAndNewUserModel{" +
                "accessDate='" + accessDate + '\'' +
                ", oldNum=" + oldNum +
                ", newNum=" + newNum +
                '}';
    }
}
