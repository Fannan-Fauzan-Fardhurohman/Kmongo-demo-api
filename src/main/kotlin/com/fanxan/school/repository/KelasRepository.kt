package com.fanxan.school.repository

import com.fanxan.school.model.Kelas
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult

interface KelasRepository {
    fun getUserByname(name:String) : Kelas?
    fun getUsers():List<Kelas>
    fun addUser(name:String):List<Kelas>
    fun deleteUserByname(name:String):DeleteResult
    fun updateData(name:String,update:String): UpdateResult
}