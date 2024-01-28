package com.wizy.command.service.registration

import com.wizy.command.controller.dto.RegistrationRequest
import com.wizy.command.util.Slf4jLogger
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
class CreateUserCommandService : UserRegistrationCommand
{

    override fun execute(obj: RegistrationRequest)
    {
        logger.info("CreateUserCommandService: Execute Facade or Chain of Responsibility Pattern, or other pattern")
    }

    override fun undo()
    {
        logger.error("CreateUserCommandService: RollBack")
    }

    companion object : Slf4jLogger()
}
