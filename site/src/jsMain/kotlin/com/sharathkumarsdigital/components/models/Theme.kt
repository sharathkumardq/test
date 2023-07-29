package com.sharathkumarsdigital.components.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String,
    val rgb:CSSColorValue
) {
    Primary(hex="#00A7BE",rgb= rgb(r=0,g=167,b=142)),
    Secondary(hex="#121034",rgb=rgb(r=18,g=29,b=52)),
    Gray(hex="#CFCFCF",rgb= rgb(r=207,g=207,b=207)),
    LightGray(hex="#EDEDED",rgb=rgb(r=237,g=237,b=237)),
    LighterGray(hex="#F9F9F9",rgb=rgb(r=249,g=249,b=249))
}