package com.zahra.pokebook.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.zahra.pokebook.models.Expense;
import com.zahra.pokebook.repositories.ExpenseRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates a book
    public Expense createExpense(Expense e) {
        return expenseRepository.save(e);
    }
    // retrieves a book
    public Expense findExpense(Long id) {
        Optional<Expense> optionaExpense = expenseRepository.findById(id);
        if(optionaExpense.isPresent()) {
            return optionaExpense.get();
        } else {
            return null;
        }
    }
    
    public Expense updateExpense(Long id, String expense, String vendor, Double amount, String description) {
    	Expense e = findExpense(id);
    	e.setExpense(expense);
    	e.setVendor(vendor);
    	e.setAmount(amount);
    	e.setDescription(description);
    	return expenseRepository.save(e);
    }

    public void deleteExpense(Long id) {
    	Expense expense = findExpense(id);
    	if(expense != null) {    		
    		expenseRepository.deleteById(id);
    	}
    }
}
