package com.wizy.command.controller.dto

data class RegistrationRequest(
        val email: String,
        val password: String,
        val name: String
)
