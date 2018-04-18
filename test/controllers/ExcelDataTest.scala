package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.Logger

class ExcelDataTest extends PlaySpec with GuiceOneAppPerSuite {

  def homeController = app.injector.instanceOf(classOf[HomeController])

  "List of excel cell" should {

    "be retrieved by" in {

      val excelData = homeController.getExcelData("/srv/data/test1.xlsx")

      Logger.info("first row")
      assert(excelData.get(0).firstLevel.toString.equals("A"))
      assert(excelData.get(0).secondLevel.toString.equals(""))
      assert(excelData.get(0).thirdLevel.toString.equals(""))
      assert(excelData.get(0).id.toString.equals("1.0"))

      Logger.info("second row")
      assert(excelData.get(1).firstLevel.toString.equals(""))
      assert(excelData.get(1).secondLevel.toString.equals("AA"))
      assert(excelData.get(1).thirdLevel.toString.equals(""))
      assert(excelData.get(1).id.toString.equals("2.0"))

      Logger.info("third row")
      assert(excelData.get(2).firstLevel.toString.equals(""))
      assert(excelData.get(2).secondLevel.toString.equals(""))
      assert(excelData.get(2).thirdLevel.toString.equals("AA1"))
      assert(excelData.get(2).id.toString.equals("3.0"))

      Logger.info("fourth row")
      assert(excelData.get(3).firstLevel.toString.equals(""))
      assert(excelData.get(3).secondLevel.toString.equals(""))
      assert(excelData.get(3).thirdLevel.toString.equals("AA2"))
      assert(excelData.get(3).id.toString.equals("4.0"))

      Logger.info("fifth row")
      assert(excelData.get(4).firstLevel.toString.equals(""))
      assert(excelData.get(4).secondLevel.toString.equals("AB"))
      assert(excelData.get(4).thirdLevel.toString.equals(""))
      assert(excelData.get(4).id.toString.equals("5.0"))

      Logger.info("sixth row")
      assert(excelData.get(5).firstLevel.toString.equals("B"))
      assert(excelData.get(5).secondLevel.toString.equals(""))
      assert(excelData.get(5).thirdLevel.toString.equals(""))
      assert(excelData.get(5).id.toString.equals("6.0"))

      Logger.info("seventh row")
      assert(excelData.get(6).firstLevel.toString.equals("C"))
      assert(excelData.get(6).secondLevel.toString.equals(""))
      assert(excelData.get(6).thirdLevel.toString.equals(""))
      assert(excelData.get(6).id.toString.equals("7.0"))

      Logger.info("eighth row")
      assert(excelData.get(7).firstLevel.toString.equals(""))
      assert(excelData.get(7).secondLevel.toString.equals("CA"))
      assert(excelData.get(7).thirdLevel.toString.equals(""))
      assert(excelData.get(7).id.toString.equals("8.0"))

      Logger.info("ninth row")
      assert(excelData.get(8).firstLevel.toString.equals(""))
      assert(excelData.get(8).secondLevel.toString.equals(""))
      assert(excelData.get(8).thirdLevel.toString.equals("CA1"))
      assert(excelData.get(8).id.toString.equals("9.0"))

      Logger.info("tenth row")
      assert(excelData.get(9).firstLevel.toString.equals(""))
      assert(excelData.get(9).secondLevel.toString.equals(""))
      assert(excelData.get(9).thirdLevel.toString.equals("CA2"))
      assert(excelData.get(9).id.toString.equals("10.0"))

      Logger.info("eleventh row")
      assert(excelData.get(10).firstLevel.toString.equals("D"))
      assert(excelData.get(10).secondLevel.toString.equals(""))
      assert(excelData.get(10).thirdLevel.toString.equals(""))
      assert(excelData.get(10).id.toString.equals("11.0"))

      Logger.info("12th row")
      assert(excelData.get(11).firstLevel.toString.equals(""))
      assert(excelData.get(11).secondLevel.toString.equals("DA"))
      assert(excelData.get(11).thirdLevel.toString.equals(""))
      assert(excelData.get(11).id.toString.equals("12.0"))
    }
  }

}
