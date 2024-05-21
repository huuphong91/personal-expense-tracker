package huu.phong.expensetrackerapp.service;

import huu.phong.expensetrackerapp.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto dto);

    ExpenseDto getExpenseById(Long id);

    List<ExpenseDto> getAllExpenses();

    ExpenseDto updateExpense(Long id, ExpenseDto dto);

    void deleteExpense(Long id);
}
