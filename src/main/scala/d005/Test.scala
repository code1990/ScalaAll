package d005

class Test {

  def main(args: Array[String]): Unit = {
    val d = Array(2,3,4,5,6)
    val result3 = d.filter(_ % 2 == 0).map(_ * 2)
    println(result3)

    val sum2 = Array(1,-1,221).max //spark
    println(sum2)
  }
}
