package ggq.service;

import ggq.mapper.ProductMapper;
import ggq.model.ActionDateShowModel;
import ggq.model.ProductDetail;
import ggq.model.UserAction;
import ggq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    private DateUtils dateUtils;

    @Override
    public Map<String, List<ProductDetail>> getProductData() {
        HashMap<String, List<ProductDetail>> map = new HashMap<>();
        List<ProductDetail> productBugTopTen = productMapper.getProductBugTopTen();
        productBugTopTen.forEach((item) -> {
            item.setRank(productBugTopTen.indexOf(item) + 1);
        });
        map.put("buy", productBugTopTen);
        List<ProductDetail> productClickTopTen = productMapper.getProductClickTopTen();
        productClickTopTen.forEach((item) -> {
            item.setRank(productClickTopTen.indexOf(item) + 1);
        });
        map.put("click", productClickTopTen);
        return map;
    }

    @Override
    public List<ActionDateShowModel> getActionData() {
        //获得用户操作的所有数据
        List<UserAction> userAction = productMapper.getUserAction(dateUtils.getDateSubResult(-6), dateUtils.getCurrentDate(DateUtils.onlyDateFormat));
        //获得所有操作的名字
        List<UserAction> allActionName = productMapper.getAllActionName();
        //将名字与对应的数据对应起来
        HashMap<String, ActionDateShowModel> dataMap = new HashMap<>();
        allActionName.forEach((item) -> {
            ActionDateShowModel model = new ActionDateShowModel(allActionName.indexOf(item), item.getActionName());
            dataMap.put(item.getActionName(), model);
        });
        //为每个用户的操作创建一个数组用来存储过去七天的操作数据
        userAction.forEach((item) -> {
            try {
                //获得两个日期之间的差值
                int index = dateUtils.getIntervalDays(dateUtils.getDateSubResult(-6), item.getAcdate());
                //映射到对应的字段名
                String fieldName = "date" + index;
                ActionDateShowModel model = dataMap.get(item.getActionName());
                //将对应的字段名赋值
                model.getClass().getField(fieldName).setInt(model, (int) item.getActionNum());
            } catch (ParseException | NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        ArrayList<ActionDateShowModel> objects = new ArrayList<>();
        dataMap.forEach((k, v) -> {
            objects.add(v);
        });
        return objects;
    }
}
