package com.iamageo.beautiful_dialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iamageo.beautiful_dialog.databinding.ActivityMainBinding
import com.iamageo.library.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupDialogButtons()
    }


    private fun setupDialogButtons() {
        binding.btnSuccess.setOnClickListener {
            BeautifulDialog.build(this)
                .title("Title success", titleColor = R.color.black)
                .description("Description success", color = R.color.black)
                .position(BeautifulDialog.POSITIONS.CENTER)
                .type(BeautifulDialog.TYPE.SUCCESS)
                .onPositive("Confirm", shouldIDismissOnClick = false) {
                    Toast.makeText(this, "confirm", Toast.LENGTH_SHORT).show()
                }
                .onNegative("Cancel") {
                    Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show()
                }
                .hideNegativeButton(hide = false)
        }


        binding.btnError.setOnClickListener {
            BeautifulDialog.build(this)
                .title("Title error", titleColor = R.color.black)
                .description("Description error", color = R.color.black)
                .position(BeautifulDialog.POSITIONS.CENTER)
                .type(BeautifulDialog.TYPE.ERROR)
                .onPositive("Confirm", shouldIDismissOnClick = false) {
                    Toast.makeText(this, "confirm", Toast.LENGTH_SHORT).show()
                }
                .onNegative("Cancel") {
                    Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show()
                }
                .hideNegativeButton(hide = false)
        }


        binding.btnInfo.setOnClickListener {
            BeautifulDialog.build(this)
                .title("Title info", titleColor = R.color.black)
                .description("Description info", color = R.color.black)
                .position(BeautifulDialog.POSITIONS.CENTER)
                .type(BeautifulDialog.TYPE.INFO)
                .onPositive("Confirm", shouldIDismissOnClick = false) {
                    Toast.makeText(this, "confirm", Toast.LENGTH_SHORT).show()
                }
                .onNegative("Cancel") {
                    Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show()
                }
                .hideNegativeButton(hide = false)
        }


        binding.btnAlert.setOnClickListener {
            BeautifulDialog.build(this)
                .title("Title alert", titleColor = R.color.black)
                .description("Description alert", color = R.color.black)
                .position(BeautifulDialog.POSITIONS.CENTER)
                .type(BeautifulDialog.TYPE.ALERT)
                .onPositive("Confirm", shouldIDismissOnClick = false) {
                    Toast.makeText(this, "confirm", Toast.LENGTH_SHORT).show()
                }
                .onNegative("Cancel") {
                    Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show()
                }
                .hideNegativeButton(hide = false)
        }

    }
}