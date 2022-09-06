package com.mikkyboy.devmanager

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getDevelopers(): ArrayList<Developer> {
        val developersList = ArrayList<Developer>()

        val dev1 = Developer(
            1,
            "MikkyBoy",
            "Mobile",
            "2 Years",
            "Flutter, Android",
        )

        val dev2 = Developer(
            2,
            "HorlyMobile",
            "Web, Mobile",
            "5 Years",
            "Angular, Ionic, NodeJS",
        )

        val dev3 = Developer(
            3,
            "OBKM",
            "FullStack",
            "10 Years",
            "Android, SpringBoot, Flutter, C++",
        )
        val dev4 = Developer(
            4,
            "Charly Keleb",
            "FullStack",
            "4 Years",
            "Android, SpringBoot, Flutter, C++",
        )
        val dev5 = Developer(
            5,
            "Lazy Programmer",
            "FullStack",
            "10 Years",
            "Android, SpringBoot, Flutter, C++",
        )


        developersList.add(dev1)
        developersList.add(dev2)
        developersList.add(dev3)
        developersList.add(dev4)
        developersList.add(dev5)
        return developersList
    }

}