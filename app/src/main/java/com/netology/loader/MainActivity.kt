package com.netology.loader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.netology.loader.databinding.MainBinding

internal class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressIndicator.show()

        lifecycleScope.launchWhenResumed {
            val data = GroupRepository.getData()
            binding.recyclerView.adapter = DataAdapter(data)
            binding.progressIndicator.hide()
        }
    }
}