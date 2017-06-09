package me.chunyu.spike.wcl_kotlin_demo.domain

/**
 * Created by chun.yang on 2017/6/8.
 */
public interface Command<T> {
    fun execute(): T
}