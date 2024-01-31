package com.example.revest.utils

fun String.capitalizeWords(): String =
    split(" ").joinToString(" ") { it.lowercase().replaceFirstChar { it1 -> it1.titlecase() } }
