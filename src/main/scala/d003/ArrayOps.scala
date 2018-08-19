package d003
import scala.io.Source
/*scala实战3
* 详解Tuple Array Map与文件操作入门
* */
object ArrayOps {
  def main(args: Array[String]): Unit = {
    /*首先是数组的遍历方式*/
    var array = Array(1,2,3,4,5)//数组的静态定义Array[Int]
    /*遍历数组的方式*/
    for(index <- 0 until array.length) println(array(index))
    /*遍历数组的方式二*/
    for(e <- array)println(e)

    /*其次是元祖的遍历方式*/
    //注意 鼠标上移动变量pair 显示var pair:(int,String,String) 这是scala的类型判断
    var pair = (100,"Scala","spark")
//    println(pair._0)//注意 去元素是从小标1开始，。——0会编译错误
    println(pair._1)
    println(pair._2)
    println(pair._3)

    /*遍历map*/
    var entry= Map("John"->21,"bell"->24)//map的静态定义 var entry:Map[String,Int]
    /*遍历k,v采取tuple的方式*/
    for((k,v)<-entry) println("key"+k+";value="+v)
    /*遍历k 忽略value*/
    for((k,_) <- entry)println("key="+k)//(k,_)为占位符

    /*文件类操作*/
    val file = Source.fromFile("D:\\temp\\zfx.txt") //返回类型为BufferedSource
    val files = Source.fromURL("http://spark.apache.org/")//抓取网络信息
    var lines = file.getLines();//var lines :Iterator[String]
    for(line <- lines)println(line)
  }

}


