package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite

class NodesListTest extends PlaySpec with GuiceOneAppPerSuite {

  def homeController = app.injector.instanceOf(classOf[HomeController])

  "List of nodes" should {

    "be retireved by" in {

      val listOfNodes = homeController.getData("/srv/data/test1.xlsx")

      assert(listOfNodes.get(0).id.equals("1.0"), true)
      assert(listOfNodes.get(0).name.equals("A"), true)

      assert(listOfNodes.get(0).nodes.get(0).id.equals("2.0"), true)
      assert(listOfNodes.get(0).nodes.get(0).name.equals("AA"), true)

      assert(listOfNodes.get(0).nodes.get(0).nodes.get(0).id.equals("3.0"), true)
      assert(listOfNodes.get(0).nodes.get(0).nodes.get(0).name.equals("AA1"), true)

      assert(listOfNodes.get(0).nodes.get(0).nodes.get(1).id.equals("4.0"), true)
      assert(listOfNodes.get(0).nodes.get(0).nodes.get(1).name.equals("AA2"), true)

      assert(listOfNodes.get(0).nodes.get(1).id.equals("5.0"), true)
      assert(listOfNodes.get(0).nodes.get(1).name.equals("AB"), true)

      assert(listOfNodes.get(1).id.equals("6.0"), true)
      assert(listOfNodes.get(1).name.equals("B"), true)

      assert(listOfNodes.get(2).id.equals("7.0"), true)
      assert(listOfNodes.get(2).name.equals("C"), true)

      assert(listOfNodes.get(2).nodes.get(0).id.equals("8.0"), true)
      assert(listOfNodes.get(2).nodes.get(0).name.equals("CA"), true)

      assert(listOfNodes.get(2).nodes.get(0).nodes.get(0).id.equals("9.0"), true)
      assert(listOfNodes.get(2).nodes.get(0).nodes.get(0).name.equals("CA1"), true)

      assert(listOfNodes.get(2).nodes.get(0).nodes.get(1).id.equals("10.0"), true)
      assert(listOfNodes.get(2).nodes.get(0).nodes.get(1).name.equals("CA2"), true)

      assert(listOfNodes.get(3).id.equals("11.0"), true)
      assert(listOfNodes.get(3).name.equals("D"), true)

      assert(listOfNodes.get(3).nodes.get(0).id.equals("12.0"), true)
      assert(listOfNodes.get(3).nodes.get(0).name.equals("DA"), true)
    }
  }

}
