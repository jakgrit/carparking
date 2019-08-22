package buu.informatics.s59160002.carparking

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.IntegerRes

class MainActivity : AppCompatActivity() {

    private var car1: Car = Car()
    private var car2: Car = Car()
    private var car3: Car = Car()

    private var obj1 = false
    private var obj2 = false
    private var obj3 = false

    private var check: String = ""

    private var status1 = false
    private var status2 = false
    private var status3 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.slot1_button).setOnClickListener { checkBtn("1") }
        findViewById<Button>(R.id.slot2_button).setOnClickListener { checkBtn("2") }
        findViewById<Button>(R.id.slot3_button).setOnClickListener { checkBtn("3") }

        findViewById<Button>(R.id.save_button).setOnClickListener { initValue() }
        findViewById<Button>(R.id.cancel_button).setOnClickListener { disableInput() }
        findViewById<Button>(R.id.delete_button).setOnClickListener { clearDataObj() }

        findViewById<Button>(R.id.delete_button).setBackgroundColor(Color.parseColor("#DC143C"))

        changeColorSelectBtn()
        disableInput()


        checkNulObj()
    }

    //clearData in Obj

    private fun clearDataObj(){
        val slt1 = findViewById<Button>(R.id.slot1_button)
        val slt2 = findViewById<Button>(R.id.slot2_button)
        val slt3 = findViewById<Button>(R.id.slot3_button)
        when (check) {
            "1" -> {
                car1.name = ""
                car1.carId = ""
                car1.surName = ""

                obj1 = false

                slt1.text = "ว่าง"
                slt1.setBackgroundColor(Color.parseColor("#00FF00"))
            }
            "2" -> {
                car2.name = ""
                car2.carId = ""
                car2.surName = ""

                obj2 = false

                slt2.text = "ว่าง"
                slt2.setBackgroundColor(Color.parseColor("#00FF00"))
            }
            else -> {
                car3.name = ""
                car3.carId = ""
                car3.surName = ""

                obj3 = false

                slt3.text = "ว่าง"
                slt3.setBackgroundColor(Color.parseColor("#00FF00"))
            }
        }

        showText()
        checkNulObj()
    }

    //hideInput & button
    private fun disableInput(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)
        val saveBtn = findViewById<Button>(R.id.save_button)
        val cancelBtn = findViewById<Button>(R.id.cancel_button)
        val deleteBtn = findViewById<Button>(R.id.delete_button)

        carID.visibility = View.GONE
        firstName.visibility = View.GONE
        lastName.visibility = View.GONE
        saveBtn.visibility = View.GONE
        cancelBtn.visibility = View.GONE
        deleteBtn.visibility = View.GONE


        checkNulObj()

    }

    //showInput & button
    private fun enableInput(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)
        val saveBtn = findViewById<Button>(R.id.save_button)
        val cancelBtn = findViewById<Button>(R.id.cancel_button)
        val deleteBtn = findViewById<Button>(R.id.delete_button)

        carID.visibility = View.VISIBLE
        firstName.visibility = View.VISIBLE
        lastName.visibility = View.VISIBLE
        saveBtn.visibility = View.VISIBLE
        cancelBtn.visibility = View.VISIBLE
        deleteBtn.visibility = View.VISIBLE


        checkNulObj()
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


        checkNulObj()
    }

    //initialValue to DataClass
    private fun initValue(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)

        if(carID.text.toString() != "" && firstName.text.toString() != "" && lastName.text.toString() != ""){
            when (check) {
                "1" -> {
                    car1.carId = carID.text.toString()
                    car1.name = firstName.text.toString()
                    car1.surName = lastName.text.toString()

                    obj1 = true
                }
                "2" -> {
                    car2.carId = carID.text.toString()
                    car2.name = firstName.text.toString()
                    car2.surName = lastName.text.toString()

                    obj2 = true
                }
                "3" -> {
                    car3.carId = carID.text.toString()
                    car3.name = firstName.text.toString()
                    car3.surName = lastName.text.toString()

                    obj3 = true
                }
            }
            Toast.makeText(this, "เพิ่มข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"กรุณากรอกข้อมูลให้ครบทุกช่อง", Toast.LENGTH_SHORT).show()
        }
        clearInput()
        showText()

        checkNulObj()
    }

    //clearAllInput
    private fun clearInput(){
        val carID = findViewById<EditText>(R.id.carId_editText)
        val firstName = findViewById<EditText>(R.id.name_editText)
        val lastName = findViewById<EditText>(R.id.surname_editText)

        carID.setText("")
        firstName.setText("")
        lastName.setText("")

        checkNulObj()
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

        checkNulObj()
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


        checkNulObj()
    }

    private fun checkNulObj(){
        val slt1 = findViewById<Button>(R.id.slot1_button)
        val slt2 = findViewById<Button>(R.id.slot2_button)
        val slt3 = findViewById<Button>(R.id.slot3_button)

        if(obj1){
            slt1.text = "ไม่ว่าง"
            slt1.setBackgroundColor(Color.parseColor("#DC143C"))
        }
        if (obj2){
            slt2.text = "ไม่ว่าง"
            slt2.setBackgroundColor(Color.parseColor("#DC143C"))
        }
        if (obj3){
            slt3.text = "ไม่ว่าง"
            slt3.setBackgroundColor(Color.parseColor("#DC143C"))
        }

    }

}
