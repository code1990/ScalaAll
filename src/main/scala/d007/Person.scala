package d007
/*scala类对象的属性和对象私有字段讲解*/
class Person {//class classname 默认为public级别的
  private var age = 0;//与java不同是这样的方式定义必须赋值 否则编译报错
  def increment() {age+=1}
  def current = age //等价于def current() = age 没有参数可以省去括号
}

class student{
  /*在java中定义private属性需要手动生成get/set方法
  * 在scala中定义了private[this] var age:Int的属性自动会生成Get/set方法*/
  var age = 0//这种var age= 0的原型为private[this] var age:Int 并且会自动生成get/set方法
  private var ageA = 0 //这种private var ageA = 0 的原型仍然是private[this] 但是不会自动生成get/set方法

  private[this] var ageB = 0//对象私有字段限定这个属性为当前对象的方法能够访问 不能被当前对象的类的方式去使用

  /*这种val的声明方式为只读模式 其原型为private[this] val name:String*/
  /*会自动生成final类型的私有字段和get方法 不会生成set方法*/
  val name="scala"

  def isYounger(other:student) = ageA < other.ageA//如果将ageA定义为private[this] var ageA = 0编译会出错
}

/*scala类的属性和对象的私有字段实战详解*/
object helooOOP{
  def main(args: Array[String]): Unit = {
    var person = new Person()
    person.increment()
    println(person.current)

    /*var stu =  new Student */ //等价于var stu = new Student()
    /*
    * gettter
    * stu.age 调用的是age私有属性的getter方法并且不是直接访问age属性
    * 鼠标上移动 有提示 def age :Int
    * println(stu.age)
    * */

    /*
    * setter
    * stu.age =10 这种复制方法不是吧10的赋值给age属性 而且age为private级别的 也无法访问
    * 其实是调用了setter方法
    * def age_=(x$1:Int):Unit
    *stu.age =10
    * println(stu.age)
    * */

    var stu = new student

//    这种访问方式是直接访问name属性
    //stu.name="Hadoop"//编译直接报错 因为是只读模式
    println(stu.name)
  }
}