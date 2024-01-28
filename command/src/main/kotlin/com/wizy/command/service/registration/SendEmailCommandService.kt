package com.wizy.command.service.registration

import com.wizy.command.controller.dto.RegistrationRequest
import com.wizy.command.util.Slf4jLogger
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.stereotype.Component

@Component
@ConditionalOnBean(name = ["generateTokenCommandService"])
class SendEmailCommandService : UserRegistrationCommand
{

    override fun execute(obj: RegistrationRequest)
    {
        logger.info("SendEmailCommandService: Execute") //        throw RuntimeException("SendEmailCommandService: Error") // Необходимо для проверки RollBack
    }

    override fun undo()
    {
        logger.error("SendEmailCommandService: RollBack")
    }

    companion object : Slf4jLogger()
}
