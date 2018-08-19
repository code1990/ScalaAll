package d024

import java.awt.event.{ActionEvent, ActionListener}

import javax.swing.{JButton, JFrame}

/*scala中SAM转换实战详解*/
object SAM_Curring {

  def main(args: Array[String]): Unit = {
    var data = 0
    var frame = new JFrame("SAM Testing")
    val jButton = new JButton("Counter")

    /*java中实现a按钮监听
    * 但是事实上我们不关心监听的ActionListener和实现事件处理的函数actionPerformed 以及事件对象 ActionEvent
    * */

    jButton.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        data += 1
        println("data="+data)
      }
    })

    /*scala监听*/
    implicit def convertedAction(action:(ActionEvent) =>Unit)={
      new ActionListener {
        override def actionPerformed(event: ActionEvent): Unit = {
          action(event)
        }
      }
    }
    jButton.addActionListener((event:ActionEvent)=>{data+=1;println("Data="+data)})

    frame.setContentPane(jButton)
    frame.pack()
    frame.setVisible(true)
  }

}
