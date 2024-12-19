package com.example.pr2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pr2.data.model.Expense
import com.example.pr2.data.repository.ExpenseRepository
import java.util.Date

class ExpenseViewModel : ViewModel() {
    private val repository = ExpenseRepository()

    private val _expenses = MutableLiveData<List<Expense>>()
    val expenses: LiveData<List<Expense>> get() = _expenses

    private val _totalsByCategory = MutableLiveData<Map<String, Double>>()
    val totalsByCategory: LiveData<Map<String, Double>> get() = _totalsByCategory

    // Метод для добавления нового расхода через репозиторий
    fun addExpense(amount: Double, category: String, date: Date) {
        val newExpense = Expense(amount, category, date)
        repository.addExpense(newExpense)
        updateExpenses()
    }

    // Обновление списка расходов
    private fun updateExpenses() {
        _expenses.value = repository.getAllExpenses()
        _totalsByCategory.value = repository.calculateTotalByCategory()
    }

    // Получить все расходы
    fun getExpenses() {
        _expenses.value = repository.getAllExpenses()
    }
}
