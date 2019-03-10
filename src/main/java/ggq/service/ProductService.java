package ggq.service;

import ggq.mapper.ProductMapper;
import ggq.model.ActionDateShowModel;
import ggq.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Map<String,List<ProductDetail>> getProductData();

    List<ActionDateShowModel> getActionData();
}
