package com.sukajee.compsestate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    lists: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask: (WellnessTask, Boolean) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = lists,
            key = { task -> task.id }
        ) { item ->
            WellnessTaskItem(
                taskName = item.label,
                onClose = {
                    onCloseTask(item)
                },
                checked = item.checked,
                onCheckedChange = {
                    onCheckedTask(item, it)
                }
            )
        }
    }
}