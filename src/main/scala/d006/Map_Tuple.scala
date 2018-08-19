package d006

/**
  * map  tuple zip实例解析
  */
object Map_Tuple {

  def main(args: Array[String]): Unit = {
    //静态定义map集合注意这个map是不可变的 immutable
    var map = Map("book" -> 23, "gun" -> 21, "ipad" -> 20)
    //var map:Map[String，Int]
    //通过匹配模式 做变换 注意此此操作不影响原来的map集合 生成的新的map集合因为这种map是immutable类型的
    var map1 = for ((k, v) <- map) yield (k, v * 0.9)
    println(map)
    println(map1)

    //    定义可以修改的map集合 mutable
    val scores = scala.collection.mutable.Map("scala" -> 7, "spark" -> 8, "hadoop" -> 9)
    //取值
    val hadoop = scores.get("hadoop")
    println("hadoop=" + hadoop)
    //getOrElse 去key为x的值 如果不存在则返回函数中的第二个值
    val x = scores.getOrElse("x", 1)
    println("X=" + x)
    //删除元素
    scores -= "hadoop"

    //按照key的先后顺序排序
    val scoreMap = scala.collection.immutable.SortedMap("scala" -> 7, "spark" -> 9, "hadoop" -> 10)

    /*定义元祖*/
    val tuple = (1, 2, 3, "spark", "scala")
    //通过下标取值 是从1开始取值
    val third = tuple._3
    println("third=" + third)

    val (one, two, three, four, five) = tuple
    println("one=" + one + "two=" + two + "three=" + three + "four=" + four + "five=" + five)
    //    忽略接收
    val (j, k, _, _, _) = tuple
    println("j=" + j + "k=" + k)

    //
    //    def partition(p:Char=> Boolean):(String,String)
    val (a, b) = "spark hadoop".partition(_.isUpper)
    println("a=" + a + " b=" + b) //a=SH b=park adoop

    //zip操作
    val symbols = Array("[", "-", "]")
    val counts = Array(2, 5, 2)
    val pairs = symbols.zip(counts) //val pairs:Array[(String,Int)]
    for ((x, y) <- pairs) print(x * y)


  }
}
