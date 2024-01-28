package com.wizy.command.controller

import com.wizy.command.controller.dto.RegistrationRequest
import com.wizy.command.service.registration.UserRegistrationDispatcher
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class UserRegistrationController(
        private val userRegistrationDispatcher: UserRegistrationDispatcher
)
{
    @PostMapping("/registration")
    fun register(@RequestBody registrationRequest: RegistrationRequest): ResponseEntity<*>
    {
        userRegistrationDispatcher.start(registrationRequest)
        return ResponseEntity.ok("OKKKKkkkkk")
    }
}
