package com.fanxan.school.repository

import com.fanxan.school.database.DatabaseComponent
import com.fanxan.school.model.Kelas
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.UpdateOptions
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.litote.kmongo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class KelasRepositoryImpl : KelasRepository {
    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun kelasCollection(): MongoCollection<Kelas> =
        databaseComponent.database.getDatabase("kelas").getCollection()

    override fun getUserByname(name: String): Kelas? {
        return kelasCollection().findOne {
            Kelas::kelas eq name
        }
    }

    override fun getUsers(): List<Kelas> {
        return kelasCollection().find().toList()
    }

    override fun addUser(name: String): List<Kelas> {
        val newUser = Kelas(kelas = name)
        val insert = kelasCollection().insertOne(newUser)
        return if (insert.wasAcknowledged()) {
            getUsers()
        } else {
            throw IllegalStateException("insert gagal")
        }
    }

    override fun deleteUserByname(name: String): DeleteResult {
        return kelasCollection().deleteOne(Kelas::id eq name)
    }

    override fun updateData(name: String,update:String): UpdateResult {
        return kelasCollection().updateOne(Kelas::id eq name, setValue(Kelas::kelas, update))
    }
}