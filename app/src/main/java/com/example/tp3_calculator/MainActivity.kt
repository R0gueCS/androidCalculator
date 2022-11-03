package com.example.tp3_calculator

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: screen

        //TODO: row1
        bb_c.setOnClickListener {
            equation.text = ""
            result.text = ""
        }
        bb_leftParenthese.setOnClickListener {
            equation.text = equation.text.toString().plus("(")
        }
        bb_rightParenthese.setOnClickListener {
            equation.text = equation.text.toString().plus(")")
        }
        bb_div.setOnClickListener {
            equation.text = equation.text.toString().plus("÷")
        }

        //TODO: row2
        bb_7.setOnClickListener {
            equation.text = equation.text.toString().plus("7")
        }
        bb_8.setOnClickListener {
            equation.text = equation.text.toString().plus("8")
        }
        bb_9.setOnClickListener {
            equation.text = equation.text.toString().plus("9")
        }
        bb_mult.setOnClickListener {
            equation.text = equation.text.toString().plus("×")
        }

        //TODO: row3
        bb_4.setOnClickListener {
            equation.text = equation.text.toString().plus("4")
        }
        bb_5.setOnClickListener {
            equation.text = equation.text.toString().plus("5")
        }
        bb_6.setOnClickListener {
            equation.text = equation.text.toString().plus("6")
        }
        bb_minus.setOnClickListener {
            equation.text = equation.text.toString().plus("-")
        }

        //TODO: row4
        bb_1.setOnClickListener {
            equation.text = equation.text.toString().plus("1")
        }
        bb_2.setOnClickListener {
            equation.text = equation.text.toString().plus("2")
        }
        bb_3.setOnClickListener {
            equation.text = equation.text.toString().plus("3")
        }
        bb_plus.setOnClickListener {
            equation.text = equation.text.toString().plus("+")
        }

        //TODO: row5
        bb_0.setOnClickListener {
            equation.text = equation.text.toString().plus("0")
        }
        bb_point.setOnClickListener {
            equation.text = equation.text.toString().plus(".")
        }
        bb_equal.setOnClickListener {
            try {
                var _result = Expression(getInputExpression()).calculate()
                if (_result.isNaN()) {
                    result.text = "ERROR!"
                    result.setTextColor(ContextCompat.getColor(this, R.color.red))
                } else {
                    result.text = DecimalFormat("0.#####").format(_result).toString();
                }
            } catch (e: Exception) {
                result.text = "ERROR!"
                result.setTextColor(ContextCompat.getColor(this, R.color.red))
            }
        }

    }

    fun getInputExpression(): String {
        return equation.text.replace(Regex("×"), "*").replace(Regex("÷"), "/")
    }
}