package com.wizy.command.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory


abstract class Slf4jLogger
{
    protected val logger: Logger = LoggerFactory.getLogger(javaClass.enclosingClass)


}
