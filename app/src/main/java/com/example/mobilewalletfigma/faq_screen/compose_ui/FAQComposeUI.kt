package com.example.mobilewalletfigma.faq_screen.compose_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
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
import com.example.mobilewalletfigma.ui.theme.ButtonColorFaq
import com.example.mobilewalletfigma.ui.theme.ContentColor
import com.example.mobilewalletfigma.ui.theme.GrayFaq
import com.example.mobilewalletfigma.ui.theme.QuestionFaqText
import com.example.mobilewalletfigma.ui.theme.TextButtonColor

@Composable
fun FaqScreen(
    innerPadding: PaddingValues,
    viewState: FAQState,
    dispatch: (FAQIntent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
    ) {
        item {
            TopBar()
            ContentCards()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFaqScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentColor = White
    ) { innerPadding ->
        FaqScreen(
            innerPadding,
            viewState = FAQState.initial(),
            dispatch = {}
        )
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 22.dp, vertical = 16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.icon_arrow_back_outline),
            contentDescription = "",
            modifier = Modifier
        )
        Image(
            painter = painterResource(R.drawable.icon_title_faq),
            contentDescription = "",
            modifier = Modifier
                .padding(start = 126.dp)
                .align(alignment = Alignment.CenterVertically),
        )
    }
}


@Composable
fun ContentCards() {
    val state1 = remember { mutableStateOf(false) }
    val state2 = remember { mutableStateOf(false) }
    val state3 = remember { mutableStateOf(false) }
    val state4 = remember { mutableStateOf(false) }
    val state5 = remember { mutableStateOf(false) }
    val state6 = remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 50.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(22.dp),
            text = stringResource(R.string.card_faq),
            style = TextStyle(
                color = GrayFaq,
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                lineHeight = 22.sp,
            ),
        )

        Spacer(modifier = Modifier.height(12.dp))


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = ContentColor,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(54.dp)
            ) {

                Text(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .wrapContentWidth()
                        .height(22.dp),
                    text = stringResource(R.string.card_faq_question1),
                    style = TextStyle(
                        color = QuestionFaqText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 22.sp,
                    ),
                )

                Spacer(modifier = Modifier.weight(1f))

//Todo----------------------------------------------------------------------------------------
                if (!state1.value) {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_down_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state1.value = true
                            }
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_up_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state1.value = false
                            }
                    )
                }
//Todo----------------------------------------------------------------------------------------
            }
            if (state1.value) {
                Text(
                    text = "Hello Kotlin!askcsnnvkdjvndkvbdhjvdvbkjsnvsjkvvbdhjbvnsvbhvjhdvbdvdb" +
                            "sjndknvdvbhdbvhdjvbdhjbdfhbffjbnfbkfgjnbgfkbgnfgjbnfbnfkbfknsnvbdkvndvdkvndkjv" +
                            "djknvjdkvnjkdfvkdfkmvdf",
                    color = Black
                )
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(54.dp)
            ) {

                Text(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .wrapContentWidth()
                        .height(22.dp),
                    text = stringResource(R.string.card_faq_question2),
                    style = TextStyle(
                        color = QuestionFaqText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 22.sp,
                    ),
                )

                Spacer(modifier = Modifier.weight(1f))

                //Todo----------------------------------------------------------------------------------------
                if (!state2.value) {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_down_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state2.value = true
                            }
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_up_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state2.value = false
                            }
                    )
                }
//Todo----------------------------------------------------------------------------------------
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(54.dp)
            ) {

                Text(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .wrapContentWidth()
                        .height(22.dp),
                    text = stringResource(R.string.card_faq_question3),
                    style = TextStyle(
                        color = QuestionFaqText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 22.sp,
                    ),
                )

                Spacer(modifier = Modifier.weight(1f))

                //Todo----------------------------------------------------------------------------------------
                if (!state3.value) {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_down_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state3.value = true
                            }
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_up_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state3.value = false
                            }
                    )
                }
//Todo----------------------------------------------------------------------------------------
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(22.dp),
            text = stringResource(R.string.safety_faq),
            style = TextStyle(
                color = GrayFaq,
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                lineHeight = 22.sp,
            ),
        )

        Spacer(modifier = Modifier.height(12.dp))


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = ContentColor,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(54.dp)
            ) {

                Text(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .wrapContentWidth()
                        .height(22.dp),
                    text = stringResource(R.string.card_faq_question1),
                    style = TextStyle(
                        color = QuestionFaqText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 22.sp,
                    ),
                )

                Spacer(modifier = Modifier.weight(1f))

                //Todo----------------------------------------------------------------------------------------
                if (!state4.value) {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_down_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state4.value = true
                            }
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_up_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state4.value = false
                            }
                    )
                }
//Todo----------------------------------------------------------------------------------------
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(54.dp)
            ) {

                Text(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .wrapContentWidth()
                        .height(22.dp),
                    text = stringResource(R.string.card_faq_question2),
                    style = TextStyle(
                        color = QuestionFaqText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 22.sp,
                    ),
                )

                Spacer(modifier = Modifier.weight(1f))

                //Todo----------------------------------------------------------------------------------------
                if (!state5.value) {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_down_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state5.value = true
                            }
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_up_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state5.value = false
                            }
                    )
                }
//Todo----------------------------------------------------------------------------------------
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(54.dp)
            ) {

                Text(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .wrapContentWidth()
                        .height(22.dp),
                    text = stringResource(R.string.card_faq_question3),
                    style = TextStyle(
                        color = QuestionFaqText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 22.sp,
                    ),
                )

                Spacer(modifier = Modifier.weight(1f))

                //Todo----------------------------------------------------------------------------------------
                if (!state6.value) {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_down_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state6.value = true
                            }
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.icon_chevron_up_outline),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                state6.value = false
                            }
                    )
                }
//Todo----------------------------------------------------------------------------------------
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
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
}

