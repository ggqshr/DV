package ggq.service;

import java.util.List;
import java.util.Map;

public interface UserPicService {
    /**
     * 获得用户的男和女的数量
     * @return
     */
    List<Map<String,String>> getManAndWomanNum();

    /**
     * 获得会员的教育情况，
     * @return
     */
    List<Map<String,String>> getEducation();

    /**
     * 获得会员的年龄分布的数据
     * @return
     */
    List<String> getAge();

    /**
     * 获得会员的职业分布的数据
     * @return
     */
    List<Map<String,String>> getEmployee();
}
