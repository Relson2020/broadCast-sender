package com.example.broadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.example.broadcast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        binding.button.setOnClickListener {
            val intent = Intent()
            intent.setAction("com.heyitsbroadcast.myBroadcast")
            intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            intent.putExtra("key","hey it broadCast")
            sendBroadcast(intent)
        }
    }
}