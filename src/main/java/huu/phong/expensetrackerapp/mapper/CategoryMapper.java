package huu.phong.expensetrackerapp.mapper;

import huu.phong.expensetrackerapp.dto.CategoryDto;
import huu.phong.expensetrackerapp.entity.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryDto dto) {
        return new Category(dto.id(), dto.name());
    }

    public static CategoryDto toDto(Category entity) {
        return new CategoryDto(entity.getId(), entity.getName());
    }
}
