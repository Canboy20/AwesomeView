package com.awesome.awesomeview.customViews

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import com.awesome.awesomeview.R
import com.awesome.awesomeview.enums.ColorEnum
import com.awesome.awesomeview.enums.CornerRadiusEnum
import com.awesome.awesomeview.enums.FontSizeEnum
import com.awesome.awesomeview.enums.FontStyleEnum
import com.awesome.awesomeview.objects.UINode

class AwesomeButton : android.support.v7.widget.AppCompatButton {


    companion object {
        private const val DEFAULT_TEXT_COLOR = Color.WHITE
        private const val DEFAULT_BACKGROUND_COLOR = Color.BLACK
        private const val DEFAULT_FONT_STYLE = "NORMAL"
        private const val DEFAULT_FONT_SIZE = 14f
        private const val DEFAULT_CORNER_RADIUS = 8f
    }



    //Colors
    private var awesomeTextColor = DEFAULT_TEXT_COLOR
    private var awesomeBackgroundColor = DEFAULT_BACKGROUND_COLOR

    //Size
    private var awesomeFontSize = DEFAULT_FONT_SIZE

    //Style
    private var awesomeFontStyle = DEFAULT_FONT_STYLE

    //Radius
    private var awesomeCornerRadius = DEFAULT_CORNER_RADIUS






    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }




    private fun init(attrs: AttributeSet?) {

        if (attrs != null) {

            val ta = context.obtainStyledAttributes(attrs, R.styleable.AwesomeButton)

            //Colors
            awesomeTextColor = ta.getColor(R.styleable.AwesomeButton_token_font_color_one, awesomeTextColor)
            awesomeBackgroundColor = ta.getColor(R.styleable.AwesomeButton_token_font_color_two, awesomeBackgroundColor)

            //Text sizes
            awesomeFontSize = ta.getDimension(R.styleable.AwesomeButton_token_font_size, 14f)

            ta.recycle()

        }

        updateAwesomeButtonView()

    }


    private fun updateAwesomeButtonView() {

        //Update view according to values
        setButtonBackground()
        setButtonTextSize()
        setButtonTextColor()
        setButtonTextFont()

    }


    fun updateAwesomeButtonViewWithUINode(uiNode: UINode) {

        awesomeFontSize = uiNode.fontSize
        awesomeFontStyle = uiNode.fontStyle
        awesomeBackgroundColor = uiNode.fontColor
        awesomeCornerRadius = uiNode.cornerRadius

        //Update view according to values
        setButtonBackground()
        setButtonTextSize()
        setButtonTextColor()
        setButtonTextFont()

    }


    private fun setButtonBackground() {

        val gradientDrawable = GradientDrawable()
        gradientDrawable.cornerRadius = awesomeCornerRadius
        gradientDrawable.setColor(awesomeBackgroundColor)
        background = gradientDrawable

    }


    private fun setButtonTextSize() {

        /*
        switch (getContext().getResources().getDisplayMetrics().densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                awesomeFontSize = FontSizeEnum.FONT_SIZE_SMALL.getFontSize();
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                awesomeFontSize = FontSizeEnum.FONT_SIZE_MEDIUM.getFontSize();
                break;
            case DisplayMetrics.DENSITY_HIGH:
                awesomeFontSize = FontSizeEnum.FONT_SIZE_HIGH.getFontSize();
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                awesomeFontSize = FontSizeEnum.FONT_SIZE_XHIGH.getFontSize();
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                awesomeFontSize = FontSizeEnum.FONT_SIZE_XXHIGH.getFontSize();
                break;
            case DisplayMetrics.DENSITY_XXXHIGH:
                awesomeFontSize = FontSizeEnum.FONT_SIZE_XXXHIGH.getFontSize();
                break;
            default:
                awesomeFontSize = FontSizeEnum.FONT_SIZE_MEDIUM.getFontSize();
                //Fill This later!
        }*/


        textSize = awesomeFontSize

    }


    private fun setButtonTextColor() {
        setTextColor(awesomeTextColor)
    }


    private fun setButtonTextFont() {

        when (awesomeFontStyle) {
            "NORMAL" -> setTypeface(typeface, Typeface.NORMAL)
            "ITALIC" -> setTypeface(typeface, Typeface.ITALIC)
            "BOLD" -> setTypeface(typeface, Typeface.BOLD)
        }


    }

}
