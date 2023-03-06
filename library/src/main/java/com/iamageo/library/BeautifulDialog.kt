package com.iamageo.library

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.iamageo.library.BeautifulDialog.Companion.binding
import com.iamageo.library.databinding.BeautifulDialogBinding

class BeautifulDialog {

    /***
     * Positions For Alert Dialog
     * */
    enum class POSITIONS {
        CENTER, BOTTOM
    }

    /***
     * Types For Alert Dialog
     * */
    enum class TYPE {
        SUCCESS, INFO, ALERT, ERROR
    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var binding: BeautifulDialogBinding

        /***
         * core method For Alert Dialog
         * */
        fun build(
            context: Activity
        ): AlertDialog {
            binding = BeautifulDialogBinding.inflate(LayoutInflater.from(context))
            val alertDialog =
                AlertDialog.Builder(
                    context, R.style.beautiful_dialog
                )
                    .setView(binding.root)
            val alert: AlertDialog = alertDialog.create()
            alert.show()
            return alert
        }
    }
}

/***
 * Title Properties For Alert Dialog
 * */
fun AlertDialog.title(
    title: String,
    fontStyle: Typeface? = null,
    titleColor: Int = 0
): AlertDialog {
    binding.title.text = title.trim()
    if (fontStyle != null) {
        binding.title.typeface = fontStyle
    }
    if (titleColor != 0) {
        binding.title.setTextColor(titleColor)
    }
    binding.title.show()
    return this
}

/***
 * Dialog Background properties For Alert Dialog
 * */
fun AlertDialog.background(
    dialogBackgroundColor: Int? = null
): AlertDialog {
    if (dialogBackgroundColor != null) {
        binding.mainLayout.setBackgroundResource(dialogBackgroundColor)
    }
    return this
}

/***
 * Dialog icon [resId] property for Alert Dialog
 */
fun AlertDialog.dialogIcon(
    resId: Int
) : AlertDialog {
    binding.image.setImageResource(resId)
    return this
}


/***
 * Dialog icon [drawable] property for Alert Dialog
 */
fun AlertDialog.dialogIcon(
    icon: Drawable
) : AlertDialog {
    binding.image.setImageDrawable(icon)
    return this
}


/***
 * Positions of Alert Dialog
 * */
fun AlertDialog.position(
    position: BeautifulDialog.POSITIONS = BeautifulDialog.POSITIONS.BOTTOM
): AlertDialog {
    val layoutParams = binding.mainLayout.layoutParams as RelativeLayout.LayoutParams
    if (position == BeautifulDialog.POSITIONS.CENTER) {
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
    } else if (position == BeautifulDialog.POSITIONS.BOTTOM) {
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
    }
    binding.mainLayout.layoutParams = layoutParams
    return this
}

/***
 * Sub Title or Body of Alert Dialog
 * */
fun AlertDialog.description(
    description: String,
    fontStyle: Typeface? = null,
    color: Int = 0
): AlertDialog {
    binding.subHeading.text = description.trim()
    binding.subHeading.show()
    if (fontStyle != null) {
        binding.subHeading.typeface = fontStyle
    }
    if (color != 0) {
        binding.subHeading.setTextColor(color)
    }
    return this
}

/***
 * Icon of  Alert Dialog
 * */
fun AlertDialog.type(
    type: BeautifulDialog.TYPE
): AlertDialog {
    when (type) {
        BeautifulDialog.TYPE.SUCCESS -> {
            binding.image.setImageResource(R.drawable.ic_success)
        }
        BeautifulDialog.TYPE.INFO -> {
            binding.image.setImageResource(R.drawable.ic_info)
        }
        BeautifulDialog.TYPE.ALERT -> {
             binding.image.setImageResource(R.drawable.ic_alert)
        }
        BeautifulDialog.TYPE.ERROR -> {
            binding.image.setImageResource(R.drawable.ic_error)
        }
    }
    binding.image.show()

    return this
}

/***
 * onPositive Button Properties For Alert Dialog
 *
 * No Need to call dismiss(). It is calling already
 * */
fun AlertDialog.onPositive(
    text: String,
    buttonBackgroundColor: Int? = null,
    textColor: Int? = null,
    shouldIDismissOnClick: Boolean = true,
    action: (() -> Unit)? = null,
): AlertDialog {
    binding.yesButton.show()
    if (buttonBackgroundColor != null) {
        binding.yesButton.setBackgroundResource(buttonBackgroundColor)
    }
    if (textColor != null) {
        binding.yesButton.setTextColor(textColor)
    }
    binding.yesButton.text = text.trim()
    binding.yesButton.setOnClickListener {
        action?.invoke()
        if(shouldIDismissOnClick) dismiss()
    }
    return this
}

/***
 * onNegative Button Properties For Alert Dialog
 *
 * No Need to call dismiss(). It is calling already
 * */
fun AlertDialog.onNegative(
    text: String,
    buttonBackgroundColor: Int? = null,
    textColor: Int? = null,
    shouldIDismissOnClick: Boolean = true,
    action: (() -> Unit)? = null
): AlertDialog {
    binding.noButton.show()
    binding.noButton.text = text.trim()
    if (textColor != null) {
        binding.noButton.setTextColor(textColor)
    }
    if (buttonBackgroundColor != null) {
        binding.noButton.setBackgroundResource(buttonBackgroundColor)
    }
    binding.noButton.setOnClickListener {
        action?.invoke()
        if(shouldIDismissOnClick) dismiss()
    }
    return this
}

/***
 * cancelNegativeButton defines if the cancel button should be displayed
 * */
fun AlertDialog.hideNegativeButton(
    hide: Boolean = false
): AlertDialog {
    if (hide) {
        binding.noButton.hide()
        val constraintSet = ConstraintSet()

        constraintSet.clone(binding.mainLayoutButtons)
        constraintSet.connect(
            R.id.yesButton,
            ConstraintSet.START,
            R.id.mainLayoutButtons,
            ConstraintSet.START,
            0
        );
        constraintSet.applyTo(binding.mainLayoutButtons)
    }
    return this
}
