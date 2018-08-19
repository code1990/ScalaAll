package d031

/*options 使用和实现内幕源码解密
* options的源码定义
* sealed abstract class Option[+A] extends Product with serializable
* sealed 关键字有一个强制的要求：options下定义的所有的case class 和case object都必须在同一个文件当中
* Option 有2个直接实现的子类
* some:Option中具体的值
* None:Option没有具体的值
*
* final case class Some[+A](x:A)extends Option[A]{
*   def isEmpty = false
*   def get =x
* }
* case object None extends Option[Nothing]{
* def isEmpty = true
* def get = throw new NoSuchElementException("None.get")
*
* */
object OptionsOps {
  def main(args: Array[String]): Unit = {
    val score = Map("Alice"->99,"Spark"->100)
    //def get(key:String):Options[Int]
    score.get("Alice") match {
      case Some(score) => println("score="+score)
      case None => println("No score")
    }
    println(score.get("Alice"))
  }
}
