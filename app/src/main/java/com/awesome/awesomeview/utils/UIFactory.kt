package com.awesome.awesomeview.utils

import com.awesome.awesomeview.enums.ColorEnum
import com.awesome.awesomeview.enums.CornerRadiusEnum
import com.awesome.awesomeview.enums.FontSizeEnum
import com.awesome.awesomeview.enums.FontStyleEnum
import com.awesome.awesomeview.objects.UINode

import java.util.Random

object UIFactory {

    private val random = Random()


    fun createUI(): UINode {

        val fontSizeEnum = randomEnum(FontSizeEnum::class.java)
        val fontStyleEnum = randomEnum(FontStyleEnum::class.java)
        val colorEnum = randomEnum(ColorEnum::class.java)
        val cornerRadiusEnum = randomEnum(CornerRadiusEnum::class.java)


        return UINode(
            fontSizeEnum.fontSize,
            fontStyleEnum.fontStyle,
            colorEnum.fontColor,
            cornerRadiusEnum.cornerRadius
        )

    }


    private fun <T : Enum<*>> randomEnum(clazz: Class<T>): T {
        val x = random.nextInt(clazz.enumConstants.size)
        return clazz.enumConstants[x]
    }

}

