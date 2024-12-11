package com.example.mobilewalletfigma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mobilewalletfigma.add_new_card.compose_ui.AddNewCardScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                contentColor = Color.White
            ) { innerPadding ->
                AddNewCardScreen(
                    innerPadding
                )
            }
        }
    }
}

