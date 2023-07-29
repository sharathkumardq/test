package com.sharathkumarsdigital.pages

import androidx.compose.runtime.*

import com.varabyte.kobweb.core.Page
import com.sharathkumarsdigital.components.layouts.PageLayout
import com.sharathkumarsdigital.components.sections.AboutSection
import com.sharathkumarsdigital.components.sections.ContactSection
import com.sharathkumarsdigital.components.sections.ExperienceSection
import com.sharathkumarsdigital.sections.MainSection
import com.stevdza.san.components.OverflowMenu
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.FlexDirection.Companion.Column
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun HomePage() {
    var menuOpened by remember { mutableStateOf(false) }
   Column(
       modifier= Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Top,
       horizontalAlignment = Alignment.CenterHorizontally
   ){
      MainSection(
          onMenuClicked = {menuOpened = true}
      )
       AboutSection()
       ExperienceSection()
       ContactSection()
   }
 if(menuOpened){
  OverflowMenu(onMenuClosed={menuOpened = false})
 }

}
