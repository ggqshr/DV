package ggq.service;

import ggq.model.Report_userinfo;

import java.util.List;
import java.util.Map;

public interface ReportUserInfoService {
    /**
     * 显示给定日期的新用户、活跃用户、沉默用户的数量
     *
     * @param date 日期
     * @return 指定日期的用户数量数据
     */
    Map<String, Object> getUserInfo(String date);

    /**
     * 根据开始日期和结束日期返回新用户和活跃用户占总用户量的百分比
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 包含三个key，分别是日期label，对应时间段内的活跃用户和新增用户占总用户的比例
     */
    Map<String, Object> getNewAndActiveDataBetweenDate(String startDate, String endDate);

    /**
     *  分解开始日期和结束日期提供指定时间段内的新老会员人数
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    List<Object> getOldAndNewUserPerDay(String startDate, String endDate);

    /**
     * 获取近七天的留存用户
     * @return 包含两个key，分别是前端画图用的datalabel，已经近七天的留存用户数据
     */
    Map<String, Object> getRemainUser();

    /**
     * 获得近七天的新征用户和活跃用户的留存比例
     * @return
     */
    Map<String, double[]> getNewAndActiveRemainUserRate();
}
