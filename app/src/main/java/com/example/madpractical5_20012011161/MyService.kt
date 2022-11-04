package com.example.madpractical5_20012011161
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {
    companion object{
        public val DATA_KEY="service"
        val DATA_VALUE="play/pause"
    }

    private lateinit var player: MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(!this::player.isInitialized){
            player=MediaPlayer.create(this,R.raw.song)
        }
        if(intent!=null){
            val str=intent.getStringExtra(DATA_KEY)
            if(str== DATA_VALUE){
                if(player.isPlaying){
                    player.pause()
                }
                else{
                    player.start()
                }
            }
        }

        else{
            player.start()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        player.stop()
        super.onDestroy()
    }
}









//package com.example.madpractical5_20012011161
//import android.app.Service
//import android.content.Intent
//import android.media.MediaPlayer
//import android.os.IBinder
//class MediaService : Service() {
//    private lateinit var MyService:MediaPlayer
//    companion object{
//        public final val DATA_KEY = "Service"
//        public final val DATA_VALUE = "Play/Pause"
//    }
//    // companion object means statc object created
//    override fun onBind(intent: Intent): IBinder {
//        TODO("Return the communication channel to the service.")
//    }
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        if (!this::MyService.isInitialized){
//            MyService=MediaPlayer.create(this,R.raw.song)
//        }
//        if (intent!=null){
//            val str = intent.getStringExtra(DATA_KEY)
//            if (str==DATA_VALUE)
//            {
//                if (!MyService.isPlaying){
//                    MyService.start()
//                }
//                else{
//                    MyService.pause()
//                }
//            }
//        }
//        else{
//            MyService.start()
//        }
//        return START_STICKY
//    }
//    override fun onDestroy() {
//        MyService.stop()
//        super.onDestroy()
//    }
//}







