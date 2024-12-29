package com.example.mobilewalletfigma.faq_screen.compose_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilewalletfigma.R
import com.example.mobilewalletfigma.faq_screen.FAQIntent
import com.example.mobilewalletfigma.faq_screen.FAQState
import com.example.mobilewalletfigma.faq_screen.FAQViewModel.Companion.Questions
import com.example.mobilewalletfigma.faq_screen.Question
import com.example.mobilewalletfigma.ui.theme.ButtonColorFaq
import com.example.mobilewalletfigma.ui.theme.GrayFaq
import com.example.mobilewalletfigma.ui.theme.QuestionFaqText
import com.example.mobilewalletfigma.ui.theme.TextButtonColor

@Composable
fun FaqScreen(
    viewState: FAQState,
    dispatch: (FAQIntent) -> Unit,
) {
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp, top = 12.dp)
            ) {
                item {
                    Text(
                        text = stringResource(R.string.card_faq),
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            color = GrayFaq,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            lineHeight = 22.sp,
                        ),
                    )
                    Spacer(Modifier.height(12.dp))
                }
                itemsIndexed(viewState.cardAndSafetyQuestion) { index, item ->
                    val style = when (index) {
                        viewState.cardAndSafetyQuestion.indices.first -> ItemStyle.TOP
                        viewState.cardAndSafetyQuestion.indices.last -> ItemStyle.BOTTOM
                        else -> ItemStyle.MIDDLE
                    }
                    QuestionItem(
                        question = item,
                        style = style
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.safety_faq),
                        style = TextStyle(
                            color = GrayFaq,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            lineHeight = 22.sp,
                        ),
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
                itemsIndexed(viewState.cardAndSafetyQuestion) { index, item ->
                    val style = when (index) {
                        viewState.cardAndSafetyQuestion.indices.first -> ItemStyle.TOP
                        viewState.cardAndSafetyQuestion.indices.last -> ItemStyle.BOTTOM
                        else -> ItemStyle.MIDDLE
                    }
                    QuestionItem(
                        question = item,
                        style = style
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    SupportButton()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFaqScreen() {
    FaqScreen(
        viewState = FAQState.initial(),
        dispatch = {},
    )
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
            modifier = Modifier.padding(horizontal = 20.dp),
            painter = painterResource(R.drawable.icon_arrow_back_outline),
            contentDescription = "",
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = stringResource(R.string.text_faq),
            modifier = Modifier
                .padding(start = 126.dp),
            style = TextStyle(
                color = QuestionFaqText,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                lineHeight = 24.sp,
            ),
        )
    }
}

enum class ItemStyle {
    TOP, MIDDLE, BOTTOM,
}

@Composable
fun QuestionItem(
    question: Question,
    style: ItemStyle
) {
    val isOpen = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
//                color = ContentColor,    //Todo
                color = Color.Red,
                shape = when (style) {
                    ItemStyle.TOP -> RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                    ItemStyle.MIDDLE -> RoundedCornerShape(0.dp)
                    ItemStyle.BOTTOM -> RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)
                }
            )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(54.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = question.number,
                style = TextStyle(
                    color = QuestionFaqText,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 22.sp,
                ),
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = if (!isOpen.value) painterResource(R.drawable.icon_chevron_down_outline)
                else painterResource(R.drawable.icon_chevron_up_outline),
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                        isOpen.value = !isOpen.value
                    }
            )
        }
        if (isOpen.value) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                text = question.answer,
                style = TextStyle(
                    color = GrayFaq,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 22.sp,
                ),
            )
            if (question.answer == Questions[Questions.size - 1].answer     //Todo ???????????????
            ) {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun SupportButton() {
    Button(
        onClick = { },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 146.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = ButtonColorFaq)
    ) {
        Text(
            stringResource(R.string.button_contact_support),
            style = TextStyle(
                color = TextButtonColor,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                lineHeight = 24.sp,
            )
        )
    }
}


