package com.lab.zhangll.magicpen.lib

import android.content.Context
import com.lab.zhangll.magicpen.lib.setting.MagicGesture
import com.lab.zhangll.magicpen.lib.setting.MagicSetting
import com.lab.zhangll.magicpen.lib.shapes.circle.MagicCircleSetting
import com.lab.zhangll.magicpen.lib.shapes.line.MagicLineSetting

/**
 * Created by zhangll on 2017/5/20.
 */
fun Context.magicPen(set: MagicView.() -> Unit)
        :  MagicView {
    val magicView = MagicView(this)
    magicView.set()
    return magicView
}

fun MagicSetting.gesture(set: MagicGesture.() -> Unit) {
    val gesture = MagicGesture()
    gesture.set()

    this.gesture = gesture
}

fun MagicView.circle(set: MagicCircleSetting.() -> Unit): MagicSetting {
    val setting = MagicCircleSetting().apply { set() }
    shapes.add(setting.product())

    return setting
}

fun MagicView.line(set: MagicLineSetting.() -> Unit): MagicSetting {
    val setting = MagicLineSetting().apply { set() }
    shapes.add(setting.product())

    return setting
}