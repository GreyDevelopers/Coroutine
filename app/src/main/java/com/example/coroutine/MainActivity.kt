package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val TAG = "Mainctivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. coroutine executes inside the thread
        // 2. coroutines are suspendable

        Log.d(TAG, "${Thread.currentThread().name}")



        GlobalScope.launch(Dispatchers.IO) {
            val networkResult = network()

            withContext(Dispatchers.Main){
                Toast.makeText(this@MainActivity,networkResult,Toast.LENGTH_SHORT).show()
            }


        }

    }
    suspend fun network():String{
        return "This is a network call"
    }
}