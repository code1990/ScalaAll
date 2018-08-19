package d005
import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting
/*
实战005
操作数组实战详解*/
object ArrayOps {
  def main(args: Array[String]): Unit = {
     //定义长度为10的Int类型的定长数组
    val nums = new Array[Int](10)
    //定义长度为10的String类型的数组
    val a = new Array[String](10)
    //静态的定义方式
    val s = Array("hello","world")
    //修改数组中的值
    s(0)="goodbye"

    //for(e<-s)print(e+" ")

    /*for(e <- s) print(e+" ")*/
    /*定义 不定长数组*/
    val b = new ArrayBuffer[Int]();//val b:ArrayBuffer[Int]
    //追加
    b += 1
//    追加元祖
    b += (1,2,3,5)
//    追加数组++=
    b ++= Array(8,13,21)
    //切除后面5个元素
    b.trimEnd(5) //1 1 2
//    切除前面三个元素
    b.trimStart(3)

//    插入
    b.insert(2,6)
//插入多个值
    b.insert(2,3,4,5)
    //删除指定下标对应的值
    b.remove(2)
    //删除指定下标开始的n个元素 def remove(n:Int，Count:Int):Unit
    b.remove(2,3)
    //可变数组转换为不可变数组 ArrayBuffer --> Array 此时不能采用=+等操作了
    val c = b.toArray//val c:Array[Int]

//    遍历
//    for(e <- a) print(e+" ") null  null null

    val d = Array(2,3,4,5,6)
    //for yield 数组中每一个元素乘以2
    val result = for(e <- d) yield 2*e
//    for中过滤筛选
    val result2 = for(e <- d if e % 2 ==0)yield 2*e
//    for 中过滤筛选 方式同上
    val result3 = d.filter(_ % 2 == 0).map(_ * 2)
    //for(e <- result3) print(e+" ")

    //求和 求最大值
    val sum = Array(1,2,3,4).sum
    val sum1 = Array("spark","scala").max //spark
    val sum2 = Array(1,-1,221).max //spark

    //排序
    val arr = Array(1,2,3,4,5)
    //sorted操作不改变原来的数组
    var r = arr.sorted
    //快速排序
    var r2 = scala.util.Sorting.quickSort(arr)

    val array = Array(1,2,3,4,5)
    //连接 相当于js数组中的join方法 def mkString(sep:String）String
    val string = array.mkString(",")
    //def mkString(start: String,sep: String,end :String):String

    /**
      * 定义矩阵
      */
    val matrix = Array.ofDim[Int](3,4)
    //赋值
    matrix(2)(1)=42

    //定义二维数组
    val triangle = new Array[Array[Int]](10)
    for(index <- 0 until triangle.length){
      triangle(index) = new Array[Int](index+1)
    }

  }


}


