package com.example.mobilewalletfigma.main_screen.transformations

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.math.absoluteValue

/** Universal transformation for any mask*/
class VisaCardTransformation(private val mask: String) : VisualTransformation {

    private val specialSymbolsIndices = mask.indices.filter { mask[it] != '#' }

    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""
        var maskIndex = 0
        text.forEach { char ->
            while (specialSymbolsIndices.contains(maskIndex)) {
                out += mask[maskIndex]
                maskIndex++
            }
            out += char
            maskIndex++
        }
        return TransformedText(AnnotatedString(out), offsetTranslator())
    }

    private fun offsetTranslator() = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            val offsetValue = offset.absoluteValue
            if (offsetValue == 0) return 0
            var numberOfHashtags = 0
            val masked = mask.takeWhile {
                if (it == '#') numberOfHashtags++
                numberOfHashtags < offsetValue
            }
            return masked.length + 1
        }

        override fun transformedToOriginal(offset: Int): Int {
            return mask.take(offset.absoluteValue).count { it == '#' }
        }
    }
}


/** Mask for card number*/
object NumberDefaults {
    const val CARD_NUMBER_MASK = "#### #### #### ####"
    const val CARD_NUMBER_LENGTH = 16
}


/** Mask for validity period */
object DateDefaults {
    const val DATE_MASK = "##/##"
    const val DATE_LENGTH = 4 // Equals to "##/##".count { it == '#' }
}


/** For CVV */
object CvvDefaults {
    const val CVV_LENGTH = 3
}

/** For CardHolder */
object CarHolderDefaults {
    const val CARD_HOLDER_LENGTH = 30
}

