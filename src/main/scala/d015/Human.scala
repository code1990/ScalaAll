package d015
/*scala中多继承 多重继承构造器执行顺序 以及AOP实现*/
class Human{
  println("Human")
}
trait TTeacher extends Human{
  println("TTeacher")
  def teach
}
trait PianoPlayer extends Human{
  println("PianoPlayer")
  def playPiano = println("I'm playing piano....")
}
//PianoTeacher的构造器顺序是有左往右构造的 scala中不会重复构造 虽然TTeacher PianoPlayer都继承了Human
//scala中会把extends右边看成一个整体的human with TTeacher with PianoTeacher 也可以通过匿名的方式new出来
//val e = new Human with TTeacher with PianoPlayer{需要复写的方法}
class PianoTeacher extends Human with TTeacher with PianoPlayer{
  override def teach = println("I'm trianing student...")
}

/*scala多重继承 多重继承构造器执行顺序以及AOP实现*/
object UserTrait{
  def main(args: Array[String]): Unit = {
    val t1 = new PianoTeacher
    /*构造时候结构为 Human TTeacher PianoPlayer*/
    t1.playPiano
    t1.teach
    println(
      "-------"
    )

    /*方法二 通过匿名的方式创建pianoteacher*/
    val t2 = new Human with TTeacher with PianoPlayer{
      override def teach = println("I'm teaching student...")
    }

    /*这种方法类似于Java中定义匿名函数实现接口的类的简化方式
    * new Instance({
    * @override
    * public void run(){
    * //do something
    * }
    * })
    * */
    t2.playPiano
    t2.teach

  }
}

trait Action{
  def doAction
}
trait TBeforeAfter extends Action{
  //注意 doAction虽然被复写 单仍然是abstract方法 因为super.doAction并未实现 所以用abstract关键字标识
  abstract override def doAction: Unit = {
    println("Initialization")
    super.doAction
    println("Destroyer")
  }
}

class Work extends Action{
  override def doAction: Unit = {
    println("working")
  }
}

/*scala中实现aop*/
object AOP{
  def main(args: Array[String]): Unit = {
    val w = new Work with TBeforeAfter
    w.doAction
  }
}