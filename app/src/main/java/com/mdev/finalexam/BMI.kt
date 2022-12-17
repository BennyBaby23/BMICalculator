package com.mdev.finalexam

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class BMI(
    val id: String? = "",
    val height: String? = "",
    val weight: String? = "",
    val name: String? = ""
){
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "height" to height,
            "weight" to weight,
            "name" to name
        )
    }
}
