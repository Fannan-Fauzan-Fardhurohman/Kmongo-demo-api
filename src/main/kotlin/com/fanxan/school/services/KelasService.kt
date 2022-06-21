package com.fanxan.school.services

import com.fanxan.school.model.Kelas
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult


interface KelasService {
    fun getUserByName(name: String): Kelas?
    fun getUsers(): List<Kelas>
    fun addUser(user: Kelas): List<Kelas>
    fun getIds(): List<String>
    fun deleteKelas(name:String): DeleteResult
    fun updateKelas(user:String,update:String): UpdateResult
}