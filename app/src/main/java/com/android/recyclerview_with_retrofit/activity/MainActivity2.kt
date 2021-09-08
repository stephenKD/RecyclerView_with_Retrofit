package com.android.recyclerview_with_retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.recyclerview_with_retrofit.R
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}


/**
 * Coroutine practice.
 * */
fun main() = runBlocking {
    val job = launch {
        val ans = async {
            callApi()
        }
        val ans2 = async {
            callApi2()
        }
        println(ans.await() + ans2.await())
    }
    delay(2000)
    job.cancel()
//    println(time)
    println("start")
}

//GlobalScope.launch {
//
//}

suspend fun callApi(): String {
    println("start1")
    delay(1000)
    println("return_1")
    return "callApi_1"
}

suspend fun callApi2(): String {
    println("start2")
    delay(3000)
    println("return_2")
    return "callApi_2"
}