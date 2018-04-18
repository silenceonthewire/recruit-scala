package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class HomeControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "HomeController GET" should {

    "render index page" in {

      val request = FakeRequest("GET", "/").withHeaders(HOST -> "localhost:9000")
      val home = route(app, request).get
      assert(home.isCompleted, true)
      contentAsString(home) must include ("1.0")
      contentAsString(home) must include ("2.0")
      contentAsString(home) must include ("3.0")
      contentAsString(home) must include ("4.0")
      contentAsString(home) must include ("5.0")
      contentAsString(home) must include ("6.0")
      contentAsString(home) must include ("7.0")
      contentAsString(home) must include ("8.0")
      contentAsString(home) must include ("9.0")
      contentAsString(home) must include ("10.0")
      contentAsString(home) must include ("11.0")
      contentAsString(home) must include ("12.0")
      contentAsString(home) must include ("A")
      contentAsString(home) must include ("AA")
      contentAsString(home) must include ("AA1")
      contentAsString(home) must include ("AA2")
      contentAsString(home) must include ("AB")
      contentAsString(home) must include ("B")
      contentAsString(home) must include ("C")
      contentAsString(home) must include ("CA")
      contentAsString(home) must include ("CA1")
      contentAsString(home) must include ("CA2")
      contentAsString(home) must include ("D")
      contentAsString(home) must include ("DA")
    }
  }

  "HomeController Json GET" should {

    "render json" in {

      val request = FakeRequest("GET", "/json").withHeaders(HOST -> "localhost:9000")
      val home = route(app, request).get
      assert(home.isCompleted, true)
      contentAsString(home) must include ("1.0")
      contentAsString(home) must include ("2.0")
      contentAsString(home) must include ("3.0")
      contentAsString(home) must include ("4.0")
      contentAsString(home) must include ("5.0")
      contentAsString(home) must include ("6.0")
      contentAsString(home) must include ("7.0")
      contentAsString(home) must include ("8.0")
      contentAsString(home) must include ("9.0")
      contentAsString(home) must include ("10.0")
      contentAsString(home) must include ("11.0")
      contentAsString(home) must include ("12.0")
      contentAsString(home) must include ("A")
      contentAsString(home) must include ("AA")
      contentAsString(home) must include ("AA1")
      contentAsString(home) must include ("AA2")
      contentAsString(home) must include ("AB")
      contentAsString(home) must include ("B")
      contentAsString(home) must include ("C")
      contentAsString(home) must include ("CA")
      contentAsString(home) must include ("CA1")
      contentAsString(home) must include ("CA2")
      contentAsString(home) must include ("D")
      contentAsString(home) must include ("DA")
    }
  }


}
