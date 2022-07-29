package com.zahra.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zahra.pokebook.models.Expense;
import com.zahra.pokebook.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping("/expenses")
	public String index(@ModelAttribute("e") Expense e ,Model model) {
		List<Expense> expenses = expenseService.allExpenses();
        model.addAttribute("expenses", expenses);
		return "index.jsp";
		
	}
	
    @RequestMapping(value="/expenses/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("e") Expense e, BindingResult result) {
    	if (result.hasErrors()) {
            return "index.jsp";
        } else {
            expenseService.createExpense(e);
            return "redirect:/expenses";
        }
    }

}
