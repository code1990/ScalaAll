package d018
import scala.io.Source
import java.io.File
import java.io.PrintWriter
/*scala文件的读取写入 控制台输入操作代码实战*/
class FileOps {

  def main(args: Array[String]): Unit = {
    //读取本地文件
    val file = Source.fromFile("D:\\temp\\zzfx.txt") //返回BufferedSource文件迭代器
    for(line <- file.getLines())println(line)//def getLines():Iterator[String]
    file.close()

//    读取网络文件
    val webFile = Source.fromURL("http://spark.apache.org/")
    webFile.foreach(print(_))
    webFile.close()

    //写入文件
    val writer = new PrintWriter(new File("scalaFile.txt"))
    for(i <- 1 to 100) writer.println(i)
    writer.close()

    //从控制台输入
    println("please enter your input:")
    val line = Console.readLine
    println("Thanks you just type:"+line)
  }
}
