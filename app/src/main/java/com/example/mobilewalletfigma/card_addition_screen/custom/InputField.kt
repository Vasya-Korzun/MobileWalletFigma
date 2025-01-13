package com.example.mobilewalletfigma.card_addition_screen.custom

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilewalletfigma.main_screen.transformations.VisaCardTransformation

@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    enabled: Boolean = true,
    maxLines: Int = 1,
    placeholder: String?,
    errorText: String? = null,
    isPassword: Boolean = false,
    inputMask: String? = null,
    leadingIcon: Int? = null,
//    iconsTint: Color = iconSecondary,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    val focusRequester = FocusRequester()
    var isFocused by remember { mutableStateOf(false) }

//    val labelColor = if (isError) textError else textSecondary
//    val borderColor = when {
//        isError -> inputBordersError
//        isFocused -> inputBordersActive
//        else -> inputBordersDefault
//    }

//    val placeholderColor =
//        if (isFocused) inputTextPlaceholderActive else inputTextPlaceholderDefault

    val labelColor = if (isError) Color.BLUE else Color.GREEN
    val borderColor = when {
        isError -> Color.CYAN
        isFocused -> Color.RED
        else -> Color.BLACK
    }

    val placeholderColor =
        if (isFocused) Color.CYAN else Color.BLACK

    var isPasswordVisible by remember { mutableStateOf(false) }
//    val visibilityIcon = if (isPasswordVisible) {
//        Icons.Default.Visibility
//    } else {
//        Icons.Default.VisibilityOff
//    }

    val strokeWidth = 1.dp

    Column(
        modifier = modifier
    ) {
        Text(
            text = if (errorText != null && isError) errorText else label,
            style = TextStyle(
                fontSize = 14.sp,
//                fontFamily = interTight600,
//                color = labelColor,
                color = androidx.compose.ui.graphics.Color.Green,
                letterSpacing = 0.2.sp,
            )
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = value,
//            value =  TextFieldValue(
//                text ="",
//                selection = TextRange("viewState.cardNumber.length".length) // Put cursor to the end
//            ),
            onValueChange = onValueChange,
            enabled = enabled,
            textStyle = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
//                fontFamily = interTight400,
//                color = textPrimary,
                color = androidx.compose.ui.graphics.Color.Green,
                letterSpacing = 0.2.sp,
            ),
            visualTransformation = when {
                isPassword && !isPasswordVisible -> PasswordVisualTransformation('\u2022')
                inputMask != null -> VisaCardTransformation(inputMask)
                else -> VisualTransformation.None
            },
            placeholder = {
                placeholder?.let {
                    Text(
                        text = placeholder,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
//                            fontFamily = interTight400,
//                            color = placeholderColor,
                            color = androidx.compose.ui.graphics.Color.Green,
                            letterSpacing = 0.2.sp,
                        )
                    )
                }
            },
//            shape = RoundedCornerShape(ROUNDED_CORNER_SIZE_DEFAULT.dp),
            maxLines = maxLines,
            colors = OutlinedTextFieldDefaults.colors(
//                focusedBorderColor = Color.Transparent,
//                unfocusedBorderColor = Color.Transparent,
//                disabledBorderColor = Color.Transparent,
            ),
            keyboardOptions = keyboardOptions,
            trailingIcon = if (isPassword) {
                {
                    IconButton(
                        onClick = { isPasswordVisible = !isPasswordVisible }
                    ) {
                        Icon(
//                            imageVector = visibilityIcon,
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
//                            tint = iconSecondary
                        )
                    }
                }
            } else null,
            leadingIcon = leadingIcon?.let {
                {
                    Icon(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(it),
                        contentDescription = null,
//                        tint = iconsTint
                    )
                }
            },
            singleLine = maxLines == 1,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = strokeWidth)
                .focusRequester(focusRequester)
                .onFocusChanged { isFocused = it.isFocused }
                .drawBehind {
                    val cornerRadius = 12.dp.toPx()
                    drawRoundRect(
//                        color = borderColor,
                        color = androidx.compose.ui.graphics.Color.Green,
                        size = size.copy(
                            width = size.width,
                            height = size.height - strokeWidth.toPx()
                        ),
                        cornerRadius = CornerRadius(cornerRadius, cornerRadius),
                        style = Stroke(width = strokeWidth.toPx()),
                    )
                },
        )
    }
}