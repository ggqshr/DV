package ggq.service;

import ggq.mapper.ProductMapper;
import ggq.model.ActionDateShowModel;
import ggq.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface ProductService {
    /**
     * 获取点击量和购买量前十的产品信息
     *
     * @return map中有两个key，分别对应点击量前十的列表和购买量前十的列表
     */
    Map<String, List<ProductDetail>> getProductData();

    /**
     * 获得用户操作列表
     *
     * @return 用户错作数据模型的列表
     */
    List<ActionDateShowModel> getActionData();
}
