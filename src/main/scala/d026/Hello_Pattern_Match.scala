package d026
/*scala中模式匹配入门实战详解*/
object Hello_Pattern_Match {
  def main(args: Array[String]): Unit = {
    val data = 30
    data match {
      case 1 => println("first")//这是函数定义域实现的方式 =》 左侧可以是变量与条件表达式 =》右侧可以使函数的实现
      case 2 => println("Second")
      case _ => println("not know number")// case _ 代表所有的其他的情况

    }
    /*scala中模式匹配和java的swith case很像*/
    /*区别在于scala在每一个匹配完成以后自动break 不再往下匹配*/
    val result = data match {
      case i if i ==1 => "The first" //i和number为val用于接收传递进来的data 他们在声明的时候会被实例化为data的内容
      case number if number ==2 => "The second"
      case _ => "Not know Number"
    }
    println("result="+result)
    "spark!".foreach{
      c => println(
        c match {
          case ' ' => "space"
          case ch => "Char："+ch
        }
      )
    }




  }
}
