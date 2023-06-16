package com.example.a4_7_6_kotlin

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.a4_7_6_kotlin.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view:View =binding.root
        setContentView(view)

        initviews()
    }
    fun initviews(){

        binding.btHome.setOnClickListener {
            val text = binding.etHome.text.toString()

            //  String text = "I would like to visit https://www.google.com and https://www.youtube.com";
            val spannable = SpannableString(text)
            val pattern = Pattern.compile("(https?://\\S+)")
            val matcher = pattern.matcher(spannable)
            while (matcher.find()) {
                val start = matcher.start()
                val end = matcher.end()
                spannable.setSpan(object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        // Handle click event here
                    }

                    override fun updateDrawState(ds: TextPaint) {
                        super.updateDrawState(ds)
                        ds.color = Color.BLUE
                        ds.isUnderlineText = false
                    }
                }, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            binding.tvClone.text = spannable
            binding.tvClone.movementMethod = LinkMovementMethod.getInstance()
        }

    }
}