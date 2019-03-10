package ggq.model;

import java.util.ArrayList;

public class ActionDataModel {
    private String actionName;
    private ArrayList<Integer> actionDataList;

    public ActionDataModel() {
        actionDataList = new ArrayList<>();
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public ArrayList<Integer> getActionDataList() {
        return actionDataList;
    }

    public void setActionDataList(ArrayList<Integer> actionDataList) {
        this.actionDataList = actionDataList;
    }
}
