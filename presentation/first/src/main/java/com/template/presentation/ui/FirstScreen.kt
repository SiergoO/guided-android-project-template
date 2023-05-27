package com.template.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel

@Composable
fun FirstScreen(
    navigateToSecondScreen: () -> Unit
) {
//    val textToImageViewModel = getViewModel<FirstViewModel>()
//    val state = textToImageViewModel.collectAsState()
    val state = remember { mutableStateOf("") }
    val context = LocalContext.current

    FirstScreen(
        state = state,
        showSecondScreenAction = { }
    )
}

@Composable
private fun FirstScreen(
    state: MutableState<String>,
    showSecondScreenAction: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "First screen",
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = MaterialTheme.shapes.medium,
            onClick = showSecondScreenAction
        ) {
            Text(
                text = "Go to second screen",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }

}