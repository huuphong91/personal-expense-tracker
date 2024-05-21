package huu.phong.expensetrackerapp.controller;

import huu.phong.expensetrackerapp.dto.ExpenseDto;
import huu.phong.expensetrackerapp.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Expense",
        description = "Expense API"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    @Operation(
            summary = "Create a new expense",
            description = "Create a new expense"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Expense created successfully"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);

        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get expense by id",
            description = "Get expense by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Expense found"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable Long id) {
        ExpenseDto expense = expenseService.getExpenseById(id);

        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @Operation(
            summary = "Get all expenses",
            description = "Get all expenses"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Expenses found"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenses = expenseService.getAllExpenses();

        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @Operation(
            summary = "Update expense",
            description = "Update expense"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Expense"
    )
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id, @RequestBody ExpenseDto expenseDto) {
        ExpenseDto updatedExpense = expenseService.updateExpense(id, expenseDto);

        return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete expense",
            description = "Delete expense"
    )
    @ApiResponse(
            responseCode = "204",
            description = "Expense deleted successfully"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
