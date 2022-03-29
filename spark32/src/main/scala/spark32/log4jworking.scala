package spark32

import org.apache.log4j.LogManager
import org.apache.log4j.Logger
import org.apache.log4j.PropertyConfigurator
import org.apache.log4j.Level

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.sql.SparkSession

object log4jworking {
  
  
  def main(args: Array[String]){
    
    println("Testing log4j")
    
     //val spark=SparkSession.builder().master("local[*]").getOrCreate()
	 //spark.conf.getAll.foreach(println)
    val logger: Logger = LogManager.getLogger(this.getClass.getName)
    
     val dateFormat: SimpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
    System.setProperty("log4j.current.date.time", dateFormat.format(new Date()));
    
    PropertyConfigurator.configure(args(0))
     logger.info("Logger : Welcome to log4j::"+this.getClass.getName)

     //logger.setLevel(Level.DEBUG)
     //logger.setLevel(Level.INFO)
    
	  logger.debug("This is debug message");
	  logger.info("This is info message");
	  logger.warn("This is warn message");
	  logger.fatal("This is fatal message");
	  logger.error("This is error message");
	    logger.error("======");
	    
	    logger.debug("This is debug message");
	  logger.info("This is info message");
	  logger.warn("This is warn message");
	  logger.fatal("This is fatal message");
	  logger.error("This is error message");
	  
	  logger.debug("This is debug message");
	  logger.info("This is info message");
	  logger.warn("This is warn message");
	  logger.fatal("This is fatal message");
	  logger.error("This is error message");
	  
	  logger.debug("This is debug message");
	  logger.info("This is info message");
	  logger.warn("This is warn message");
	  logger.fatal("This is fatal message");
	  logger.error("This is error message");
	  
	  logger.debug("This is debug message");
	  logger.info("This is info message");
	  logger.warn("This is warn message");
	  logger.fatal("This is fatal message");
	  logger.error("This is error message");
	  
	  logger.debug("This is debug message");
	  logger.info("This is info message");
	  logger.warn("This is warn message");
	  logger.fatal("This is fatal message");
	  logger.error("This is error message");
	  

	  println("log level:::::"+ logger.getEffectiveLevel)
	  

	  Logger.getLogger("org").setLevel(Level.OFF)
    
	  Logger.getLogger("akka").setLevel(Level.OFF)
	  
	  logger.info("Testing logger INFO")
	  
	   logger.info("----------"+Logger.getRootLogger)
	   
	  val spark=SparkSession.builder().master("local[*]").getOrCreate()
	  
	  
	    //spark.sparkContext.setLogLevel("DEBUG")

	  //spark.sql("select * from a").show(false)
	  spark.conf.getAll.foreach(println)
	  
  }
}