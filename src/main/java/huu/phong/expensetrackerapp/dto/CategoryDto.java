package huu.phong.expensetrackerapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Category")
public record CategoryDto(Long id,
                          @Schema(description = "Category name") String name) {
}
