package spark32


import org.apache.spark.sql.SparkSession

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Properties;

import org.apache.log4j.LogManager
import org.apache.log4j.Logger
import org.apache.log4j.PropertyConfigurator
import org.apache.log4j.Level

object jdbc {


	def main(args: Array[String]){

		println("JDBC Start::::....::")



		val logger: Logger = LogManager.getLogger(this.getClass.getName)

		val dateFormat: SimpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("runid", dateFormat.format(new Date()));

		PropertyConfigurator.configure(args(0))
		logger.info("Logger : Welcome to log4j::"+this.getClass.getName)

		val spark=SparkSession.builder.master("local[*]").getOrCreate()

		spark.sparkContext.setLogLevel("ERROR")
		spark.conf.getAll.foreach(println)

		val jdbcDF = spark.read
		.format("jdbc")
		.option("url", "jdbc:postgresql://localhost:5432/postgres")
		.option("user", "postgres")
		.option("password", "postgres")
		.option("dbtable","public.t1")
		.load()

		jdbcDF.show(false)


		val connectionProperties = new Properties()
		connectionProperties.put("user", "postgres")
		connectionProperties.put("password", "postgres")

		val query="(select count(*) as cnt from public.t1 )q"

		//val jdbcDF2 = spark.read.jdbc("jdbc:postgresql://localhost:5432/postgres","public.t1",connectionProperties)

		val jdbcDF2 = spark.read.jdbc("jdbc:postgresql://localhost:5432/postgres",query,connectionProperties)


		//Thread.sleep(100000)
		jdbcDF2.show(false)

		val target_table="public.t2"

		jdbcDF2.write.mode("append").option("truncate","true").jdbc("jdbc:postgresql://localhost:5432/postgres",target_table,connectionProperties)

		spark.read.jdbc("jdbc:postgresql://localhost:5432/postgres","public.t2",connectionProperties).show(false)

	}
}