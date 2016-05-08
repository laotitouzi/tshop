package com.tshop.dao;
import com.tshop.entity.Category;
import java.util.List;
/**
 * @author Han,Tixiang
 *
 */
public interface CategoryMapper {

  List<Category> getCategoryList();

  Category getCategory(String categoryId);

}
