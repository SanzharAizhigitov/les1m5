package com.geektech.les1m5

import android.graphics.Color

class Presenter() {
    val model = Model()
    lateinit var counterView:CounterView
    fun increment(){
        model.increment()
        counterView.showNewCount(model.count)
        if (model.count == 10) {
            counterView.showToast("Поздравляем")
        }
        if (model.count == 15) {
            counterView.color(Color.GREEN)
        }
    }
    fun minus(){
        model.minus()
        counterView.showNewCount(model.count)
        if (model.count == 10) {
            counterView.showToast("Поздравляем")
        }
        if (model.count != 15) {
            counterView.color(Color.BLACK)
        }
    }
    fun fillCounterView(counterView: CounterView){
        this.counterView = counterView
    }

}