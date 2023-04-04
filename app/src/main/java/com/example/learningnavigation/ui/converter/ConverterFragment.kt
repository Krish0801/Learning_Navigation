package com.example.learningnavigation.ui.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.learningnavigation.R
import com.example.learningnavigation.databinding.FragmentConverterBinding

class ConverterFragment : Fragment() {

    private var _binding: FragmentConverterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val converterViewModel = ViewModelProvider(this).get(ConverterViewModel::class.java)

        _binding = FragmentConverterBinding.inflate(inflater, container, false)


        val root: View = binding.root

        val spinner1: Spinner = binding.currencySpinner1
        ArrayAdapter.createFromResource(
            requireContext(), R.array.currency_array, android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner1.adapter = adapter
        }

        val spinner2: Spinner = binding.currencySpinner2
        ArrayAdapter.createFromResource(
            requireContext(), R.array.currency_array, android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner2.adapter = adapter
        }
        binding.btnConvert.setOnClickListener {
            if (binding.currencySpinner1.selectedItemPosition == binding.currencySpinner2.selectedItemPosition) {
                Toast.makeText(requireContext(), "Check the currency converter", Toast.LENGTH_LONG)
                    .show()
            } else {

            }
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}