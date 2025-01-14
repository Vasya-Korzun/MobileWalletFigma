package com.example.mobilewalletfigma.fast_transfer_card_screens.confirmationOfTransfer_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilewalletfigma.R
import com.example.mobilewalletfigma.fast_transfer_card_screens.fast_transfer_card.CardInfo

@Composable
fun ConfirmationOfTransferScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(color = Color(0xFFE8EAED))
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TopBar()
            Content()
            Spacer(modifier = Modifier.weight(1f))
            CardButton()
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConfirmationOfTransferScreen() {
    ConfirmationOfTransferScreen()
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.padding(start = 20.dp),
            painter = painterResource(R.drawable.icon_arrow_back),
            contentDescription = "",
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = "Подтверждение перевода",
            modifier = Modifier.width(271.dp),
            style = TextStyle(
                color = Color(0xFF061737),
                fontWeight = FontWeight(600),
                fontSize = 16.sp,
                lineHeight = 24.sp,
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Content() {
    Column(
        modifier = Modifier
            .padding(top = 12.dp, start = 24.dp, end = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(24.dp))
                .padding(top = 32.dp, start = 20.dp, end = 20.dp, bottom = 16.dp)
        ) {
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.icon_card_send),
                contentDescription = "",
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "1500,00p",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = TextStyle(
                    color = Color(0xFF061737),
                    fontWeight = FontWeight(600),
                    fontSize = 20.sp,
                    lineHeight = 30.sp,
                ),
            )
            Text(
                text = "Перевод (RUB)",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = TextStyle(
                    color = Color(0xFF6A7487),
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                ),
            )
            Spacer(Modifier.height(16.dp))
            LazyColumn {
                itemsIndexed(CardInfoList) { index, item ->
                    Row(modifier = Modifier.padding(vertical = 16.dp)) {
                        Text(
                            text = item.name,
                            style = TextStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                lineHeight = 22.sp,
                                color = Color(0xFF6A7487),
                            ),
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = item.value,
                            style = TextStyle(
                                fontWeight = if (index == CardInfoList.indices.last) {
                                    FontWeight(600)
                                } else {
                                    FontWeight(500)
                                },
                                fontSize = 14.sp,
                                lineHeight = 22.sp,
                                color = Color(0xFF061737),
                            ),
                        )
                    }
                    HorizontalDivider(color = Color(0xFFE8EAED))
                }
            }
        }
    }
}

@Composable
fun CardButton() {
    Button(
        onClick = { },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF061737))
    ) {
        Text(
            text = "Подтвердить",
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontWeight = FontWeight(600),
                fontSize = 16.sp,
                lineHeight = 24.sp,
            )
        )
    }
}

val CardInfoList = listOf(
    CardInfo("С карты", "John Smith - 9299"),
    CardInfo("Получатель", "+7 922 1110500"),
    CardInfo("Банк получателя", "СберБанк"),
    CardInfo("Сумма", "1500,00р"),
    CardInfo("Комиссия", "0р"),
    CardInfo("К списанию", "1500,00р"),
)