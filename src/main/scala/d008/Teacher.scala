package d008
//scala实战008 讲解scala的主构造器 私有构造器 构造器重载实例讲解
/*class Teacher（） 可以写 不写（）则默认无参数的主构造器*/
class Teacher {

  var name:String =_ //通过_给属性赋值表示当前没有值 不赋值则编译报错 这样的方式编译器会自动生成getset方法
  private var age =27 //这样的方式定义编辑器会生成私有的get/set方法
  private[this] var gender = "male"//这种private[this]定义的方式 这个变量只属于当情的实例

  /* 在一个类的内部定义一个构造器
  * 注意：1 这个构造器的this这一行不可以省略 它是在id奥运类的默认构造器
  * 2 这个类的附属构造器 每一个附属构造器必须调用其他的附属构造器 从最终形态上看 一定会调用类的柱构造器*/

  def this(name:String){
    this //不能省略 this()也可行
    this.name = name
  }

  def sayHello = println(this.name+":"+this.age+":"+this.gender)

}

/*定义有参数的主构造器的类
*
* 注意在柱构造器中声明var或者val的变量都会成为类的成员*/
class Teacher_(val name:String, val age:Int){
  println("this is the primary constructor...")
  var gender :String =_
  println("gender="+gender)//null
  def this(name:String,age:Int,gender:String){
    this(name,age)
    this.gender =gender
  }
}

/*定义有参数主构造器的类 但是不希望调用者使用主构造器*/
class Teacher2 private(val name:String,val age:Int){
  println("this is a primary constructor")
  var gender :String =_
  println("gender="+gender)
  def this(name:String,age:Int,gender:String){
    this(name,age)
    this.gender=gender
  }
}

/*scala主构造器
* 私有构造器
* 构造器重载实战详解**/

object OOPScala{
  def main(args: Array[String]): Unit = {
    var t = new Teacher()
    t.name="spark"
//    t.gender //无法访问
    t.sayHello

    var t1 = new Teacher_("spark",17)
    println(t1.name+":"+t1.age)

    var t2 = new Teacher_("spark",17,"male")
    println(t2.name+t2.age+t2.gender)

//    var t3 = new Teacher2("spark",17,"male") //编译报错 由于主构造器私有化 只有使用非主构造器
    var t4 = new Teacher_("spark",17,"male")//定义正确

  }
}