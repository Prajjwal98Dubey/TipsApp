package com.example.tipsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var et_amount:TextView
    lateinit var t_tip:TextView
    lateinit var seekBar:SeekBar
    lateinit var t_comment:TextView
    lateinit var t_res:TextView
    lateinit var t_amount:TextView
    lateinit var t_percent:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_amount=findViewById(R.id.et_amount)
        t_tip=findViewById(R.id.t_tip)
        seekBar=findViewById(R.id.seekBar)
        t_comment=findViewById(R.id.t_comment)
        t_res=findViewById(R.id.t_res)
        t_amount=findViewById(R.id.t_amount)
        t_percent=findViewById(R.id.t_percent)

        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                t_percent.text="$p1%"
                updateComment(p1)
                val amount=et_amount.text.toString().toInt()
                val calulate_amount=(amount + (amount*p1)/100)
                t_amount.text="$calulate_amount"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })





    }

    private fun updateComment(p1: Int) {
            val output= when(p1){
                 in 0..15->"NOT BAD"
                 in 16..25->"AVERAGE"
                 in 26..38->"GOOD"
                 else->"EXCELLENT"
             }
            t_comment.text="$output"

    }
}