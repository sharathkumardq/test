package com.sharathkumarsdigital.components.models

import org.jetbrains.compose.web.css.CSSKeyframe
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent

enum class Skill(val title: String,
                 val percentage: CSSSizeValue<CSSUnit.percent>) {
 Creative(
     title = "Creative",
     percentage = 90.percent
 ),
    Hardworking(
        title = "HardWorking",
        percentage = 99.percent
    ),
    Value(
        title = "Value for money",
        percentage = 85.percent
    ),
    Delivery(
        title = "On-Time Delivery",
        percentage = 75.percent
    ),
    Understanding(
        title = "Understanding levels",
        percentage = 79.percent
    )
}