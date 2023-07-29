package com.sharathkumarsdigital.components.models

enum class Section(
    val id:String,
    val title:String,
    val subtitle:String,
    val path:String
) {
    Home(
        id="home",
        title="Home",
        subtitle = "",
        path="#home"
    ),
    About(
        id="about",
        title="About me",
        subtitle="Why Hire Me?",
        path="#about"
    ),
    portfolio(
        id="portfolio",
        title="Portfolio",
        subtitle="My Work",
        path="#portfolio"
    ),

    Experience(
        id="experience",
        title="Experience",
        subtitle="Work Experience",
        path="#experience"
    ),

    contact(
        id="contact",
        title="Contact me",
        subtitle="Get in touch",
        path="#contact"
    )
}