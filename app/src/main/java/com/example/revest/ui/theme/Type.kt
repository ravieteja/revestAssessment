package com.example.revest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.revest.R

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val titleStyle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily =  FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = colorResource(id = R.color.black)
        )
    }

val descriptionStyle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily =  FontFamily.Monospace,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = colorResource(id = R.color.black)
        )
    }

val categoryStyle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily =  FontFamily.Monospace,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = colorResource(id = R.color.black)
        )
    }

val priceStyle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily =  FontFamily.Monospace,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = colorResource(id = R.color.black)
        )
    }
