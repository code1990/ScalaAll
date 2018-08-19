package d017
/*scala中的包类对象成员 伴生对象 伴生对象的访问权限*/
package spark {

  package navigation{
    private[spark] class Navigator{//class前面的private用于限定该类的可以见度 表示navigator的可见度在可以拓展的spark包下
      protected [navigation] def useStarChart(): Unit ={
        class LegOfJourney{
          private [Navigator] val distance = 100
        }
//        private[this] var speed = 200
      }
    }
  }

  package launch{
    import navigation._
    object Vehice{
      private[launch] val guide = new Navigator
    }
  }
}

class PackageOps_Advanced{
  import d017.PackageOps_Advanced.power
  private def canMakeItTrue = power > 10001
}
object PackageOps_Advanced{
  private def power = 1000
  def makeItTrue(p:PackageOps_Advanced):Boolean = {
    val result = p.canMakeItTrue
    result
  }
}