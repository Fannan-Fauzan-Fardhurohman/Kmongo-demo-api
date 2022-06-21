package com.fanxan.school.services

import com.fanxan.school.model.Kelas
import com.fanxan.school.repository.KelasRepository
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KelasServiceImpl :KelasService{
    @Autowired
    private lateinit var kelasRepository: KelasRepository


    override fun getUserByName(name: String): Kelas? {
        return kelasRepository.getUserByname(name)
    }

    override fun getUsers(): List<Kelas> {
        return kelasRepository.getUsers()
    }

    override fun addUser(user: Kelas): List<Kelas> {
        return kelasRepository.addUser(user.kelas)
    }

    override fun getIds(): List<String> {
        return kelasRepository.getUsers().map { it.id }
    }

    override fun deleteKelas(name: String): DeleteResult {
        return kelasRepository.deleteUserByname(name)
    }

    override fun updateKelas(user: String,update:String): UpdateResult {
        return kelasRepository.updateData(user,update)

    }


}