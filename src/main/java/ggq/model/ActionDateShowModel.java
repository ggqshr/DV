package ggq.model;

public class ActionDateShowModel {
    public int action_id;
    public String action_name;
    public int date1;
    public int date2;
    public int date3;
    public int date4;
    public int date5;
    public int date6;
    public int date0;

    public ActionDateShowModel() {
    }

    public ActionDateShowModel(int action_id, String action_name, int date1, int date2, int date3, int date4, int date5, int date6, int date0) {
        this.action_id = action_id;
        this.action_name = action_name;
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
        this.date4 = date4;
        this.date5 = date5;
        this.date6 = date6;
        this.date0 = date0;
    }

    @Override
    public String toString() {
        return "ActionDateShowModel{" +
                "action_id=" + action_id +
                ", action_name='" + action_name + '\'' +
                ", date1=" + date1 +
                ", date2=" + date2 +
                ", date3=" + date3 +
                ", date4=" + date4 +
                ", date5=" + date5 +
                ", date6=" + date6 +
                ", data0=" + date0 +
                '}';
    }

    public ActionDateShowModel(int action_id, String action_name) {
        this.action_id = action_id;
        this.action_name = action_name;
        this.date1 = 0;
        this.date2 = 0;
        this.date3 = 0;
        this.date4 = 0;
        this.date5 = 0;
        this.date6 = 0;
        this.date0 = 0;
    }

    public int getAction_id() {
        return action_id;
    }

    public void setAction_id(int action_id) {
        this.action_id = action_id;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public int getDate1() {
        return date1;
    }

    public void setDate1(int date1) {
        this.date1 = date1;
    }

    public int getDate2() {
        return date2;
    }

    public void setDate2(int date2) {
        this.date2 = date2;
    }

    public int getDate3() {
        return date3;
    }

    public void setDate3(int date3) {
        this.date3 = date3;
    }

    public int getDate4() {
        return date4;
    }

    public void setDate4(int date4) {
        this.date4 = date4;
    }

    public int getDate5() {
        return date5;
    }

    public void setDate5(int date5) {
        this.date5 = date5;
    }

    public int getDate6() {
        return date6;
    }

    public void setDate6(int date6) {
        this.date6 = date6;
    }

    public int getdata0() {
        return date0;
    }

    public void setdata0(int data0) {
        this.date0 = data0;
    }
}
