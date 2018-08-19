package d022
/*scala闭包实战详解*/
object ClosureOps {

  def main(args: Array[String]): Unit = {
    val data = List(1,2,3,4,5,6)
    var sum =0
    data.foreach(sum += _)
    println(sum)

    def add(more:Int) = (x:Int)=> x+more
    val a =add(1)//等价于 def a(x:Int) = x+1
    val b = add(9999)//等价于 def b(x:Int) = x+9999
    println(a(10))
    println(b(10))

  }
}
