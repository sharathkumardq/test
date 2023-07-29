package com.sharathkumarsdigital.components.sections

import androidx.compose.runtime.*
import com.sharathkumarsdigital.components.SectionTitle
import com.sharathkumarsdigital.components.Skillbar
import com.sharathkumarsdigital.components.models.Section
import com.sharathkumarsdigital.components.models.Skill
import com.sharathkumarsdigital.components.models.Theme
import com.sharathkumarsdigital.components.styles.AboutImageStyle
import com.sharathkumarsdigital.components.styles.AboutTextStyle
import com.sharathkumarsdigital.components.util.Constants
import com.sharathkumarsdigital.components.util.Constants.LORE
import com.sharathkumarsdigital.components.util.Constants.SECTION_WIDTH
import com.sharathkumarsdigital.components.util.ObserveViewportEntered
import com.sharathkumarsdigital.components.util.Res
import com.sharathkumarsdigital.components.util.Res.Image.about_image
import com.sharathkumarsdigital.components.util.animatePercentage
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.SilkStyleSheet.scope
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.compose.style.KobwebComposeStyleSheet.scope as scope1
import com.varabyte.kobweb.core.DefaultStyleSheet.scope as scope1

@Composable
fun AboutSection(){
    Box(
        modifier=Modifier
            .id(Section.About.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom=100.px),
        contentAlignment = Alignment.Center
    ){

        AboutContent()
    }
}
@Composable
fun AboutContent(){
    val breakpoint by rememberBreakpoint()
    Column (
        modifier = Modifier
            .fillMaxWidth(
                if(breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            )
            .maxWidth(1200.px)
    ){
           SimpleGrid( modifier=Modifier.fillMaxWidth(
               if(breakpoint >= Breakpoint.MD)
                   100.percent else 90.percent

            ),
               numColumns = numColumns(base=1,md=2)){

               if(breakpoint >= Breakpoint.MD) {
                   AboutImage()
               }
               AboutMe()
           }
    }
}
@Composable
fun AboutImage(){
    Box{
        Image(
            modifier = AboutImageStyle.toModifier().fillMaxWidth(90.percent),
            src=about_image,
            desc="About Image"
        )
    }
}
@Composable
fun AboutMe(){
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false)}
    var animatedPercentage = remember { mutableStateListOf(0,0,0,0,0) }
    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 300.0,
        onViewportEntered = {
          viewportEntered = true
            Skill.values().forEach { skill ->
                scope.launch {
                    animatePercentage(
                        percent = skill.percentage.value.toInt(),
                        onUpdate = {
                            animatedPercentage[skill.ordinal] = it
                        }
                    )
                }
            }

        }
    )

    Column(
        modifier= Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center

    ){
       SectionTitle(section= Section.About)
        P(
            attrs = AboutTextStyle.toModifier()
                .margin(topBottom = 25.px)
                .maxWidth(500.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(18.px)
                .fontStyle(FontStyle.Italic)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ){
            Text(LORE)
        }

        Skill.values().forEach{ skill ->
            Skillbar(
                name= skill.title,
                index=skill.ordinal,
                percentage= if(viewportEntered) skill.percentage else 0.percent,
                animatedPercentage = if(viewportEntered) animatedPercentage[skill.ordinal] else 0
            )

        }

    }
}