package d009

//定义外部类名称 使用内部类调用
class Outer(val name:String) { outer =>
    class Inner(val name:String){
    def foo(b:Inner): Unit ={
    println("outer:"+outer.name+"innername"+b.name)
  }
}

  /*scala内部类实战详解
  * scala的内部类和java的内部类有很大区别
  * Java的内部类是从属于外部类的
  * Scala的内部类是从属于对象的 new出外部类对象的每一个内部类都是不同的 内部类属于外部类的实例本身
  * */
}
object OOPInnerClass{
  def main(args: Array[String]): Unit = {
    val outer1 = new Outer("spark")
    val outer2 = new Outer("hadoop")
    /*内部类的方式和java的方式不同 java是outer1.new Inner()*/

    val inner1 = new outer1.Inner("scala")
    val inner2 = new outer2.Inner("Java")
    inner1.foo(inner1)
    inner2.foo(inner2)

//    inner1.foo(inner2)错误 但在java中是可以行的

  }
}
