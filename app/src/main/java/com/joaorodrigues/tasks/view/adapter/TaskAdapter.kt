package com.joaorodrigues.tasks.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joaorodrigues.tasks.service.listener.TaskListener
import com.joaorodrigues.tasks.service.model.TaskModel
import com.joaorodrigues.tasks.view.viewholder.TaskViewHolder
import com.joaorodrigues.tasks.databinding.RowTaskListBinding

class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    private var listTasks: List<TaskModel> = arrayListOf()
    private lateinit var listener: TaskListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = RowTaskListBinding.inflate(inflater, parent, false)
        return TaskViewHolder(itemBinding, listener)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindData(listTasks[position])
    }

    override fun getItemCount(): Int {
        return listTasks.count()
    }

    fun attachListener(taskListener: TaskListener) {
        listener = taskListener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<TaskModel>) {
        listTasks = list
        notifyDataSetChanged()
    }
}