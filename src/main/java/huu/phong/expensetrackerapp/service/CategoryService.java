package huu.phong.expensetrackerapp.service;

import huu.phong.expensetrackerapp.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto dto);

    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Long id, CategoryDto dto);

    void deleteCategory(Long id);
}
