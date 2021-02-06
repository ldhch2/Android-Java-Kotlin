package com.example.midtwenties

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val arr="a b c d"
    val array=arr.split(" ")
    fun test(){
        print(array[0]+array[1]+array[2])
    }

}