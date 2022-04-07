package spark32

object testingResource {
  
  
  def main(args: Array[String])
  {
    
    println("Starting "+this.getClass.getName)
    
    val fs=this.getClass().getClassLoader().getResourceAsStream("log4j.properties") //To read the file from src/main/resources into BufferedInputStream
    println("Data Type of fs="+fs.getClass.getSimpleName) //To get data type of the variable use var.getClass.getSimpleName

    val dataString=scala.io.Source.fromInputStream(fs).mkString //To read from BufferedInputStream
    println("Data Type of dataString="+dataString.getClass.getSimpleName)
    
    println("Printing content of the file::"+dataString)


    println("Ending "+this.getClass.getName)
  }
}