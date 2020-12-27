package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapter.TodoAdapter
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.model.Todo

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf(
            Todo("Opening", false),
            Todo("Tanya Materi & tugas last week", false),
            Todo("Audien jelasin tugas", false),
            Todo("Penjelasan Mentor", false),
            Todo("Masuk Materi", false),
            Todo("Read the Rules", false),
            Todo("Jelasin Materi", false),
            Todo("Tanya audien jelas?", false),
            Todo("Praktek", false),
            Todo("Repeat ", false),
            Todo("Tanya lagi jelas?", false),
            Todo("Feedback", false),
            Todo("Tugas week 4", false),
            Todo("Done", false)
        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodoList.adapter = adapter
        binding.rvTodoList.layoutManager = LinearLayoutManager(this)

        binding.btAddList.setOnClickListener {
            val title = binding.etAddList.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}