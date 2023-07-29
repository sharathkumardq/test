package com.sharathkumarsdigital.sections

import androidx.compose.runtime.Composable
import com.sharathkumarsdigital.components.Header
import com.sharathkumarsdigital.components.SocialBar
import com.sharathkumarsdigital.components.models.Section
import com.sharathkumarsdigital.components.models.Theme
import com.sharathkumarsdigital.components.sections.AboutSection
import com.sharathkumarsdigital.components.styles.MainButtonStyle
import com.sharathkumarsdigital.components.styles.MainImageStyle
import com.sharathkumarsdigital.components.util.Constants.FONT_FAMILY
import com.sharathkumarsdigital.components.util.Constants.LOREM
import com.sharathkumarsdigital.components.util.Constants.SECTION_WIDTH
import com.sharathkumarsdigital.components.util.Res
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection(onMenuClicked:() -> Unit){

    Box(
        modifier = Modifier
            .id(Section.Home.id)
            .maxWidth(SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ){
        MainBackground()
        MainContent(onMenuClicked = onMenuClicked)
    }
}
@Composable
fun MainBackground(){
  Image(
      modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Fill),
      src= Res.Image.background,
      desc="Background image"
  )
}
@Composable
fun MainContent(onMenuClicked:() -> Unit){
    val breakpoint by rememberBreakpoint()
    Column(
        modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Header(onMenuClicked = onMenuClicked)
        Column(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            SimpleGrid(modifier=Modifier.fillMaxWidth(
                if(breakpoint >= Breakpoint.MD) 85.percent
                else 90.percent
            ),
                numColumns = numColumns(base=1,md=2)
            ){
              MainText(breakpoint = breakpoint)
                MainImage()
            }
        }

    }
}
@Composable
fun MainText(breakpoint: Breakpoint){
   Row(
       horizontalArrangement = Arrangement.Center,
       verticalAlignment = Alignment.CenterVertically
   ){
     if(breakpoint>Breakpoint.MD){
         SocialBar()
     }
       Column {
           P(
               attrs = Modifier
                   .margin(topBottom = 0.px)
                   .fontFamily(FONT_FAMILY)
                   .fontSize(45.px)
                   .fontWeight(FontWeight.Normal)
                   .color(Theme.Primary.rgb)
                   .toAttrs()
           ){
              Text("Hello,I'm")
           }
           P(
               attrs = Modifier
                   .margin(top = 20.px,bottom=0.px)
                   .fontFamily(FONT_FAMILY)
                   .fontSize(68.px)
                   .fontWeight(FontWeight.Bolder)
                   .color(Theme.Secondary.rgb)
                   .toAttrs()
           ){
               Text("Sharath Kumar")
           }
           P(
               attrs = Modifier
                   .margin(top = 10.px,bottom=5.px)
                   .fontFamily(FONT_FAMILY)
                   .fontSize(20.px)
                   .fontWeight(FontWeight.Bold)
                   .color(Theme.Secondary.rgb)
                   .toAttrs()
           ){
               Text("Mobile  & Web Developer/Designer")
           }
           P(
               attrs = Modifier

                   .margin(bottom=25.px)
                   .maxWidth(400.px)
                   .fontFamily(FONT_FAMILY)
                   .fontStyle(FontStyle.Italic)
                   .fontSize(15.px)
                   .fontWeight(FontWeight.Normal)
                   .color(Theme.Secondary.rgb)
                   .toAttrs()
           ){
               Text(LOREM)
           }
           Button(
               attrs= MainButtonStyle.toModifier()
                   .height(40.px)
                   .border(width = 0.px)
                   .borderRadius(r=5.px)
                   .backgroundColor(Theme.Primary.rgb)
                   .cursor(Cursor.Pointer)
                   .color(Colors.White)
                   .toAttrs()
           ){
             Link(
               modifier=Modifier
                   .color(Colors.White)
                   .textDecorationLine(TextDecorationLine.None),
                 text="Hire me",
                 path=Section.contact.path
             )
           }
       }
   }
}

@Composable
fun MainImage(){
    Column(
        modifier=Modifier.fillMaxSize(80.percent),
        verticalArrangement = Arrangement.Center

    ){
      Image(
          modifier= MainImageStyle.toModifier().fillMaxWidth(),
          src=Res.Image.main_image,
          desc="Main Image"
      )
    }
}