package com.iamageo.beautiful_dialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iamageo.library.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Simple example
        BeautifulDialog.build(this)
            .title("Title success", titleColor = R.color.black)
            .description("Description success", color = R.color.black)
            .type(type = BeautifulDialog.TYPE.SUCCESS)
            .position(BeautifulDialog.POSITIONS.CENTER)
            .onPositive("Confirm") {
                Toast.makeText(this, "confirm", Toast.LENGTH_SHORT).show()
            }
            .onNegative("Cancel") {
                Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show()
            }
            .hideNegativeButton(hide = false)
            .setCancelable(true)
    }
}