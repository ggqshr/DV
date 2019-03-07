package ggq.service;

import com.google.common.primitives.Doubles;
import ggq.mapper.VisitorMapper;
import ggq.model.VisitorDataModel;
import ggq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service("VisitorService")
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    VisitorMapper visitorMapper;
    @Autowired
    DateUtils dateUtils;

    @Override
    public Map<String, List<String>> getDeepData() {
        HashMap<String, List<String>> map = new HashMap<>();
        List<VisitorDataModel> deepBetweenSenvenDays = visitorMapper.getDeepBetweenSenvenDays();
        try {
            List<String> intervalDays = dateUtils.findDates(dateUtils.getDateSubResult(-6), dateUtils.getCurrentDate(DateUtils.onlyDateFormat));
            map.put("datalabel", intervalDays);
            String[] data = {
                    "0", "0", "0", "0", "0", "0", "0",
            };

            deepBetweenSenvenDays.forEach((item) -> {
                int index = intervalDays.indexOf(item.getAccessDate());
                data[index] = item.getDeep().toString();
            });
            map.put("data", Arrays.asList(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<String> getOldAndNewNum() {
        //新用户type是1，老用户type是2
        List<VisitorDataModel> oldAndNewVistor = visitorMapper.getOldAndNewVistor();
        ArrayList<String> list = new ArrayList<>();
        oldAndNewVistor.forEach((item)->{
            list.add(String.valueOf(item.getNum()));
        });
        return list;
    }


}
