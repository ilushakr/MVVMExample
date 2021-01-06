package com.example.mvvmexample

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample.base.App
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var factory : ViewModelFactory

    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        App.component?.injectMainActivity(this)

        App[this].injector?.injectMainActivity(this)

        viewModel = ViewModelProvider(this, factory).get(ViewModel::class.java)
        initViews()

    }

    private fun initViews(){
        viewModel.getPosts().observe(this, Observer {
            if(it != null){
                val notes = arrayListOf<String>()
                it.forEach { note ->
                    notes.add(note.title!!)
                }

                val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1, notes
                )

                listView.adapter = adapter
            }
//            Log.d("tag", it[0].title!!)
        })
    }
}