package com.example.pr2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pr2.R
import com.example.pr2.data.model.Expense
import com.example.pr2.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(ExpenseViewModel::class.java)

        // Подписка на изменения расходов
        viewModel.expenses.observe(viewLifecycleOwner, { expenses ->
            updateExpenseList(expenses)
        })

        // Настройка кнопок навигации
        binding.nextFragmentWithTransition.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, ThirdFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.nextFragmentWithNavigationApi.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }

    private fun updateExpenseList(expenses: List<Expense>) {
        val expenseText = expenses.joinToString("\n") { "${it.amount} - ${it.category} - ${it.date}" }
        binding.expenseTextView.text = if (expenseText.isEmpty()) "Расходов нет" else expenseText
    }
}
