package com.example.mobilewalletfigma.fast_transfer_card_screens.fast_transfer_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilewalletfigma.R

@Composable
fun FastTransferCard(operationStatus: OperationStatus) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TopBar(operationStatus)
            Box {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(152.dp)
                        .background(
                            color = when (operationStatus) {
                                OperationStatus.InPROCESS -> Color(0xFF3C7BF3)
                                OperationStatus.SUCCESS -> Color(0xFF12A58C)
                                OperationStatus.DECLINE -> Color(0xFFF6285F)
                            }
                        )
                )
                Column(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 50.dp)
                        .background(
//                            color = Color.Blue,
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        )
                ) {
                    Content(operationStatus)
                    Image(
                        painter = painterResource(R.drawable.ic_bottom_background),
                        contentDescription = "",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    CustomBottomSheet()
                    CardButton(operationStatus)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFastTransferCard() {
    FastTransferCard(operationStatus = OperationStatus.InPROCESS)
}

@Composable
fun TopBar(operationStatus: OperationStatus) {
    Row(
        modifier = Modifier
            .background(
                color = when (operationStatus) {
                    OperationStatus.InPROCESS -> Color(0xFF3C7BF3)
                    OperationStatus.SUCCESS -> Color(0xFF12A58C)
                    OperationStatus.DECLINE -> Color(0xFFF6285F)
                }
            )
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
fun Content(operationStatus: OperationStatus) {
    Column(
        modifier = Modifier.padding(top = 24.dp, start = 20.dp, end = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(
                    color = Color(0xFFF7FAFC),
                    shape = RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_mobile_wallet_logo),
                contentDescription = "",
                modifier = Modifier.padding(top = 20.dp, bottom = 18.dp),
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            Image(
                painter = when (operationStatus) {
                    OperationStatus.InPROCESS -> painterResource(R.drawable.ic_repeat_circle)
                    OperationStatus.SUCCESS -> painterResource(R.drawable.ic_success)
                    OperationStatus.DECLINE -> painterResource(R.drawable.ic_error_mini)
                },
                contentDescription = "",
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = when (operationStatus) {
                    OperationStatus.InPROCESS -> "Операция в обработке"
                    OperationStatus.SUCCESS -> "Перевод выполнен"
                    OperationStatus.DECLINE -> "Перевод неуспешен"
                },
                style = TextStyle(
                    fontWeight = FontWeight(500),
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    color = Color(0xFF061737),
                ),
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "13 Января 12:05",
                style = TextStyle(
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    color = Color(0xFF6A7487),
                ),
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        HorizontalDivider(color = Color(0xFFE8EAED))
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
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun CardButton(operationStatus: OperationStatus) {
    Button(
        onClick = { },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF061737))
    ) {
        Text(
            text = when (operationStatus) {
                OperationStatus.InPROCESS,
                OperationStatus.SUCCESS -> "На главную"

                OperationStatus.DECLINE -> "Попробовать ещё раз"
            },
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                lineHeight = 24.sp,
            )
        )
    }
}


data class CardInfo(val name: String, val value: String)

val CardInfoList = listOf(
    CardInfo("ID транзакции", "12345678901"),
    CardInfo("Получатель", "4269 ---- ---- 7777"),
    CardInfo("Сумма", "1500,00р"),
    CardInfo("Комиссия", "45,05р"),
    CardInfo("К списанию", "1545,10р"),
)

enum class OperationStatus {
    InPROCESS, SUCCESS, DECLINE
}





