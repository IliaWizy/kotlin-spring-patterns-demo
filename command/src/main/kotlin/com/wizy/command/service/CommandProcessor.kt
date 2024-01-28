package com.wizy.command.service

import com.wizy.command.util.Slf4jLogger
import org.springframework.stereotype.Component

/**
 * Общий класс для выполнения команд
 * @param C - тип команды
 * @param V - тип объекта, который будет передан в команду для обработки
 * @property history - история выполненных команд, нужна для rollback
 * */
@Component
class CommandProcessor<C : Command<C, V>, V : Any>
{
    private val history: MutableList<C> = mutableListOf()

    fun executeCommand(
            command: C,
            obj: V
    )
    {
        runCatching {
            logger.info("CommandProcessor: Start execute command, Class: {}", javaClass.simpleName)

            command.execute(obj)
            history.add(command)

        }.onSuccess {
            logger.info("CommandProcessor: All commands completed")
        }
            .onFailure {
                logger.info(
                    "CommandProcessor: Start rollback command. Trigger Class: {}", javaClass.simpleName
                )
                rollback()
                throw it
            }

    }

    private fun rollback()
    {
        logger.warn("CommandProcessor#rollback: Start clear History, history size: {}", history.size)
        for (cmd in history.reversed())
        {
            logger.warn("CommandProcessor#rollback: Undo operation on Class: {}", cmd.javaClass.simpleName)
            cmd.undo()
        }
        logger.warn("CommandProcessor#rollback: Start clear History, history size: {}", history.size)
        history.clear()
    }

    companion object : Slf4jLogger()

}
