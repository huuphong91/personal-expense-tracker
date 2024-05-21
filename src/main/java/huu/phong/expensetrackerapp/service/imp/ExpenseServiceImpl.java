package huu.phong.expensetrackerapp.service.imp;

import huu.phong.expensetrackerapp.dto.ExpenseDto;
import huu.phong.expensetrackerapp.entity.Category;
import huu.phong.expensetrackerapp.entity.Expense;
import huu.phong.expensetrackerapp.exception.ResourceNotFoundException;
import huu.phong.expensetrackerapp.mapper.ExpenseMapper;
import huu.phong.expensetrackerapp.repository.CategoryRepository;
import huu.phong.expensetrackerapp.repository.ExpenseRepository;
import huu.phong.expensetrackerapp.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ExpenseDto getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found " + id));

        return ExpenseMapper.toDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();

        return expenses.stream().map(ExpenseMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto dto) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found " + id));

        expense.setAmount(dto.amount());
        expense.setExpenseDate(dto.expenseDate());

        if (dto.categoryDto() != null) {
            Category category = categoryRepository.findById(dto.categoryDto().id())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found " + dto.categoryDto().id()));

            expense.setCategory(category);
        }

        Expense savedExpense = expenseRepository.save(expense);

        return ExpenseMapper.toDto(savedExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public ExpenseDto createExpense(ExpenseDto dto) {
        Expense entity = ExpenseMapper.toEntity(dto);

        // Save entity to database
        entity = expenseRepository.save(entity);

        return ExpenseMapper.toDto(entity);
    }
}
