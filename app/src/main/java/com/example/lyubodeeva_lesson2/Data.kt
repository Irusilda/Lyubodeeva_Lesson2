package com.example.lyubodeeva_lesson2

data class VacancyBtnData(
    val vacancyBtnTitle: String,
    val vacancyBtnSubTitle: String,
    val vacancyImage: Int
)

data class OfficeData(
    val officeCity: String,
    val viewType: Int = R.layout.item_office

)
