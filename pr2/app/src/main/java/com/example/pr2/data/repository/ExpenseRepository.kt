package com.example.pr2.data.repository

import com.example.pr2.data.model.Expense

class ExpenseRepository {
    private val expenses = mutableListOf<Expense>()

    // Добавить новый расход
    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

    // Получить все расходы
    fun getAllExpenses(): List<Expense> {
        return expenses
    }

    // Получить суммы по категориям
    fun calculateTotalByCategory(): Map<String, Double> {
        return expenses.groupBy { it.category }
            .mapValues { entry -> entry.value.sumOf { it.amount } }
    }
}
