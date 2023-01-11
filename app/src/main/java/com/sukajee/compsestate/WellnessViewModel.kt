package com.sukajee.compsestate

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks


    fun removeTask(task: WellnessTask) {
        _tasks.remove(task)
    }

    fun changeCheckedState(item: WellnessTask, checked: Boolean) {
        _tasks.find { task ->
            task.id == item.id
        }?.let {
            it.checked = checked
        }
    }

    private fun getWellnessTasks() = List(60) {
        WellnessTask(it, "Task number : $it")
    }
}