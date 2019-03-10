package ggq.mapper;

import ggq.model.NewUserAndActiveUserData;
import ggq.model.Report_userinfo;
import ggq.model.oldUserAndNewUserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Report_userinfoMapper {
    int insert(Report_userinfo record);

    int insertSelective(Report_userinfo record);

    Report_userinfo select();

    Report_userinfo getInfoByDateAndType(String date,int type);

    Integer getTotalUserNum(String date);

    List<NewUserAndActiveUserData> getNewUserDataAndActiveDataBetweenDate(String startDate,String endDate);

    List<oldUserAndNewUserModel> getOldAndNewUserPerDay(String startDate,String endDate);

    List<Report_userinfo> getRemainUser();

    Integer getUserInfoByTypeAndDateGroupByType(String acDate,int type);

    Integer getRemainRateByDateAndDateDiff(@Param("acDate") String acDate,@Param("dateDiff") int dateDiff);
}