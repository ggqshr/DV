package ggq.mapper;

import ggq.model.ProductDetail;

import java.util.List;

public interface ProductMapper {
    List<ProductDetail> getProductClickTopTen();

    List<ProductDetail> getProductBugTopTen();
}
