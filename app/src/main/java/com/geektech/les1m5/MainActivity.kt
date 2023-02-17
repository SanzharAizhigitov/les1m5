package com.geektech.les1m5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.les1m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    private val presenter = Presenter()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.fillCounterView(this)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            mn.setOnClickListener(){
                presenter.minus()
            }
            pl.setOnClickListener() {
                presenter.increment()
            }
        }
    }

    override fun showNewCount(count: Int) {
        binding.tv.text = count.toString()
    }

    override fun showToast(message:String) {
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun color(color: Int) {
        binding.tv.setTextColor(color)
    }
}