package buu.informatics.s59160002.carparking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var car1: Car = Car()
    private var car2: Car = Car()
    private var car3: Car = Car()

    private var check: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.slot1_button).setOnClickListener { checkBtn(it, "1") }
        findViewById<Button>(R.id.slot2_button).setOnClickListener { checkBtn(it, "2") }
        findViewById<Button>(R.id.slot3_button).setOnClickListener { checkBtn(it, "3") }

        findViewById<Button>(R.id.save_button).setOnClickListener { initValue() }
        findViewById<Button>(R.id.cancel_button).setOnClickListener { initValue() }

        disableInput()
    }

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

    private fun checkBtn(view: View, idx: String){
        if(idx.equals("1")){
            enableInput()
            check = "1"
        }else if(idx.equals("2")){
            enableInput()
            check = "2"
        }else if(idx.equals("3")){
            enableInput()
            check = "3"
        }
        clearInput()
    }

    private fun initValue(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)

        if(check == "1"){
            car1.carId = carID.text.toString()
            car1.name = firstName.text.toString()
            car1.surName = lastName.text.toString()
        }else if(check == "2"){
            car2.carId = carID.text.toString()
            car2.name = firstName.text.toString()
            car2.surName = lastName.text.toString()
        }else{
            car3.carId = carID.text.toString()
            car3.name = firstName.text.toString()
            car3.surName = lastName.text.toString()
        }
        clearInput()
        showText()
    }

    private fun clearInput(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)

        carID.setText("")
        firstName.setText("")
        lastName.setText("")
    }

    private fun showText(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)

        if(check == "1"){
            carID.setText(car1.carId)
            firstName.setText(car1.name)
            lastName.setText(car1.surName)
        }else if(check == "2"){
            carID.setText(car2.carId)
            firstName.setText(car2.name)
            lastName.setText(car2.surName)
        }else{
            carID.setText(car3.carId)
            firstName.setText(car3.name)
            lastName.setText(car3.surName)
        }
    }
}
