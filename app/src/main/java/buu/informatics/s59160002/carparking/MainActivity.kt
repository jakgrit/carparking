package buu.informatics.s59160002.carparking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}
