package huu.phong.expensetrackerapp.mapper;

import huu.phong.expensetrackerapp.dto.CategoryDto;
import huu.phong.expensetrackerapp.dto.ExpenseDto;
import huu.phong.expensetrackerapp.entity.Category;
import huu.phong.expensetrackerapp.entity.Expense;

public class ExpenseMapper {

    public static ExpenseDto toDto(Expense entity) {
        return new ExpenseDto(entity.getId(), entity.getAmount(), entity.getExpenseDate(), new CategoryDto(entity.getCategory().getId(), entity.getCategory().getName()));
    }

    public static Expense toEntity(ExpenseDto dto) {
        return new Expense(dto.id(), dto.amount(), dto.expenseDate(), new Category(dto.categoryDto().id(), dto.categoryDto().name()));
    }
}
