import java.time.LocalDate

// Класс Expense для представления одного расхода
class Expense(
    val amount: Double,         // Сумма расхода
    val category: String,       // Категория расхода
    val date: LocalDate         // Дата расхода
) {
    // Метод для вывода информации о конкретном расходе
    fun printExpense() {
        println("Сумма: $amount, Категория: $category, Дата: $date")
    }
}

class ExpenseTracker {
    private val expenses = mutableListOf<Expense>() // Список расходов

    // Метод для добавления нового расхода
    fun addExpense(expense: Expense) {
        expenses.add(expense)
        println("Расход добавлен: Сумма: ${expense.amount}, Категория: ${expense.category}, Дата: ${expense.date}")
    }

    // Метод для вывода всех расходов
    fun printAllExpenses() {
        if (expenses.isEmpty()) {
            println("Расходов нет")
        } else {
            println("Список всех расходов:")
            expenses.forEach { it.printExpense() }
        }
    }

    // Метод для подсчета суммы всех расходов по каждой категории
    fun calculateTotalByCategory() {
        if (expenses.isEmpty()) {
            println("Расходов нет")
            return
        }

        // Группируем расходы по категориям и суммируем их
        val totalsByCategory = expenses.groupBy { it.category }
            .mapValues { entry -> entry.value.sumOf { it.amount } }

        println("Суммы расходов по категориям:")
        for ((category, total) in totalsByCategory) {
            println("$category: $total")
        }
    }
}

fun main() {
    val tracker = ExpenseTracker()

    while (true) {
        println("\nВыберите действие:")
        println("1 - Добавить новый расход")
        println("2 - Показать все расходы")
        println("3 - Показать сумму расходов по категориям")
        println("0 - Выйти")

        when (readLine()?.toInt()) {
            1 -> {
                // Добавление нового расхода
                println("Введите сумму расхода:")
                val amount = readLine()?.toDoubleOrNull() ?: 0.0

                println("Введите категорию расхода:")
                val category = readLine().orEmpty()

                println("Введите дату расхода (в формате ГГГГ-ММ-ДД):")
                val date = LocalDate.parse(readLine())

                val expense = Expense(amount, category, date)
                tracker.addExpense(expense)
            }

            2 -> {
                // Показать все расходы
                tracker.printAllExpenses()
            }

            3 -> {
                // Показать сумму расходов по категориям
                tracker.calculateTotalByCategory()
            }

            0 -> {
                // Выход
                println("Выход из программы.")
                break
            }

            else -> {
                println("Некорректный выбор, попробуйте снова.")
            }
        }
    }
}
