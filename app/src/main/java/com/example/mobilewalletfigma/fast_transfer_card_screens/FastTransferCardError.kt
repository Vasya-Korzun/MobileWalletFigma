package com.example.mobilewalletfigma.fast_transfer_card_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilewalletfigma.R

@Composable
fun FastTransferCardErrorScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TopBar()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 50.dp)
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                Content()
                Spacer(modifier = Modifier.weight(1f))
                CardButton()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFastTransferCardErrorScreen() {
    FastTransferCardErrorScreen()
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.padding(horizontal = 20.dp),
            painter = painterResource(R.drawable.icon_close_outline),
            contentDescription = "",
        )
    }
}

@Composable
fun Content() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(R.drawable.ic_error),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Перевод неуспешен",
            style = TextStyle(
                fontWeight = FontWeight(600),
                fontSize = 20.sp,
                lineHeight = 30.sp,
                color = Color(0xFF061737),
            ),
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Время ожидания истекло",
            style = TextStyle(
                fontWeight = FontWeight(400),
                fontSize = 12.sp,
                lineHeight = 20.sp,
                color = Color(0xFF6A7487),
            ),
        )
    }
}

@Composable
fun CardButton() {
    Button(
        onClick = { },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF061737))
    ) {
        Text(
            text = "Повторить",
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                lineHeight = 24.sp,
            )
        )
    }
}