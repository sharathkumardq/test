package com.sharathkumarsdigital.components.sections

import androidx.compose.runtime.*
import com.sharathkumarsdigital.components.SectionTitle
import com.sharathkumarsdigital.components.models.Experience
import com.sharathkumarsdigital.components.models.Section
import com.sharathkumarsdigital.components.util.Constants.SECTION_WIDTH
import com.sharathkumarsdigital.components.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint

import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ExperienceSection(){
    Box(
        modifier=Modifier
            .id(Section.Experience.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center

    ){
      ExperienceContent()
    }
}
@Composable
fun ExperienceContent(){
    val breakpoint by rememberBreakpoint()
    var animatedMargin by remember { mutableStateOf(200.px) }
    ObserveViewportEntered(
        sectionId = Section.Experience.id,
        distanceFromTop = 500.0,
        onViewportEntered = {
          animatedMargin = 50.px
        }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(
                if(breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth(if(breakpoint >= Breakpoint.MD) 68.percent
                else 90.percent)
                .margin(bottom = 25.px),
            section = Section.Experience
        )

       Experience.values().forEach{ experience ->
           ExperienceCard(
               breakpoint = breakpoint,
               active = experience == Experience.First,
               experience= experience,
               animatedMargin = animatedMargin
           )
       }
    }
}