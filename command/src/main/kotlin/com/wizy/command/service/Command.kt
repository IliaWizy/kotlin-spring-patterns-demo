package com.wizy.command.service

interface Command<C, V>
{
    fun execute(obj: V)
    fun undo()
}
