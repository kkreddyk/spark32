package spark32


import org.apache.log4j.Logger
import org.apache.log4j.LogManager
import org.apache.log4j.PropertyConfigurator


import org.apache.spark.sql.SparkSession


object streamRate1 {
  
  
  def main(args: Array[String])
  {
    
    println("Starting streamRate1")
    
    val spark=SparkSession.builder.master("local[*]").getOrCreate
    spark.conf.getAll.foreach(println)
    
    /*
    println("Starting Stream-1")
    val stream1=spark.readStream.format("rate").option("rowsPerSecond", 5).load
    stream1.printSchema
    println("Is stream1 Streaming="+stream1.isStreaming)
    stream1.createOrReplaceTempView("stream1")
    spark.sql("select *,'console' from stream1").writeStream.format("console").outputMode("append").start
    spark.sql("select count(*) as stream1_Count,'complete' from stream1").writeStream.format("console").outputMode("complete").start
    spark.sql("select *,'update' from stream1").writeStream.format("console").outputMode("update").start.awaitTermination()
    */
    
    println("Starting Stream-1")
    val stream1=spark.readStream.format("rate").option("rowsPerSecond", 5).load
    stream1.printSchema
    println("Is stream1 Streaming="+stream1.isStreaming)
    stream1.createOrReplaceTempView("stream1")
    spark.sql("select *,'console' from stream1").writeStream.format("console").outputMode("append").start
    spark.sql("select count(*) as stream1_Count,'complete' from stream1").writeStream.format("console").outputMode("complete").start
    spark.sql("select *,'update' from stream1").writeStream.format("console").outputMode("update").start
    
    spark.sql("select *,'append','parquet' from stream1").writeStream.format("parquet").outputMode("append").option("path","C:\\Datas\\Logs\\stream1\\parquet\\data\\").option("checkpointLocation","C:\\Datas\\Logs\\stream1\\parquet\\checkpoint\\").start      
    spark.sql("select *,'append','csv' from stream1").writeStream.format("csv").outputMode("append").option("path","C:\\Datas\\Logs\\stream1\\csv\\data\\").option("checkpointLocation","C:\\Datas\\Logs\\stream1\\csv\\checkpoint\\").start.awaitTermination() 
  
    /*
    println("Starting Stream-2")
    val stream2=spark.readStream.format("rate").option("rowsPerSecond", 1).load
    stream2.printSchema
    println("Is stream2 Streaming="+stream2.isStreaming)
    stream2.createOrReplaceTempView("stream2")
    spark.sql("select *,'stream2','console' from stream2").writeStream.format("console").outputMode("append").start
    spark.sql("select count(*) as stream2_Count,'complete' from stream2").writeStream.format("console").outputMode("complete").start
    spark.sql("select *,'stream2','update' from stream2").writeStream.format("console").outputMode("update").start
   
    println("Starting Stream-3")
    val stream3=spark.readStream.format("rate").option("rowsPerSecond", 3).load
    stream3.printSchema
    println("Is stream3 Streaming="+stream3.isStreaming)
    stream3.createOrReplaceTempView("stream3")
    spark.sql("select *,'stream3','console' from stream3").writeStream.format("console").outputMode("append").start
    spark.sql("select count(*) as stream3_Count,'complete' from stream3").writeStream.format("console").outputMode("complete").start
    spark.sql("select *,'stream3','update' from stream3").writeStream.format("console").outputMode("update").start.awaitTermination()
    */
    
    
    println("Ending steamRate1")
  }
  
  
}