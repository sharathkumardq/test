package com.sharathkumarsdigital.components.models

import com.sharathkumarsdigital.components.util.Constants.LOREM

enum class Experience(
    val number: String,
    val jobPosition: String,
    val description: String  ,
    val company: String,
    val from: String,
    val to: String
) {
    First(
    number ="01",
    jobPosition="Kotlin Multi-Platform Developer",
    description=LOREM,
    company= "Google",
        from= "feb 2022",
        to= "Now",

    ),
    Second(
        number ="02",
        jobPosition="Kotlin Multi-Platform Developer",
        description=LOREM,
        company= "Microsoft",
        from= "feb 2019",
        to= "2022",

        ),
    Third(
        number ="03",
        jobPosition="Kotlin Multi-Platform Developer",
        description=LOREM,
        company= "Nexus",
        from= "feb 2018",
        to= "2019",

        )

}