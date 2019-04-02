package com.awesome.awesomeview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.awesome.awesomeview.utils.UIFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateButtonViews()
    }


    private fun updateButtonViews(){

        awesome_button_one.updateAwesomeButtonViewWithUINode(UIFactory.createUI())
        awesome_button_two.updateAwesomeButtonViewWithUINode(UIFactory.createUI())
        awesome_button_three.updateAwesomeButtonViewWithUINode(UIFactory.createUI())
        awesome_button_four.updateAwesomeButtonViewWithUINode(UIFactory.createUI())
        awesome_button_five.updateAwesomeButtonViewWithUINode(UIFactory.createUI())
        awesome_button_six.updateAwesomeButtonViewWithUINode(UIFactory.createUI())
        //awesome_button_seven.updateAwesomeButtonViewWithUINode(UIFactory.createUI())
        //awesome_button_eight.updateAwesomeButtonViewWithUINode(UIFactory.createUI())



    }
}
