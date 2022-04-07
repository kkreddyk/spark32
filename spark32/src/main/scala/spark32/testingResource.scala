package spark32

object testingResource {
  
  
  def main(args: Array[String])
  {
    
    println("Starting "+this.getClass.getName)
    
    val fs=this.getClass().getClassLoader().getResourceAsStream("log4j.properties")
    
    val dataString=scala.io.Source.fromInputStream(fs).mkString
    
    println(dataString.getClass.getSimpleName)
    
    println(dataString)


    println("Ending "+this.getClass.getName)
  }
}