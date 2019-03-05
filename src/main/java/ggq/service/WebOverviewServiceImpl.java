package ggq.service;

import ggq.mapper.websiteOverviewMapper;
import ggq.model.websiteOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Service("WebOverviewService")
public class WebOverviewServiceImpl implements WebOverviewService {
    @Autowired
    websiteOverviewMapper websiteOverviewMapper;


    public HashMap<Integer, websiteOverview> get(String dataType) {
        return websiteOverviewMapper.getPV(dataType);
    }

    @Override
    public HashMap<String, ArrayList<Integer>> getPvUvEtcByDataType(String dataType) {
        HashMap<Integer, websiteOverview> yestoday = websiteOverviewMapper.getPV(dataType);
        Integer[] times = {
                0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22
        };
        ArrayList<Integer> arraytimes = new ArrayList<>(Arrays.asList(times));
        ArrayList<Integer> finalData_pv = new ArrayList<>();
        ArrayList<Integer> finalData_uv = new ArrayList<>();
        ArrayList<Integer> finalData_vv = new ArrayList<>();
        ArrayList<Integer> finalData_ip = new ArrayList<>();
        System.out.println(yestoday);
        yestoday.forEach((k, v) -> {
            if (k % 2 != 0) {
                if (yestoday.containsKey(k - 1)) {
                    yestoday.replace(k - 1, yestoday.get(k - 1).addWebsiteOverview(v));
                } else {
                    yestoday.put(k - 1, v);
                }
            }
        });
        arraytimes.forEach((item) -> {
            if (yestoday.containsKey(item)) {
                finalData_pv.add(yestoday.get(item).getPV());
                finalData_uv.add(yestoday.get(item).getUV());
                finalData_vv.add(yestoday.get(item).getVV());
                finalData_ip.add(yestoday.get(item).getIP());
            } else {
                finalData_pv.add(0);
                finalData_uv.add(0);
                finalData_vv.add(0);
                finalData_ip.add(0);
            }
        });
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        map.put("pvData", finalData_pv);
        map.put("uvData", finalData_uv);
        map.put("vvData", finalData_vv);
        map.put("ipData", finalData_ip);
        return map;
    }

}
