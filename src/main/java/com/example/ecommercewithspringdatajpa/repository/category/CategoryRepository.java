package com.example.ecommercewithspringdatajpa.repository.category;

import com.example.ecommercewithspringdatajpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface CategoryRepository extends JpaRepository<Category, Long> {
    /**
     * get category by its name.
     * @param name the name of the category to get form database.
     * @return the found category.
     */
    @Query("from Category where name=:name")
    Category getCategoryByName(@Param("name")String name);

    /**
     * This method is used to get the names of all categories available in database.
     * @return List a list with categories available names.
     */
    @Query("SELECT c.name from Category c")
    List<String> getCategoriesNames();


    /**
     * search by category name
     * takes category name and retrieves all categories matching this name
     * @param categoryName categoryName
     * @return list of matched categories
     */
    @Query("from Category where name like :searchKey or name like :searchKey2 or name like :searchKey3 or name= :categoryName")
    List<Category> searchByCategoryName(@Param("searchKey") String searchKey,
      @Param("searchKey2") String searchKey2,@Param("searchKey3") String searchKey3,
      @Param("categoryName") String categoryName);
}
