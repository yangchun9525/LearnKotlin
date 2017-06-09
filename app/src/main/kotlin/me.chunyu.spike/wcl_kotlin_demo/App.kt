package me.chunyu.spike.wcl_kotlin_demo

import android.app.Application
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by chun.yang on 2017/6/9.
 */
class App : Application() {
    /**
     * //类型后面加?表示可为空
        var age: String? = "23"
        //抛出空指针异常
        val ageInt = age!!.toInt()
        //不做处理跳过
        val ages = age?.toInt()
     */
    companion object {
        private var instance : Application? = null
        fun instance() = instance!!
    }

//    val database: SQLiteOpenHelper by lazy {
////        MyDatabaseHelper(applicationContext)
//    }

    override fun onCreate() {
        super.onCreate()
        instance = this
//        val db = database.writableDatabase
    }
}