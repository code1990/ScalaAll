package d014

/**scala作为借口的trait在对象中混入trait代码实现*/
class UserTrait {

}

/*trait和Java的有所不同interface只能定义abstract class方法 而在trait中可以定义具体的实现方法*/
trait Logger{
  def log(msg: String)  //在trait中定义抽象方法
  def logImpl(msg: String){} //在trait中定义具体方法
}
/**
  * 类可以继承多个trait     语法为:extend trait with trait1
  */
class ConcreteLogger extends Logger with Cloneable{
  override def log(msg: String) = println("Log:"+msg)  //复写Logger trait中log抽象方法
  def concreteLogger{
    log("It's me")
  }
}
/*在使用对象混入trait使用的前提是 该traitLogger需要继承复写方法的那个trait*/
trait TraitLogger extends Logger{
  override def log(msg: String): Unit ={
    println("TraitLogger log content is "+msg)
  }
}

trait TraitLoggered{
  def logged(msg:String): Unit ={
    println("TraitLogger log content is "+msg)
  }
}

/*scala中作为借口的trait 在对象中混入trait*/
object InterfaceOps{
  def main(args: Array[String]): Unit = {
    val concreteLogger = new ConcreteLogger
    concreteLogger.concreteLogger

    val concreteLogger1 = new ConcreteLogger with TraitLogger //在实例化当中混入trait 则会调用TraitLogger中的log
    concreteLogger1.concreteLogger
  }
}