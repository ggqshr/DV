package ggq.service;

import ggq.mapper.Report_userinfoMapper;
import ggq.model.Report_userinfo;
import ggq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("ReportUserInfoService")
public class ReportUserInfoServieImpl implements ReportUserInfoService {
    @Autowired
    private Report_userinfoMapper report_userinfoMapper;
    @Autowired
    private DateUtils dateUtils;

    @Override
    public Map<String, Object> getUserInfo(String date) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("newuser",report_userinfoMapper.getInfoByDateAndType(date,1).getNum());//获取新增访客
        map.put("activeuser",report_userinfoMapper.getInfoByDateAndType(date,3).getNum());//获取活跃用户
        map.put("silenceuser",report_userinfoMapper.getInfoByDateAndType(date,4).getNum());
        map.put("totaluser",report_userinfoMapper.getTotalUserNum(date));
        return map;
    }
}
