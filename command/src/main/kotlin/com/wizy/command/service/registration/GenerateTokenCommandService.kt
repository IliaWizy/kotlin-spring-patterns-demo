package com.wizy.command.service.registration

import com.wizy.command.controller.dto.RegistrationRequest
import com.wizy.command.util.Slf4jLogger
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.stereotype.Component

@Component
@ConditionalOnBean(name = ["createUserCommandService"])
class GenerateTokenCommandService : UserRegistrationCommand
{

    override fun execute(obj: RegistrationRequest)
    {
        logger.info("GenerateTokenCommandService: Execute")
    }

    override fun undo()
    {
        logger.error("GenerateTokenCommandService: RollBack")
    }

    companion object : Slf4jLogger()
}
