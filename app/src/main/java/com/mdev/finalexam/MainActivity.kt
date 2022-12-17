package com.mdev.finalexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

/*File name: Final Exam BMI Calculator
Author Name: Benny Baby
STUDENT ID : 200469127
App Description : CREATE A BMI Calculator
Version: Android Studio Dolphin | 2021.3.1 for Windows 64-bit */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //Variable object to initialize input and button
        val weightKgText = findViewById<EditText>(R.id.etWeight)
        val heightCmText = findViewById<EditText>(R.id.etHeight)
        val submitButton = findViewById<Button>(R.id.btnCalculate)


        submitValidation(submitButton, weightKgText, heightCmText)
    }

    //function for validation
    private fun submitValidation(
        calButton: Button,
        weightText: EditText,
        heightText: EditText
    ) {
        calButton.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()

            if (validateInput(weight, height)) {
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))
                val bmi2Digits = String.format("%.2f", bmi).toFloat()

                displayResult(bmi2Digits)
            }
        }
    }

   //Validating user input is empty or not
    private fun validateInput(weight:String?, height:String?):Boolean{
      return  when{
            weight.isNullOrEmpty() -> {Toast.makeText(this, " Weight is empty. Please input weight", Toast.LENGTH_LONG).show()
                return false
            }
          height.isNullOrEmpty() -> {Toast.makeText(this, " Height is empty. Please input height", Toast.LENGTH_LONG).show()
              return false
          }
          else ->{
              return true
          }

        }
    }

    //Validate input result to user according to chart given in instruction.
    private fun displayResult(bmi:Float){

        //Initializing each textview
        val resultIndex = findViewById<TextView>(R.id.tvIndex)
        val resultDetails = findViewById<TextView>(R.id.tvResult)
        val info = findViewById<TextView>(R.id.tvInfo)

        resultIndex.text = bmi.toString()
        info.text = "Your BMI:"

        var resultText = ""
        var color = 0

        //GIVING OUT RESULT TO USER ACCORDING TO CHART GIVEN IN INSTRUCTION
        when{
            bmi<16 ->{
                resultText = "Severe Thinness"
                color = R.color.underweight
            }
            bmi in 16.00..17.00 ->{
                resultText = "Moderate Thinness"
                color = R.color.underweight
            }
            bmi in 17.00..18.5 ->{
            resultText = "Mild Thinness"
            color = R.color.normal2
            }
            bmi in 18.50..25.00 ->{
                resultText = "Healthy"
                color = R.color.normal
            }
            bmi in 25.00..30.00 ->{
                resultText = "Overweight"
                color = R.color.normal2
            }
            bmi in 30.00..35.00 ->{
                resultText = "Obese Class |"
                color = R.color.obese
            }
            bmi in 35.00..40.00 ->{
                resultText = "Obese Class ||"
                color = R.color.obese
            }
            bmi  >40.99 ->{
                resultText = "Obese Class |||"
                color = R.color.overweight
            }
        }
        resultDetails.setTextColor(ContextCompat.getColor(this,color))
        resultDetails.text = resultText
    }
}