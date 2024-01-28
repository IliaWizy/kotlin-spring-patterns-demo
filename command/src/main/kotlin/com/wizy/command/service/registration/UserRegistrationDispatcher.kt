package com.wizy.command.service.registration

import com.wizy.command.controller.dto.RegistrationRequest
import com.wizy.command.service.CommandProcessor
import org.springframework.stereotype.Service

@Service
class UserRegistrationDispatcher(
        private val commands: List<UserRegistrationCommand>,
        private val commandProcessor: CommandProcessor<UserRegistrationCommand, RegistrationRequest>
)
{
    fun start(registrationRequest: RegistrationRequest) =
        commands.forEach { commandProcessor.executeCommand(it, registrationRequest) }
}
