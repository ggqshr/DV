package ggq.model;

public class NewUserAndActiveUserData {
    private String acDate;
    private String newRate;
    private String activeRate;

    public NewUserAndActiveUserData(String acDate, String newRate, String activeRate) {
        this.acDate = acDate;
        this.newRate = newRate;
        this.activeRate = activeRate;
    }

    public NewUserAndActiveUserData() {
    }

    public String getAcDate() {
        return acDate;
    }

    public void setAcDate(String acDate) {
        this.acDate = acDate;
    }

    public String getNewRate() {
        return newRate;
    }

    public void setNewRate(String newRate) {
        this.newRate = newRate;
    }

    public String getActiveRate() {
        return activeRate;
    }

    public void setActiveRate(String activeRate) {
        this.activeRate = activeRate;
    }

    @Override
    public String toString() {
        return "NewUserAndActiveUserData{" +
                "acDate='" + acDate + '\'' +
                ", newRate='" + newRate + '\'' +
                ", activeRate='" + activeRate + '\'' +
                '}';
    }
}
