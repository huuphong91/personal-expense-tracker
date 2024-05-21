package huu.phong.expensetrackerapp.service.imp;

import huu.phong.expensetrackerapp.dto.CategoryDto;
import huu.phong.expensetrackerapp.entity.Category;
import huu.phong.expensetrackerapp.exception.ResourceNotFoundException;
import huu.phong.expensetrackerapp.mapper.CategoryMapper;
import huu.phong.expensetrackerapp.repository.CategoryRepository;
import huu.phong.expensetrackerapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl  implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto dto) {
        Category entity = CategoryMapper.toEntity(dto);

        // Save entity to database
        entity = categoryRepository.save(entity);

        return CategoryMapper.toDto(entity);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return CategoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream().map(CategoryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setName(dto.name());

        category = categoryRepository.save(category);

        return CategoryMapper.toDto(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

    }
}
