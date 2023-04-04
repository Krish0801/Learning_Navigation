package com.example.learningnavigation.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.learningnavigation.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {

    private val viewModel: CalculatorViewModel by viewModels()
    private var _binding: FragmentCalculatorBinding? = null  //read/write

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!! //read only


//    lateinit var bindingTest: FragmentCalculatorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)

        viewModel.text.observe(viewLifecycleOwner) {
//            binding.edt1.setText(it)
            ////
        }

        setupUI()

        return binding.root
    }

    private fun setupUI() {
//        binding.let {
//            it.buttonC.setOnClickListener {it1 ->
//                it.etInput.setText("")
//            }
//        }
        binding.apply {
            buttonC.setOnClickListener {
                clearTextField()
            }
            button0.setOnClickListener { etInput.append("0") }
            button1.setOnClickListener { etInput.append("1") }
            button2.setOnClickListener { etInput.append("2") }
            button3.setOnClickListener { etInput.append("3") }
            button4.setOnClickListener { etInput.append("4") }
            button5.setOnClickListener { etInput.append("5") }
            button6.setOnClickListener { etInput.append("6") }
            button7.setOnClickListener { etInput.append("7") }
            button8.setOnClickListener { etInput.append("8") }
            button9.setOnClickListener { etInput.append("9") }
            btnDot.setOnClickListener { etInput.append(".") }
            btnSum.setOnClickListener {
                viewModel.currentAction = "+"
                viewModel.firstValue = etInput.text.toString().toDouble()
                clearTextField()
            }
            btnSub.setOnClickListener {
                viewModel.currentAction = "-"
                viewModel.firstValue = etInput.text.toString().toDouble()
                clearTextField()
            }
            btnMul.setOnClickListener {
                viewModel.currentAction = "*"
                viewModel.firstValue = etInput.text.toString().toDouble()
                clearTextField()
            }
            btnDiv.setOnClickListener {
                viewModel.currentAction = "/"
                viewModel.firstValue = etInput.text.toString().toDouble()
                clearTextField()
            }

            btnEqual.setOnClickListener {
                when (viewModel.currentAction) {
                    "+" -> {
                        if (etInput.text.toString().isNotEmpty()) {
                            viewModel.secondValue = etInput.text.toString().toDouble()
                            val result = viewModel.sum()
                            showResult(result)
                            etInput.setText(result.toString())
                            resetValue(result)
                        } else {
                            Toast.makeText(
                                context, "Please input a value", Toast.LENGTH_SHORT
                            ).show()

                        }
                    }
                    "-" -> {}
                    "*" -> {}
                    "/" -> {}
                    else -> {
                        Toast.makeText(
                            context,
                            "Please make sure all requirements are met!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
//        binding.buttonC.setOnClickListener {
//            binding.etInput.setText("")
//        }
    }

    private fun resetValue(result: Double) {
        viewModel.firstValue = result
        viewModel.secondValue = 0.0
        viewModel.currentAction = ""
    }

    private fun showResult(result: Double) {
        Toast.makeText(context, "Result: $result", Toast.LENGTH_SHORT).show()
    }

    private fun FragmentCalculatorBinding.clearTextField() {
        etInput.setText("")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}