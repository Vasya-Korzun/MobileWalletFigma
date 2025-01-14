package com.example.mobilewalletfigma.fast_transfer_card_screens.fast_transfer_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilewalletfigma.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheet() {
    var showBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState()

    Button(onClick = { showBottomSheet = true }) {
        Text("Показать нижний лист")
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = bottomSheetState,
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "Выберите банк получателя",
                    style = TextStyle(
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        color = Color(0xFF061737),
                    ),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFDDDFE4),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.padding(start = 16.dp),
                        painter = painterResource(R.drawable.ic_bank_sber),
                        contentDescription = "",
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "СберБанк",
                        style = TextStyle(
                            fontWeight = FontWeight(400),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            color = Color(0xFF061737),
                        ),
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFDDDFE4),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.padding(start = 16.dp),
                        painter = painterResource(R.drawable.ic_bank_t),
                        contentDescription = "",
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "T-Банк",
                        style = TextStyle(
                            fontWeight = FontWeight(400),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            color = Color(0xFF061737),
                        ),
                    )
                }
                Button(onClick = {
                    scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                        if (!bottomSheetState.isVisible) {
                            showBottomSheet = false
                        }
                    }
                }) {
                    Text("Скрыть нижний лист")
                }
            }
        }
    }
}