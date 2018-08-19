package d016
/*scala包的定义 包对象 包的引用 包的隐式引用*/
object PackageOps {}

/*scala包的隐式引用*/
//import java.lang._ //java.lang包里面的所有的内容 想当于 import java.lang.*
//import scala._ //scala包里面的所有的内容
//import Predef._ //Predef对象中包含的所有内容

/*引入内容方式*/
//import java.awt.{Color,Font} 采取{}的方式来引入包中的部分内容
//import java.util.{HashMap=>JavaHashMap}//处理scala中和java中的包命名冲突问题  取别名
//import scala.{StringBuilder=>_} 采用=>_占位符的方式屏蔽内容 这样就无法访问scala包下面的StringBuilder这个内容

/*包对象
* 因为在包中不可以定义成员和方法 所以可以将一些需要成员和方法定义在包对象中 便于包的类的可以访问
* 作用 包中所有的类就可以访问包对象中的所有的成员和方法
* */
//可以在包中定义包对象 package object packageName
package object people{
  val defaultName = "scala"
}

//包中所有的
package people{
  //val defaultName = "scala"//包中可以不定义成员和方法
  class people{
    var name = defaultName//访问包对象中的成员和方法
  }
}

class PackageOps {}
//包的定义可以采用这种链的方式定义
package spark.navigation{
  abstract class Navigation{
    def act
  }
  package tests {
    //该类在spark.navigation.tests包里面
    class NavigationSuite
  }
  package impl{
    class Action extends Navigation{
      def act = println("Action")
    }
  }
}
package hadoop{
  package navigation{
    class Navigation
  }
  package launch{
    class Booster{
      //val nav = new hadoop.navigation.Navigation//可以写全包名
      val nav = new navigation.Navigation
    }
  }
}