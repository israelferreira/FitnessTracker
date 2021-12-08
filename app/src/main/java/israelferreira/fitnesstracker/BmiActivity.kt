package israelferreira.fitnesstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes

class BmiActivity : AppCompatActivity() {

    private lateinit var editHeight: EditText
    private lateinit var editWeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        editHeight = findViewById(R.id.edit_bmi_height)
        editWeight = findViewById(R.id.edit_bmi_weight)

        val btnSend: Button = findViewById(R.id.btn_bmi_send)

        btnSend.setOnClickListener {
            if (!validate()) {
                Toast.makeText(baseContext, R.string.field_messages, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val sHeight: String = editHeight.text.toString()
            val sWeight: String = editWeight.text.toString()

            val height: Int = Integer.parseInt(sHeight)
            val weight: Int = Integer.parseInt(sWeight)

            val result: Double = calculateBmi(height, weight)
            Log.d("TESTE", "Resultado: $result")

            val bmiResponseId: Int = bmiResponse(result)

            Toast.makeText(baseContext, bmiResponseId, Toast.LENGTH_SHORT).show()
        }
    }

    @StringRes
    private fun bmiResponse(bmi: Double): Int {
        if (bmi < 15)
            return R.string.bmi_severely_low_weight
        else if (bmi < 16)
            return R.string.bmi_very_low_weight
        else if (bmi < 18.5)
            return R.string.bmi_low_weight
        else if (bmi < 25)
            return R.string.bmi_normal
        else if (bmi < 30)
            return R.string.bmi_high_weight
        else if (bmi < 35)
            return R.string.bmi_so_high_weight
        else if (bmi < 40)
            return R.string.bmi_severely_high_weight
        else
            return R.string.bmi_extreme_weight
    }

    private fun calculateBmi(height: Int, weight: Int): Double {
        return weight / ( (height.toDouble() / 100) * (height.toDouble() / 100) )
    }

    private fun validate(): Boolean {
        return (!editHeight.text.startsWith("0")
                && !editWeight.text.startsWith("0")
                && editHeight.text.isNotEmpty()
                && editWeight.text.isNotEmpty())
    }
}