package ggq.mapper;

import ggq.model.ProductDetail;
import ggq.model.UserAction;

import java.util.List;

public interface ProductMapper {
    List<ProductDetail> getProductClickTopTen();

    List<ProductDetail> getProductBugTopTen();

    List<UserAction> getUserAction();
}
