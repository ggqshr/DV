package ggq.mapper;

import java.util.List;
import java.util.Map;

public interface UserPIcMapper {
    Map<String,String> getManNumAndWomanNum();

    Map<String,String> getEducation();

    Map<String,String> getAge();

    List<Map<String,String>> getEmployee();
}
