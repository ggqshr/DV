package ggq.service;

import ggq.mapper.ProductMapper;
import ggq.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public Map<String, List<ProductDetail>> getProductData() {
        HashMap<String, List<ProductDetail>> map = new HashMap<>();
        List<ProductDetail> productBugTopTen = productMapper.getProductBugTopTen();
        productBugTopTen.forEach((item)->{
            item.setRank(productBugTopTen.indexOf(item)+1);
        });
        map.put("buy", productBugTopTen);
        List<ProductDetail> productClickTopTen = productMapper.getProductClickTopTen();
        productClickTopTen.forEach((item)->{
            item.setRank(productClickTopTen.indexOf(item)+1);
        });
        map.put("click", productClickTopTen);
        return map;
    }
}
