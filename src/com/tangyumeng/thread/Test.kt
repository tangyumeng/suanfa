package com.tangyumeng.thread

class Test {
    fun test() {
        val t = Thread {
            println("子线程开始执行")
            try {
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            println("子线程执行完毕")
        }

        t.start() // 启动线程

        println("主线程等待子线程结束")
        t.join() // 等待t线程执行完毕
        println("主线程继续执行")
    }
}

fun main() {
    val t = Test()
    t.test()
}