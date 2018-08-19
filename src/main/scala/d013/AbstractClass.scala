package d013
/*抽象类 抽象方法 抽象字段*/
class AbstractClass {
//在普通类中字段必须赋值 有2种方式 1,附具体的参数值 2“_"占位符赋值方法 表名只占位但是没有具体的值
  var id:Int = _ //注意 这种方式必须声明为var  因为_的值不明确
}
abstract class SuperTeacher(val name:String){
  var id:Int//抽象字段定义只需赋值 即为抽象字段
  var age :Int //抽象字段定义
  def teach//抽象方法定义:与java不同的是方法定义不需要有abstract声明 只需要不写方法体即可
}
class TeacherForMaths(name:String) extends SuperTeacher(name){
  override var id = name.hashCode();
  //override可以不写 采取override标识为为复写属性
  override var age = 20

  override def teach =println("teching math")
}
/*抽象类 抽象字段 抽象方法*/
object AbstractOps{
  def main(args: Array[String]): Unit = {
    val teacher = new TeacherForMaths("spark")
    teacher.teach

    println("teacher.id"+teacher.id)
    println("teacher.age"+teacher.age)
  }
}