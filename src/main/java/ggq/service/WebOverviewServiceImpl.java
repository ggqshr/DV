package ggq.service;

import ggq.mapper.websiteOverviewMapper;
import ggq.model.websiteOverview;
import ggq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("WebOverviewService")
public class WebOverviewServiceImpl implements WebOverviewService {
    @Autowired
    websiteOverviewMapper websiteOverviewMapper;
    @Autowired
    DateUtils dateUtils;

    /**
     * @param subDateNumber 从当前日期减去多少天
     * @return 返回的是24个小时里，每个小时的PV等其他数
     */
    @Override
    public HashMap<String, Object> getPvUvEtcByDataType(String subDateNumber) {
        HashMap<Integer, websiteOverview> dayData = websiteOverviewMapper.getPV(subDateNumber);
        HashMap<String, double[]> jumpRatePerHour = this.getJumpRatePerHour(dateUtils.getDateSubResult(-Integer.parseInt(subDateNumber)));
        HashMap<String, double[]> avgVistiTime = this.getAvgVistiTime(dateUtils.getDateSubResult(-Integer.parseInt(subDateNumber)));
        int[] finalData_pv = new int[24];
        int[] finalData_uv = new int[24];
        int[] finalData_vv = new int[24];
        int[] finalData_ip = new int[24];
        dayData.forEach((k, v) -> {
            finalData_pv[k] = v.getPV();
            finalData_uv[k] = v.getUV();
            finalData_vv[k] = v.getVV();
            finalData_ip[k] = v.getIP();
        });
        HashMap<String, Object> map = new HashMap<>();
        map.put("pvData", finalData_pv);
        map.put("uvData", finalData_uv);
        map.put("vvData", finalData_vv);
        map.put("ipData", finalData_ip);
        map.put("jumprate", jumpRatePerHour.get("jumprate"));
        map.put("avgtime", avgVistiTime.get("avgvisittime"));
        return map;
    }

    /**
     * @return 返回网站总的PV及其他属性
     */
    @Override
    public websiteOverview getTotal() {
        return websiteOverviewMapper.getTotal();
    }

    @Override
    public HashMap<String, double[]> getJumpRatePerHour(String date) {
        double[] data = new double[24];
        List<Map<String, Integer>> getjump = websiteOverviewMapper.getjump(date);
        getjump.forEach((map) -> {
            data[Integer.parseInt(String.valueOf(map.get("accesshour")))] = Double.parseDouble(String.valueOf(map.get("jumprate")));
        });
        HashMap<String, double[]> map = new HashMap<>();
        map.put("jumprate", data);
        return map;
    }

    @Override
    public HashMap<String, double[]> getAvgVistiTime(String date) {
        double[] data = new double[24];
        List<Map<String, String>> getjump = websiteOverviewMapper.getAvgVisitTime(date);
        getjump.forEach((map) -> {
            data[Integer.parseInt(String.valueOf(map.get("accesshour")))] = Double.parseDouble(String.valueOf(map.get("avgtime")));
        });
        HashMap<String, double[]> map = new HashMap<>();
        map.put("avgvisittime", data);
        return map;
    }

    @Override
    public List<HashMap<String, Object>> getDetailData(String date, String dataSubNumber, int currentHours) {
        HashMap<String, Object> pvUvEtcByDataType = getPvUvEtcByDataType(dataSubNumber);
        HashMap<String, double[]> jumpRatePerHour = getJumpRatePerHour(date);
        HashMap<String, double[]> avgVistiTime = getAvgVistiTime(date);
        List<HashMap<String, Object>> dataList = new ArrayList<>();
        int[] pvData = (int[]) pvUvEtcByDataType.get("pvData");
        int[] uvData = (int[]) pvUvEtcByDataType.get("uvData");
        int[] vvData = (int[]) pvUvEtcByDataType.get("vvData");
        int[] ipData = (int[]) pvUvEtcByDataType.get("ipData");
        double[] jumprates = jumpRatePerHour.get("jumprate");
        double[] avgvisittimes = avgVistiTime.get("avgvisittime");
        for (int i = 0; i < currentHours; ++i) {
            HashMap<String, Object> map = new HashMap<>();
            String currentTime;
            if (i < 10) {
                currentTime = "0" + i + ":00";
            } else {
                currentTime = i + ":00";
            }
            map.put("date", date + " " + currentTime);
            map.put("pv", pvData[i]);
            map.put("uv", uvData[i]);
            map.put("vv", vvData[i]);
            map.put("ip", ipData[i]);
            map.put("jumprates", jumprates[i]);
            map.put("avgvisittimes", avgvisittimes[i]);
            dataList.add(map);
        }
        return dataList;
    }

}
