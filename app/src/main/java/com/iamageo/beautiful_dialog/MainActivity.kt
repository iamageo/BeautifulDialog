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
            .title("Example success", titleColor = R.color.black)
            .body("Example sucess",  color = R.color.black)
            .type(type= BeautifulDialog.TYPE.SUCCESS)
            .position(BeautifulDialog.POSITIONS.CENTER)
            .onPositive("positive button") {
                Toast.makeText(this, "positive", Toast.LENGTH_SHORT).show()
            }
            .onNegative("negative button") {
                Toast.makeText(this, "negative", Toast.LENGTH_SHORT).show()
            }
    }
}