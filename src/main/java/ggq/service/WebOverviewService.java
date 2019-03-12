package ggq.service;

import ggq.model.websiteOverview;

import java.util.HashMap;
import java.util.List;

public interface WebOverviewService {
    /**
     * 根据传入的参数，计算当前日期减去传入的参数后的日期当天的PV、UV等数据
     * @param subDateNumber 当前日期减去的天数
     * @return
     */
    HashMap<String, Object> getPvUvEtcByDataType(String subDateNumber);

    /**
     * 获得系统中的总的PV、UV等数据
     * @return
     */
    websiteOverview getTotal();

    /**
     * 更具传入的日期，获取传入日期当天的每小时的跳出率数据
     * @param date 要查询的日期
     * @return
     */
    HashMap<String,double[]> getJumpRatePerHour(String date);

    /**
     * 根据传入的日期，获取传入日期当天的每小时的平均访问时间数据
     * @param date 要查询的日期
     * @return
     */
    HashMap<String,double[]> getAvgVistiTime(String date);

    /**
     * 根据传入的参数，获得指定范围内的PV、UV等数据以及平均访问时间和跳出率
     * @param date 日期
     * @param dataSubNumber 从当前日期减去的天数
     * @param currentHours 最多显示到当天的第几个小时
     * @return
     */
    List<HashMap<String,Object>> getDetailData(String date,String dataSubNumber,int currentHours);

}
