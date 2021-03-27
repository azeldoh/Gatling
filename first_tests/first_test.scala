package io.gatling.funspec.example

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.funspec.GatlingHttpFunSpec
import io.gatling.funspec.example.GatlingFunSpecExampleIT._

class GatlingFunSpecExampleIT extends GatlingHttpFunSpec {

  val baseURL = "https://reqres.in/"
  override def httpConf = super.httpConf.header("MyHeader", "MyValue")

  spec {
    http("Example index.html test")
      .get("/index.html")
      .check(body.exists)
      .check(h1.exists)
      .check(footer.exists)
  }

}

object GatlingFunSpecExampleIT {

  def h1 = css("h1")
  def body = css("body")
  def footer = css("footer")

}