package buu.informatics.s59160002.carparking

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var car1: Car = Car()
    private var car2: Car = Car()
    private var car3: Car = Car()

    private var check: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.slot1_button).setOnClickListener { checkBtn("1") }
        findViewById<Button>(R.id.slot2_button).setOnClickListener { checkBtn("2") }
        findViewById<Button>(R.id.slot3_button).setOnClickListener { checkBtn("3") }

        findViewById<Button>(R.id.save_button).setOnClickListener { initValue() }
        findViewById<Button>(R.id.cancel_button).setOnClickListener { disableInput() }

        changeColorSelectBtn()
        disableInput()
    }

    //hideInput & button
    private fun disableInput(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)
        val saveBtn = findViewById<Button>(R.id.save_button)
        val cancelBtn = findViewById<Button>(R.id.cancel_button)

        carID.visibility = View.GONE
        firstName.visibility = View.GONE
        lastName.visibility = View.GONE
        saveBtn.visibility = View.GONE
        cancelBtn.visibility = View.GONE

    }

    //showInput & button
    private fun enableInput(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)
        val saveBtn = findViewById<Button>(R.id.save_button)
        val cancelBtn = findViewById<Button>(R.id.cancel_button)

        carID.visibility = View.VISIBLE
        firstName.visibility = View.VISIBLE
        lastName.visibility = View.VISIBLE
        saveBtn.visibility = View.VISIBLE
        cancelBtn.visibility = View.VISIBLE
    }

    //checkSelectedButton
    private fun checkBtn(idx: String){



        clearInput()

        when (idx) {
            "1" -> {
                enableInput()
                check = "1"
                changeColorSelectBtn()
            }
            "2" -> {
                enableInput()
                check = "2"
                changeColorSelectBtn()
            }
            "3" -> {
                enableInput()
                check = "3"
                changeColorSelectBtn()
            }
        }
        showText()
    }

    //initialValue to DataClass
    private fun initValue(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)

        when (check) {
            "1" -> {
                car1.carId = carID.text.toString()
                car1.name = firstName.text.toString()
                car1.surName = lastName.text.toString()
            }
            "2" -> {
                car2.carId = carID.text.toString()
                car2.name = firstName.text.toString()
                car2.surName = lastName.text.toString()
            }
            "3" -> {
                car3.carId = carID.text.toString()
                car3.name = firstName.text.toString()
                car3.surName = lastName.text.toString()
            }
        }
        clearInput()
        showText()
    }

    //clearAllInput
    private fun clearInput(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)

        carID.setText("")
        firstName.setText("")
        lastName.setText("")
    }

    //showData to Input
    private fun showText(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)

        when (check) {
            "1" -> {
                carID.setText(car1.carId)
                firstName.setText(car1.name)
                lastName.setText(car1.surName)
            }
            "2" -> {
                carID.setText(car2.carId)
                firstName.setText(car2.name)
                lastName.setText(car2.surName)
            }
            "3" -> {
                carID.setText(car3.carId)
                firstName.setText(car3.name)
                lastName.setText(car3.surName)
            }
        }
    }

    //changeColor
    private fun changeColorSelectBtn(){
        val slt1 = findViewById<Button>(R.id.slot1_button)
        val slt2 = findViewById<Button>(R.id.slot2_button)
        val slt3 = findViewById<Button>(R.id.slot3_button)

        val saveBtn = findViewById<Button>(R.id.save_button)
        val cancelBtn = findViewById<Button>(R.id.cancel_button)

        saveBtn.setBackgroundColor(Color.parseColor("#32CD32"))
        cancelBtn.setBackgroundColor(Color.parseColor("#B22222"))

        when(check){
            "1" -> {
                slt1.setBackgroundColor(Color.parseColor("#A52A2A"))

                slt2.setBackgroundColor(Color.parseColor("#32CD32"))
                slt3.setBackgroundColor(Color.parseColor("#32CD32"))
            }
            "2" -> {
                slt2.setBackgroundColor(Color.parseColor("#A52A2A"))

                slt1.setBackgroundColor(Color.parseColor("#32CD32"))
                slt3.setBackgroundColor(Color.parseColor("#32CD32"))
            }
            "3" -> {
                slt3.setBackgroundColor(Color.parseColor("#A52A2A"))

                slt1.setBackgroundColor(Color.parseColor("#32CD32"))
                slt2.setBackgroundColor(Color.parseColor("#32CD32"))
            }
            else -> {
                slt1.setBackgroundColor(Color.parseColor("#32CD32"))
                slt2.setBackgroundColor(Color.parseColor("#32CD32"))
                slt3.setBackgroundColor(Color.parseColor("#32CD32"))
            }
        }
    }
}
