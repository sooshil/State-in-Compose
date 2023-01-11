package com.sukajee.compsestate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    viewModel: WellnessViewModel = viewModel()
) {
    Column {
        StatefulWaterCounter(modifier = modifier)
        WellnessTasksList(
            modifier = modifier,
            lists = viewModel.tasks,
            onCloseTask = { task ->
                viewModel.removeTask(task)
            },
            onCheckedTask = { task, checked ->
                viewModel.changeCheckedState(task, checked)
            }
        )
    }
}

@Composable
fun StatefulWaterCounter(
    modifier: Modifier = Modifier
) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    StateLessWaterCounter(
        count = count,
        onIncrement = {
            count++
        },
        modifier = modifier
    )
}

@Composable
fun StateLessWaterCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        if (count > 0) {
            Text(
                text = "You have had $count glasses."
            )
        }
        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text(text = "Add one")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    WellnessScreen()
}