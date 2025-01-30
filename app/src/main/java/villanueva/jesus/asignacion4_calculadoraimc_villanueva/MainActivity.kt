package villanueva.jesus.asignacion4_calculadoraimc_villanueva

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val weight : EditText = findViewById(R.id.etPeso) as EditText
        val height : EditText = findViewById(R.id.etEstatura) as EditText
        val IMC : TextView = findViewById(R.id.etIMC) as TextView
        val range : TextView = findViewById(R.id.etRange) as TextView
        val boton : Button = findViewById(R.id.btnCalcular) as Button

        boton.setOnClickListener{
            val weightValue = weight.text.toString().toFloat()
            val heightValue = height.text.toString().toFloat()

            val calculo = weightValue / (heightValue * heightValue)

            IMC.text = String.format("%.2f",calculo)

            var categoria : String = ""
            var color: Int = R.color.white

            if (calculo < 18.5){
                categoria = "Bajo peso"
                color = R.color.colorGreenish
            }else if (calculo >= 18.5 && calculo <= 24.9){
                categoria = "Normal"
                color = R.color.colorGreen
            }else if ( calculo >= 25.0 && calculo <= 29.9){
                categoria = "Sobrepeso"
                color = R.color.colorYellow
            }else if (calculo >= 30.0 && calculo <= 34.9){
                categoria = "Obesidad grado 1"
                color = R.color.colorOrange
            }else if (calculo >= 35.0 && calculo <= 39.9){
                categoria = "Obesidad grado 2"
                color = R.color.colorRed
            }else if (calculo >= 40){
                categoria = "Obesidad grado 3"
                color = R.color.colorBrown
            }

            range.text = categoria
            range.setBackgroundResource(color)
        }



    }


}