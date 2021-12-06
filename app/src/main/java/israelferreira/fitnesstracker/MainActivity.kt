package israelferreira.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var btnBmi: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBmi = findViewById(R.id.btn_bmi)

        btnBmi.setOnClickListener {
            val intent = Intent(baseContext, BmiActivity::class.java)
            startActivity(intent)
        }
    }
}