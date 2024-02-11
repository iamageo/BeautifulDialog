package com.iamageo.library

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.graphics.Typeface
import android.util.TypedValue
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
        CENTER, BOTTOM, TOP
    }

    /***
     * Types For Alert Dialog
     * */
    enum class TYPE {
        SUCCESS, INFO, ALERT, ERROR, NONE
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
    fontSize: Int = 0,
    titleColor: Int = 0
): AlertDialog {
    binding.title.text = title.trim()
    if (fontStyle != null) {
        binding.title.typeface = fontStyle
    }
    if (fontSize != 0) {
        binding.subHeading.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize.toFloat())
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
fun AlertDialog.dialogAnimation(
    resId: Int
): AlertDialog {
    binding.dialogAnimation.setAnimation(resId)
    return this
}

/***
 * Positions of Alert Dialog
 * */
fun AlertDialog.position(position: BeautifulDialog.POSITIONS): AlertDialog {
    binding.mainLayout.post {
        val params = binding.mainLayout.layoutParams as RelativeLayout.LayoutParams
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0)
        params.addRule(RelativeLayout.CENTER_IN_PARENT, 0)
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0)
        when (position) {
            BeautifulDialog.POSITIONS.TOP -> {
                params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE)
                val density = context.resources.displayMetrics.density
                val marginInPixels = (1000 * density).toInt()
                params.bottomMargin = marginInPixels
            }

            BeautifulDialog.POSITIONS.CENTER -> params.addRule(
                RelativeLayout.CENTER_IN_PARENT,
                RelativeLayout.TRUE
            )

            BeautifulDialog.POSITIONS.BOTTOM -> params.addRule(
                RelativeLayout.ALIGN_PARENT_BOTTOM,
                RelativeLayout.TRUE
            )
        }

        binding.mainLayout.layoutParams = params
        binding.mainLayout.requestLayout()
    }
    return this
}


/***
 * Sub Title or Body of Alert Dialog
 * */
fun AlertDialog.description(
    description: String,
    fontStyle: Typeface? = null,
    fontSize: Int = 0,
    color: Int = 0
): AlertDialog {
    binding.subHeading.text = description.trim()
    binding.subHeading.show()
    if (fontStyle != null) {
        binding.subHeading.typeface = fontStyle
    }
    if (fontSize != 0) {
        binding.subHeading.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize.toFloat())
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
            binding.dialogAnimation.setAnimation(R.raw.success)
        }

        BeautifulDialog.TYPE.INFO -> {
            binding.dialogAnimation.setAnimation(R.raw.info)
        }

        BeautifulDialog.TYPE.ALERT -> {
            binding.dialogAnimation.setAnimation(R.raw.alert)
        }

        BeautifulDialog.TYPE.ERROR -> {
            binding.dialogAnimation.setAnimation(R.raw.error)
        }

        BeautifulDialog.TYPE.NONE -> {
            binding.dialogAnimation.hide()
            binding.dialogAnimation.layoutParams.height = 0

        }
    }
    binding.dialogAnimation.show()

    return this
}

/***
 * onPositive Button Properties For Alert Dialog
 *
 * No Need to call dismiss(). It is calling already
 * */
fun AlertDialog.onPositive(
    text: String,
    fontStyle: Typeface? = null,
    buttonBackgroundColor: Int? = null,
    textColor: Int? = null,
    shouldIDismissOnClick: Boolean = true,
    action: (() -> Unit)? = null,
): AlertDialog {
    binding.yesButton.show()
    if (fontStyle != null) {
        binding.yesButton.typeface = fontStyle
    }
    if (buttonBackgroundColor != null) {
        binding.yesButton.setBackgroundResource(buttonBackgroundColor)
    }
    if (textColor != null) {
        binding.yesButton.setTextColor(textColor)
    }
    binding.yesButton.text = text.trim()
    binding.yesButton.setOnClickListener {
        action?.invoke()
        if (shouldIDismissOnClick) dismiss()
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
    fontStyle: Typeface? = null,
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
    if (fontStyle != null) {
        binding.noButton.typeface = fontStyle
    }
    if (buttonBackgroundColor != null) {
        binding.noButton.setBackgroundResource(buttonBackgroundColor)
    }
    binding.noButton.setOnClickListener {
        action?.invoke()
        if (shouldIDismissOnClick) dismiss()
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
