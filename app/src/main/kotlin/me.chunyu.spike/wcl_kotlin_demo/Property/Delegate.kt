package me.chunyu.spike.wcl_kotlin_demo.Property

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by chun.yang on 2017/6/9.
 */
class Delegate<T> : ReadWriteProperty<Any?, T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}