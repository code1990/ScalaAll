package d012
/*scala中的继承 超类的构造 重写字段从重写方法*/
class Person(val name:String,var age:Int){
  println("this is primary constructor of person")
  val school = "MIT"
  def sleeep = "8 hour"
  /*编码规则 复写方法需要表名override关键字*/
  override def toString = " I am a Person"
}
/*worker继承自person
* 子类在继承子父类时候
* 1.需要调用父类的主构造器 在子类声明时候需要将父类的构造器参数全部传递给子类的主构造器 否则会编译报错
* 2.编译规则 复写方法或者字段需要标明override关键字*/
class Worker(name:String , age: Int, salary: Long)extends Person(name,age){
  println("this is the subclass of person ,primary constructor of worker")
  override val school = "spark"

  //复写父类的字段
  override def toString: String = "I am a worker"+super.sleeep//在子类中调用父类的方法需要使用super关键字
}


object OverrideOps {

  def main(args: Array[String]): Unit = {
    val worker = new Worker("spark",5,1000)
    /*row result ：the primary constructor of person
    * the is the subclass of Person ，primary constructor of worker
    * */

    println("school"+worker.school)
//    println("salary"+worker.salary)
    println(worker)
  }
}
