package com.fanxan.school.controller

import com.fanxan.school.BaseResponse
import com.fanxan.school.model.Kelas
import com.fanxan.school.services.KelasService
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/sekolah/kelas")
class KelasController {
    @Autowired
    private lateinit var  kelasService: KelasService
    @PostMapping
    fun addUser(
        @RequestBody user: Kelas
    ):
            BaseResponse<List<Kelas>> {
        return BaseResponse(
            status = true,
            messages = "Success",
            data = kelasService.addUser(user)
        )
    }

    @GetMapping
    fun getUsers(): BaseResponse<List<Kelas>> {
        return BaseResponse(
            status = true,
            messages = "Success",
            data = kelasService.getUsers()
        )
    }

    @GetMapping("/{name}")
    fun getUser(
        @PathVariable(value = "name") userName: String
    ): BaseResponse<Kelas> {
        return BaseResponse(
            status = true,
            messages = "Success",
            data = kelasService.getUserByName(userName)
        )
    }

    @DeleteMapping("/{id}")
    fun deleteUsers(
        @PathVariable(value = "id") userName: String
    ):BaseResponse<DeleteResult>{
        return BaseResponse(
            status = true,
            messages = "Success",
            data = kelasService.deleteKelas(userName)
        )
    }

    @RequestMapping(method = [RequestMethod.PUT], value = ["/update/{id}"])
    fun updateKelas(
        @PathVariable(value = "id") userName: String,
        @RequestBody user: Kelas
    ): BaseResponse<UpdateResult> {
        val update:String = user.kelas
        println("INI UPDATE $update")
        println("<><><> $user")
        return BaseResponse(
            status = true,
            messages = "Success",
            data = kelasService.updateKelas(userName,update)
        )
    }

}