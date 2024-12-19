package com.example.pr2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.pr2.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
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

        // Подписка на изменения
        viewModel.totalsByCategory.observe(viewLifecycleOwner, { totals ->
            updateCategorySummary(totals)
        })
    }

    private fun updateCategorySummary(totalsByCategory: Map<String, Double>) {
        val summaryText = totalsByCategory.entries.joinToString("\n") { "${it.key}: ${it.value}" }
        binding.categorySummaryTextView.text = if (summaryText.isEmpty()) "Расходов нет" else summaryText
    }
}
