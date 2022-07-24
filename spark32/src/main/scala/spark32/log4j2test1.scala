package spark32

import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.LogManager

object log4j2test1 {
  
  def main(args: Array[String])
  {
  val logger: Logger = LogManager.getLogger(this.getClass.getName)
  
  logger.debug("Log4j2: Debug........")
  logger.error("Log4j2: error")
  logger.warn("Log4j2: warn")
  logger.fatal("Log4j2: fatal")
         
  }
}