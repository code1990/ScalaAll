package d010
/*scala单例对象 伴生对象实战详解*/
class University {
  val id = University.newStudentNo
  private var number =0
  def aClass(number:Int) = {this.number += number}
}

/*object可以作为一些静态方法区 静态常量区*/
object University{
  private var studentNo = 0
  def newStudentNo={
    studentNo+=1
    studentNo//scala方法中的最后一行就是方法的返回类型
  }
  private def call= {
    studentNo+=1
    studentNo
  }
}

/*scala单例对象 伴生对象实战详解*/
/*scala没有想在java中用于静态类，静态成员，静态方法
* scala提供了object对象类似于java中的静态类 在scala的object类中定义的所有的成员和方法都是静态的
*
* java类中的静态成员和方法会在加载时候只想 及时不去调用
* 而scala中的object只有在第一次使用的时候才回去执行 并不是加载的时候就去执行的
*
* 伴生类、伴生对象
* class A Object A 这2个类名一样
* 则class A 为object A的伴生类
* object A 为class A的伴生对象
* 而且class A可以任意访问它的伴生对象中的所有的成员 包括私有的private级别的def
*
* 注意 由于伴生对象的定义不在伴生类中 所以访问伴生对象中的成员 仍然是A.xxx的方式
* 一般而言 可以吧伴生对象作为伴生类的封装区域
* */
object ObjectOps{
  def main(args: Array[String]): Unit = {
    println("studenNo="+University.newStudentNo)//1
    println("studenNo="+University.newStudentNo)//2

    val arr = Array(1,2,3,4)//这样定义的数组其实是底层采取了类的伴生对象来构建的
  }
}