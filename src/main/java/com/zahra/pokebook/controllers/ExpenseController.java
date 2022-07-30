package com.zahra.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping("/expenses/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Expense e = expenseService.findExpense(id) ;
    	model.addAttribute("e", e);
    	return "edit.jsp";
    }
    
    @RequestMapping(value="/expenses/edit/{id}", method=RequestMethod.PUT)
    public String Update(@Valid @ModelAttribute("e") Expense e, BindingResult result,
    		@PathVariable("id") Long id,
    		@RequestParam(value="expense") String expense,
    		@RequestParam(value="vendor") String vendor,
    		@RequestParam(value="amount") Double amount,
    		@RequestParam(value="description") String description) {
    	if (result.hasErrors()) {
            return "redirect:/expenses/edit/{id}";
        } else {
            expenseService.updateExpense(id, expense, vendor, amount, description);
            return "redirect:/expenses";
        }
    }
    
    @RequestMapping("/expenses/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Expense e = expenseService.findExpense(id) ;
    	model.addAttribute("e", e);
    	return "show.jsp";
    }
    
    @RequestMapping(value="/expenses/delete/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	expenseService.deleteExpense(id);
    	return "redirect:/expenses";
    }

}
