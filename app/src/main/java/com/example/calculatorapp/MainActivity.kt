package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import org.w3c.dom.Text
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainDisplay:TextView =findViewById(R.id.tvDisplay)
        val secondDisplay:TextView =findViewById(R.id.tvSecondDisplay)
        val ac:TextView=findViewById(R.id.tvAC)
        val leftBrac:TextView=findViewById(R.id.tvOpeningBrackets)
        val rightBrac:TextView=findViewById(R.id.tvClosingBrackets)
        val divide:TextView=findViewById(R.id.tvDivide)
        val seven:TextView=findViewById(R.id.tv7)
        val eight:TextView=findViewById(R.id.tv8)
        val nine:TextView=findViewById(R.id.tv9)
        val multiply:TextView=findViewById(R.id.tvmultiply)
        val four:TextView=findViewById(R.id.tv4)
        val five:TextView=findViewById(R.id.tv5)
        val six:TextView=findViewById(R.id.tv6)
        val minus:TextView=findViewById(R.id.tvminus)
        val one:TextView=findViewById(R.id.tv1)
        val two:TextView=findViewById(R.id.tv2)
        val three:TextView=findViewById(R.id.tv3)
        val plus:TextView=findViewById(R.id.tvAdd)
        val backspc:TextView=findViewById(R.id.tvClear)
        val zero:TextView=findViewById(R.id.tv0)
        val dot:TextView=findViewById(R.id.tvDot)
        val equals:TextView=findViewById(R.id.tvEquals)

        ac.setOnClickListener {
            mainDisplay.text = ""
            secondDisplay.text = ""
            mainDisplay.setTextColor(ContextCompat.getColor(this,R.color.white))
        }
        leftBrac.setOnClickListener {
            mainDisplay.text = addToInputText("(")
        }
        rightBrac.setOnClickListener {
            mainDisplay.text = addToInputText(")")
            showResults()
        }
        divide.setOnClickListener {
            mainDisplay.text = addToInputText("÷")
        }
        seven.setOnClickListener {
            mainDisplay.text = addToInputText("7")
            showResults()
        }
        eight.setOnClickListener {
            mainDisplay.text = addToInputText("8")
            showResults()
        }
        nine.setOnClickListener {
            mainDisplay.text = addToInputText("9")
            showResults()
        }
        multiply.setOnClickListener {
            mainDisplay.text = addToInputText("×")
        }
        four.setOnClickListener {
            mainDisplay.text = addToInputText("4")
            showResults()
        }
        five.setOnClickListener {
            mainDisplay.text = addToInputText("5")
            showResults()
        }
        six.setOnClickListener {
            mainDisplay.text = addToInputText("6")
            showResults()
        }
        minus.setOnClickListener {
            mainDisplay.text = addToInputText("-")
        }
        one.setOnClickListener {
            mainDisplay.text = addToInputText("1")
            showResults()
        }
        two.setOnClickListener {
            mainDisplay.text = addToInputText("2")
            showResults()
        }
        three.setOnClickListener {
            mainDisplay.text = addToInputText("3")
            showResults()
        }
        plus.setOnClickListener {
            mainDisplay.text = addToInputText("+")
        }
        dot.setOnClickListener {
            mainDisplay.text = addToInputText(".")
        }
        zero.setOnClickListener {
            mainDisplay.text = addToInputText("0")
            showResults()
        }
        equals.setOnClickListener {
            removeFromInputText()
        }
    }
    private fun addToInputText(buttonValue: String): String {
        val main: TextView = findViewById(R.id.tvDisplay)
        return "${main.text}$buttonValue"
    }
    private fun getInputExpression(): String {
        val main: TextView = findViewById(R.id.tvDisplay)
        var expression = main.text.replace(Regex("÷"), "/")
        return expression.replace(Regex("×"), "*")
    }

    private fun removeFromInputText(){
        val main:TextView = findViewById(R.id.tvDisplay)
        main.text = main.text.dropLast(1).toString()
    }
    open fun showResults() {
        val main: TextView = findViewById(R.id.tvDisplay)
        val main1: TextView =findViewById(R.id.tvSecondDisplay)
        val equ:TextView =findViewById(R.id.tvEquals)
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {

            }else if(equ.isPressed){
                main.text = DecimalFormat("0.######").format(result).toString()
                main1.text = ""
                main.setTextColor(ContextCompat.getColor(this,R.color.green))
            }
            else {
                main1.text = DecimalFormat("0.######").format(result).toString()
            }
        } catch (e: Exception) {
            main.text = ""
        }
    }
}


