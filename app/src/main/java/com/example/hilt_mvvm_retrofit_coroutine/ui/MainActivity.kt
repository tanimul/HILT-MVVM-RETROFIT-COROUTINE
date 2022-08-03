package com.example.hilt_mvvm_retrofit_coroutine.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hilt_mvvm_retrofit_coroutine.databinding.ActivityMainBinding
import com.example.hilt_mvvm_retrofit_coroutine.ui.adapter.UserViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG: String = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewAdapter: UserViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Recyclerview init
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        userViewAdapter = UserViewAdapter(this) {
            Toast.makeText(this, it.name, Toast.LENGTH_LONG).show()
        }
        val dividerItemDecoration = DividerItemDecoration(
            this,
            layoutManager.orientation
        )
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        binding.recyclerView.adapter = userViewAdapter


        //init Viewmodel
        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.liveDataListObserver()
            .observe(this) {
                if (it != null) {
                    userViewAdapter.setDataList(it)
                } else {
                    Toast.makeText(this, "Something went wrong!", Toast.LENGTH_LONG)
                }
            }
        viewModel.loadLiveUserDataList("md")

    }
}