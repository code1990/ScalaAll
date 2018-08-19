package d004
import scala.io.Source
/*
实战004
for和function的进阶实践 lazy的使用*/
object ArrayOps {
  def main(args: Array[String]): Unit = {
    for(i <- 1.to(2);j <- 1.to(2))print((100*i+j)+" ")//101 102 201 202
    println

    /*for表达式中的判断可以加入复杂的条件表达式》》重要*/
    for(i <- 1.to(2);j <- 1.to(2) if i!=j)print((100*i+j)+" ")
    println

    /*重要：在scala中函数有值的"="右边是对 怎么对函数进行
    * 计算 所以函数是可以作为参数进行传递的*/
    def addA(x:Int) = x+100// def addA(x:Int):Int
    println("the result from a function is:"+addA(1))

    /*"="的右侧其实是一个函数(x:Int) => x+100 这个函数没有名字是一个匿名函数*/
    var add=(x:Int) => x+100
    println("The result from a val is :"+add(2))

    /*递归调用 在scala中必须指明函数的返回值*/
    def fac(n:Int):Int = if(n<=0) 1 else n*fac(n-1)
    println("the result from a fac is:"+fac(10))

    /*函数的默认值 param:type=value*/
    def combine(content:String,
                left:String="{",
                right:String="}")=left+content+right
    println("the result from a combine is :"+combine("I love you"))
    println("the result from a combine is :"+combine("I love you","(^","^)"))

    /*函数的参数是可变的 定义方式param:type*/
    def plus(x:Int*)={
      var result =0
      for(e <- x) result +=e
      result
    }
    println("the result from a plus is:"+plus(1))
    println("the result from a plus is:"+plus(1,2,3,4,5))

    /*lazy延时加载*/
    val f  = Source.fromFile("D:\\temp\\zzfx.txt")//由于路径不存在 导致异常 证明变量在定义以后就会加载
    lazy val file = Source.fromFile("D:\\zzfx.txt") //lazy是关键字 声明的变量只有在第一次使用的时候才会加载 证明是延时加载
    println("go")


  }


}


