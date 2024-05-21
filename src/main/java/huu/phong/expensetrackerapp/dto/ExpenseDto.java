package huu.phong.expensetrackerapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Expense")
public record ExpenseDto(
        Long id,
        @Schema(description = "Expense amount") BigDecimal amount,
        @Schema(description = "Expense created date") LocalDate expenseDate, CategoryDto categoryDto) {
}
