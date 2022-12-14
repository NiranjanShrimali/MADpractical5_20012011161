package com.example.madpractical5_20012011161
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
class MainActivity : AppCompatActivity() {
    private lateinit var playbtn : FloatingActionButton
    private lateinit var stopbtn : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playbtn = findViewById(R.id.playbutton)

        playbtn.setOnClickListener(View.OnClickListener {
            play()
        })
        stopbtn = findViewById(R.id.stopbutton)

        stopbtn.setOnClickListener(View.OnClickListener {
            stop()
        })
    }
    private fun play(){
        Intent(applicationContext,
            MyService::class.java).putExtra(MyService.DATA_KEY,MyService.DATA_VALUE).apply {
            startService(this) }
    }
    private fun stop(){

        Intent(applicationContext,MyService::class.java)
            .apply { stopService(this) }
    }
}


//package com.example.madpractical5_20012011161
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.google.android.material.floatingactionbutton.FloatingActionButton
//
//class MainActivity : AppCompatActivity() {
//    @SuppressLint("UseCompatLoadingforDrawables")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//    val play=findViewById<FloatingActionButton>(R.id.playbutton)
//    val stop=findViewById<FloatingActionButton>(R.id.stopbutton)
//    var count = 0
//    play.setOnClickListener{
//        count++
//        play()
//        if(count%2!=0)
//        {
//
//            play.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_pause_24))
//        }
//        else
//        {
//
//            play.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_play_arrow_24))
//        }
//    }
//    stop.setOnClickListener {
//        stop()
//    }
//}
//    private fun play() {
//        Intent(applicationContext,
//            MyService::class.java).putExtra(MyService.DATA_KEY,
//            MyService.DATA_VALUE).apply{
//            startService(this)
//        }
//    }
//    private fun stop() {
//        Intent(applicationContext,
//            MyService::class.java).apply {
//            stopService(this)
//        }
//    }
//}

//    fun play(){
//        Intent(applicationContext,MyService::class.java).putExtra(MyService.DATA_KEY,MyService.DATA_VALUE).apply { startService(this) }
//    }
//
//    fun stop(){
//        Intent(applicationContext,MyService::class.java).apply { stopService(this) }
//    }
//}