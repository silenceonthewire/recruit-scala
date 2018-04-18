package controllers

import java.io.File
import java.util

import com.google.gson.{Gson, GsonBuilder}
import javax.inject._
import models.{ExcelData, Node}
import org.apache.poi.ss.usermodel.WorkbookFactory
import play.api._
import play.api.mvc._

import scala.collection.JavaConverters._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, configuration: Configuration) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>

    val filename = configuration.getString("file.path")
    val nodes: util.List[Node] = getData(filename.get)
    Ok(views.html.index(nodes.asScala.toList))
  }

  def json() = Action { implicit request: Request[AnyContent] =>

    val filename = configuration.getString("file.path")
    val nodes: Array[Node] = getData(filename.get).asScala.toArray
    val gson: Gson = new GsonBuilder().create()
    Ok(gson.toJson(nodes))
  }

  def getData(filename:String): util.List[Node] = {

    val excelDataSet: util.ArrayList[ExcelData] = getExcelData(filename)

    val nodes: util.List[Node] = new util.LinkedList[Node] {};

    excelDataSet.forEach(excelCell => {

      if(!excelCell.firstLevel.toString.equals("")){

        val node: Node = new Node(excelCell.id.toString, excelCell.firstLevel.toString, new util.LinkedList[Node]())
        nodes.add(node);
      } else if(!excelCell.secondLevel.toString.equals("")){

        val node: Node = new Node(excelCell.id.toString, excelCell.secondLevel.toString, new util.LinkedList[Node]())
        nodes.get(nodes.size()-1).nodes.add(node)
      } else {

        val node: Node = new Node(excelCell.id.toString, excelCell.thirdLevel.toString, new util.LinkedList[Node]())
        val firstLevelNodes: util.List[Node] = nodes.get(nodes.size()-1).nodes
        nodes.get(nodes.size()-1).nodes.get(firstLevelNodes.size()-1).nodes.add(node)
      }
    })

    nodes
  }

  def getExcelData(filename: String): util.ArrayList[ExcelData] = {
    val workbook = WorkbookFactory.create(new File(filename))
    val sheet = workbook.getSheetAt(0);
    val excelDataSet = new util.ArrayList[ExcelData]();

    sheet.forEach(row => {
      val data = new ExcelData
      data.firstLevel = row.getCell(0)
      data.secondLevel = row.getCell(1)
      data.thirdLevel = row.getCell(2)
      data.id = row.getCell(3)

      excelDataSet.add(data);
    });

    excelDataSet.remove(0)
    excelDataSet
  }
}
