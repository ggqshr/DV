package ggq.service;

import java.util.List;
import java.util.Map;

public interface UserPicService {
    List<Map<String,String>> getManAndWomanNum();

    List<Map<String,String>> getEducation();
}
