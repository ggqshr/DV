package ggq.controller;

import com.alibaba.fastjson.JSON;
import ggq.model.ActionDateShowModel;
import ggq.model.ProductDetail;
import ggq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/api/product/data", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getData() {
        Map<String, List<ProductDetail>> productData = productService.getProductData();
        return JSON.toJSONString(productData);
    }

    @RequestMapping(value = "/api/product/actiondata", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getActionData() {
        List<ActionDateShowModel> actionData = productService.getActionData();
        return JSON.toJSONString(actionData);
    }
}
