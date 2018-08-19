package d020
import scala.io.Source

/*scala的本地函数与作为语言一等公民的函数详解*/
object FunctionOps {

  def main(args: Array[String]): Unit = {
    val width = args(0).toInt
    for(arg <- args.drop(1)){
      processData(arg,width)
    }
    /*函数是有值的 函数可以赋值给变量
    * （x:Int) => x+1 (x:Int)是匿名的 ”=>"为函数的实现
    * */
    var increase = (x:Int) => x+1
    println(increase(5))
    //变量可以改变 其他函数值
    increase = (x:Int) => x*2
    println(increase(5))
    println("---------------")

    val someNumbers = List(-11,-10,-5,0,1,2,3,4)
    someNumbers.foreach((x:Int)=>print(x+"\t"))
    println()
    someNumbers.filter((x:Int) => x> 0).foreach((x:Int) => print(x+"\t"))
    println()
    someNumbers.filter((x) =>x >0).foreach((x:Int)=> print(x+"\t"))
    println()
    someNumbers.filter(_>0).foreach((x:Int)=>print(x+"\t"))
    val f = (_:Int)+(_:Int)
    println()
    println(f(5,10))
  }

  /*本地函数
  * 本地函数所在的函数 外界不可以访问访问本地函数
  * 本地函数可以访问 所在函数传递进来的参数
  *
  * scala中允许在函数中定义函数 定义的函数在私有函数 外界不可以访问 这样的函数被称之为本地函数或者内部函数
  * 这样的做的理由是因为函数在scala中是一等公民 函数可以看成变量一样 可以赋值
  * */

  def processData(filename: String, width: Int): Unit ={
    //该函数为processData的私有函数 外部不可以访问
    def processLine(line:String): Unit ={
      if(line.length > width)
        println(filename+":"+line)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines)
      processLine(line)
  }
}
