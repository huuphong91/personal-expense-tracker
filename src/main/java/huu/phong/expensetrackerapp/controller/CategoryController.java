package huu.phong.expensetrackerapp.controller;

import huu.phong.expensetrackerapp.dto.CategoryDto;
import huu.phong.expensetrackerapp.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Category",
        description = "Category API"

)
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(
            summary = "Create a new category",
            description = "Create a new category"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Category created successfully"
    )
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto dto) {
        CategoryDto result = categoryService.createCategory(dto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get category by id",
            description = "Get category by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Category found"
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        CategoryDto result = categoryService.getCategoryById(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(
            summary = "Get all categories",
            description = "Get all categories"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Categories found"
    )
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @Operation(
            summary = "Update category",
            description = "Update category"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Category updated successfully"
    )
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto dto) {
        CategoryDto result = categoryService.updateCategory(id, dto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete category",
            description = "Delete category"
    )
    @ApiResponse(
            responseCode = "204",
            description = "Category deleted successfully"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
