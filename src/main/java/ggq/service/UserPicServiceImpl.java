package ggq.service;

import ggq.mapper.UserPIcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("UserPicService")
public class UserPicServiceImpl implements UserPicService {
    @Autowired
    UserPIcMapper userPIcMapper;


    @Override
    public List<Map<String, String>> getManAndWomanNum() {
        Map<String, String> manNumAndWomanNum = userPIcMapper.getManNumAndWomanNum();
        ArrayList<Map<String, String>> list = new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        map1.put("value", manNumAndWomanNum.get("manNum"));
        map1.put("name", "男生");
        list.add(map1);
        map2.put("value", manNumAndWomanNum.get("womanNum"));
        map2.put("name", "女生");
        list.add(map2);
        return list;
    }

    @Override
    public List<Map<String, String>> getEducation() {
        Map<String, String> education = userPIcMapper.getEducation();
        ArrayList<Map<String, String>> list = new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        HashMap<String, String> map3 = new HashMap<>();
        HashMap<String, String> map4 = new HashMap<>();
        HashMap<String, String> map5 = new HashMap<>();
        map1.put("value", education.get("wu"));
        map1.put("name", "未知");
        list.add(map1);
        map2.put("value", education.get("chuzhong"));
        map2.put("name", "初中");
        list.add(map2);
        map3.put("value", education.get("gaozhong"));
        map3.put("name", "高中");
        list.add(map3);
        map4.put("value", education.get("benke"));
        map4.put("name", "本科");
        list.add(map4);
        map5.put("value", education.get("zhuanke"));
        map5.put("name", "专科");
        list.add(map5);
        return list;
    }

    @Override
    public List<String> getAge() {
        Map<String, String> age = userPIcMapper.getAge();
        List<String> list = new ArrayList<>();
        list.add(age.get("wu"));
        list.add(age.get("a1"));
        list.add(age.get("a2"));
        list.add(age.get("a3"));
        list.add(age.get("a4"));
        list.add(age.get("a5"));
        list.add(age.get("a6"));
        return list;
    }

    @Override
    public List<Map<String, String>> getEmployee() {
        List<Map<String, String>> employee = userPIcMapper.getEmployee();
        return new ArrayList<>(employee);
    }
}
