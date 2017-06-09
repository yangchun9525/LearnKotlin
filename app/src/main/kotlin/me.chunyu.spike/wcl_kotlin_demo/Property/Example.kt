package me.chunyu.spike.wcl_kotlin_demo.Property

/**
 * Created by chun.yang on 2017/6/9.
 */
class Example {
    //使用了by这个关键字来指定一个委托对象
    var p : String by Delegate()
}