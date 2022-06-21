package com.fanxan.school.model

import java.util.*

data class Kelas(
    var id: String = UUID.randomUUID().toString(),
    var kelas : String,
)
