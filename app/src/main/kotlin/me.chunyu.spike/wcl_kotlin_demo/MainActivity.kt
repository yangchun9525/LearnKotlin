package me.chunyu.spike.wcl_kotlin_demo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.LayoutParams
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Kotlin的主类, 添加设置属性.
 */
class MainActivity : AppCompatActivity() {

    //val表示不能修改类似于final，var可修改
    var number1 = 1
    val number2 = 2
    //显式声明为String类型
    var info: String = "haha"
    var list:List<String> = listOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_tv_message.text = getString(R.string.hello_kotlin)
        main_tv_message.textSize = 20.0f
        // 自定义LinearLayout, val是不可改变immutable, var是可以改变mutable.
        val view = v<LinearLayout> {
            layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            orientation = LinearLayout.VERTICAL

            // 设置属性
            v<TextView> {
                layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
                //                text = info + number1 + number2 + "hello"
//                useList(list)
//                judgeIsNull(list)
//                useFor(list)
                printSum(number1,number2);
                text = info + sum2(number1, number2) + "hello"
                setTextColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                padLeft = dp_i(20.0f);
            }

            v<TextView> {
                layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
                text = "World"
                setTextColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
            }
        }

        main_ll_container.addView(view)
    }

    fun max(a:Int,b:Int):Int = if(a > b) a else b

    fun sum(a : Int,b : Int): Int{
        return a + b
    }

    fun sum2(a:Int,b:Int):Int = a + b
    //方法相加
    fun printSum(a:Int,b: Int){
        Toast.makeText(this, sum(a,b).toString(), Toast.LENGTH_SHORT).show()
        Log.i("tag", sum(a,b).toString())
        Log.i("tag", print(a + b).toString())
    }
    //获取ArrayList的值
    fun useList(args:Array<String>){
        if(args.size == 0) return
        print("第一个值:${args[0]}")
    }
    //string转int
    fun judgeIsNull(args:Array<String>){
        if(args.size < 2) return
        val x = Integer.parseInt(args[0])
        val y = Integer.parseInt(args[1])
        if(x != null && y != null){
            print(x * y)
        }
    }
    //转换类型
    fun getStringLength(obj:Any):Int?{
        if(obj is String){
            return obj.length
        }
        return  null
    }
    //使用for循环
    fun useFor(list:Array<String>){
        for(arg in list){
            print(arg)
        }
        for (arg in list.indices){
            print(list[arg])
            print(list.get(arg))
        }
    }

    // View的模板
    inline fun <reified TV : View> Context.v(init: TV.() -> Unit): TV {
        val constr = TV::class.java.getConstructor(Context::class.java);
        val view = constr.newInstance(this);
        view.init();
        return view;
    }

    // ViewGroup的模板
    inline fun <reified V : View> ViewGroup.v(init: V.() -> Unit): V {
        val constr = V::class.java.getConstructor(Context::class.java);
        val view = constr.newInstance(context);
        addView(view)
        view.init();
        return view;
    }

    // 使用扩展函数(extension function)View.
    fun View.dp_f(dp: Float): Float {
        // 引用View的context
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)
    }

    // 转换Int
    fun View.dp_i(dp: Float): Int {
        return dp_f(dp).toInt()
    }

    // 使用扩展属性(extension property)
    var View.padLeft: Int
        set(value) {
            setPadding(value, paddingTop, paddingRight, paddingBottom)
        }

        get() {
            return paddingLeft
        }
}
