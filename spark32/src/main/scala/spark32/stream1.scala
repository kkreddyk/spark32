package spark32

import org.apache.spark.sql.SparkSession

import org.apache.log4j.Logger
import org.apache.log4j.LogManager
import org.apache.log4j.PropertyConfigurator
import org.apache.log4j.Level

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.sql.streaming

object stream1 {
  
  def main(args: Array[String]){
    
    println("Starting Streaming:::")
    
    val logger: Logger = LogManager.getLogger(this.getClass.getName)
    
    println("Log Level"+logger.getEffectiveLevel)
    
    
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
    System.setProperty("runid", dateFormat.format(new Date()));
    
    
    PropertyConfigurator.configure(args(0))
    
    logger.info("INFO-Logger")
    logger.error("ERROR-Logger")
    logger.debug("DEBUG-Logger")
    val spark=SparkSession.builder.master("local[*]").getOrCreate
    
    spark.conf.getAll.foreach(println)
    
    
   val streamDF1=spark.readStream.format("socket").
   option("host","192.168.28.131").option("port","9090").load()
   
   streamDF1.printSchema()
   println("Steaming?? = "+streamDF1.isStreaming)
   
   streamDF1.createOrReplaceTempView("streamdf1")
   
   spark.sql("select * from streamdf1").writeStream.format("console").outputMode("append")
   
   spark.sql("select value,count(*) from streamdf1 group by value").writeStream.format("console").outputMode("complete").start().awaitTermination()
   //streamDF1.writeStream.format("console").start().awaitTermination()
  }
  
}