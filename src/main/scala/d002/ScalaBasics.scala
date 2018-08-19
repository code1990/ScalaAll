package d002

import java.io.File;

/*
* scala实战第二课 scala函数定义流程控制 异常处理入门实践
* scala函数定义 流程控制 异常处理入门实例
* */
object ScalaBasics {
  /*无参数函数*/
  def doWhile(): Unit = {
    do {
      line = readLine() //从控制台读取一行输入的内容
      println("Read:" + line)
    } while (line != "")
  }

  /**
    * 因为object的方法都是静态方法 所以下面这一段代码也是可以执行的 及时不在方法区
    */
  var line = "";
  do{
    line = readLine();
    println("Read:"+line)
  }while(line != "")

  def looper(x:Long,y:Long):Long={
    var a=x
    var b=y
    while(a!=0){
      var temp =a
      a = b%a
      b = temp
    }
    b //返回时候 不需要写return
  }

  def main(args: Array[String]): Unit = {
    println("Hello World") //注意可以么有“；”
    for(e <- args)println(e)
    doWhile //参数函数 可以省去括号调用
    println("looper result:"+looper(2,4))

    /*if分支语句*/
    var file2 = "sacala.txt";
    if(!args.isEmpty) file2 =args(0)
    println("file:"+file2)

    /*三目运算符*/
    var file1 = if(!args.isEmpty)args(0) else "site.xml"
    println("file:"+file1)
    /*可以把三目运算的结果看成一个值 表达式的值*/
    println((if(!args.isEmpty)args(0) else "site.xml"))


    /*循环*/
    for(i <- 1 to 10)println("the number is"+i)
    println(1.to(10));//--> Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    //增强for循环
    val fs = (new File(".")).listFiles() //return Array[File]
    for(f <- fs)println(f)

    //异常的处理
    val n = 99;
    val file = "spark.txt"
    //open the file
    try{
      val half = if(n%2==0)n/2 else
        throw new RuntimeException("N must be even")
    }catch {
      //异常匹配模式
      case e:Exception => println("the exception is "+e.getMessage)
    }finally {
      //close the file
    }








  }




}


