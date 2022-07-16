package spark32


import org.apache.spark.sql.SparkSession
import sys.process._

object spark_df_write {


	def main(args: Array[String])
	{
		println("--oo--")

		val spark = SparkSession.builder.master("local[*]").getOrCreate()


		spark.conf.getAll.foreach(println)

		import spark.implicits._

		val s=Seq(("a","b"),("c","d"))

		val df=s.toDF

		df.show()

		spark.sql("show tables").show(false)
		
		

		df.write.saveAsTable("spark_df_write_table_3")
		df.write.insertInto("spark_df_write_table_3")
		spark.sql("select * from spark_df_write_table_3").show(false)

		spark.sql("show create table spark_df_write_table_3").show(false)
		spark.sql("show tables").show(false)

	}
}