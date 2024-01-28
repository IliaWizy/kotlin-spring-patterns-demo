package com.wizy.command.service.registration

import com.wizy.command.controller.dto.RegistrationRequest
import com.wizy.command.service.Command

interface UserRegistrationCommand : Command<UserRegistrationCommand, RegistrationRequest>
{
    override fun execute(obj: RegistrationRequest) // Entity or Model - нема в примере )
}
