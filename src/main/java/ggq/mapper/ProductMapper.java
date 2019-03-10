package ggq.mapper;

import ggq.model.ActionDateShowModel;
import ggq.model.ProductDetail;
import ggq.model.UserAction;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    List<ProductDetail> getProductClickTopTen();

    List<ProductDetail> getProductBugTopTen();

    List<UserAction> getUserAction(String startDate, String endDate);

    @Select("select distinct acdate from user_action")
    List<UserAction> getAllUserActionDate();

    @Select(value = "select distinct action_name from user_action")
    List<UserAction> getAllActionName();
}
