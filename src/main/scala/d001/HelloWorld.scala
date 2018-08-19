/*scala实战
* d001 scala开发环境的搭建 和helloworld解析
* */
object HelloWorld {

  /**
    * def 定义一个函数 这是main函数 是程序的入口
    *
    * @param args
    * Unit 返回值类型为空类型 相当于void
    */
  def main(args: Array[String]): Unit = {
    println("Hello World")
    /*遍历args数组中的值*/
    for (e <- args) println(e)
  }
}