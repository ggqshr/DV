package ggq.model;

public class DateModel {

    /**
     * startDate : 2019-02-27
     * endDate : 2019-03-06
     */

    private String startDate;
    private String endDate;

    public DateModel(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DateModel() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
