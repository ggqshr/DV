package ggq.service;

import com.google.common.base.Strings;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import ggq.mapper.Report_userinfoMapper;
import ggq.model.NewUserAndActiveUserData;
import ggq.model.Report_userinfo;
import ggq.model.oldUserAndNewUserModel;
import ggq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("ReportUserInfoService")
public class ReportUserInfoServieImpl implements ReportUserInfoService {
    @Autowired
    private Report_userinfoMapper report_userinfoMapper;
    @Autowired
    private DateUtils dateUtils;

    @Override
    public Map<String, Object> getUserInfo(String date) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("newuser", report_userinfoMapper.getInfoByDateAndType(date, 1).getNum());//获取新增访客
        map.put("activeuser", report_userinfoMapper.getInfoByDateAndType(date, 3).getNum());//获取活跃用户
        map.put("silenceuser", report_userinfoMapper.getInfoByDateAndType(date, 4).getNum());
        map.put("totaluser", report_userinfoMapper.getTotalUserNum(date));
        return map;
    }

    @Override
    public Map<String, Object> getNewAndActiveDataBetweenDate(String startDate, String endDate) {
        List<String> rangeDates;
        Map<String, Object> map = new HashMap<>();
        try {
            int intervalDays = dateUtils.getIntervalDays(startDate, endDate);
            String[] newRateList = new String[intervalDays + 1];
            String[] activeRateList = new String[intervalDays + 1];
            rangeDates = dateUtils.findDates(startDate, endDate);
            map.put("rangdates", rangeDates);
            List<NewUserAndActiveUserData> data = report_userinfoMapper.getNewUserDataAndActiveDataBetweenDate(startDate, endDate);
            data.forEach((item) -> {
                try {
                    int intervalDays1 = dateUtils.getIntervalDays(startDate, item.getAcDate());
                    newRateList[intervalDays1] = item.getNewRate();
                    activeRateList[intervalDays1] = item.getActiveRate();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
            for (int i = 0; i < intervalDays; i++) {
                if (newRateList[i] == null) {
                    newRateList[i] = "0";
                }
                if (activeRateList[i] == null) {
                    activeRateList[i] = "0";
                }
            }
            map.put("newrate", Arrays.asList(newRateList));
            map.put("activerate", Arrays.asList(activeRateList));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<Object> getOldAndNewUserPerDay(String startDate, String endDate) {
        List<Object> map = new ArrayList<>();
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("user");
        objects.add("新会员");
        objects.add("老会员");
        map.add(objects);
        List<oldUserAndNewUserModel> oldAndNewUserPerDay = report_userinfoMapper.getOldAndNewUserPerDay(startDate, endDate);
        oldAndNewUserPerDay.forEach((item) -> {
            ArrayList<Object> list = new ArrayList<>();
            list.add(item.getAccessDate());
            list.add(item.getNewNum());
            list.add(item.getOldNum());
            map.add(list);
        });
        return map;
    }
}
