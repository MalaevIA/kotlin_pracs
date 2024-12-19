package com.example.pr2.ui

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.pr2.R
import com.example.pr2.databinding.FragmentFirstBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ExpenseViewModel by activityViewModels()

    private var selectedDate: Calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Устанавливаем текущую дату по умолчанию
        updateDateText()

        // Обработчик выбора даты
        binding.pickDateButton.setOnClickListener {
            showDatePickerDialog()
        }

        // Обработчик добавления нового расхода
        binding.addExpenseButton.setOnClickListener {
            val amount = binding.amountEditText.text.toString().toDoubleOrNull()
            val category = binding.categoryEditText.text.toString()

            if (amount != null && category.isNotEmpty()) {
                // Добавляем новый расход с выбранной датой
                viewModel.addExpense(amount, category, selectedDate.time)
            }
        }

        binding.nextFragmentWithTransition.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, SecondFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        binding.nextFragmentWithNavigationApi.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    private fun showDatePickerDialog() {
        val year = selectedDate.get(Calendar.YEAR)
        val month = selectedDate.get(Calendar.MONTH)
        val day = selectedDate.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                selectedDate.set(selectedYear, selectedMonth, selectedDay)
                updateDateText()
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    private fun updateDateText() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        binding.dateTextView.text = dateFormat.format(selectedDate.time)
    }
}
