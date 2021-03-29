package learngatling

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class firsttest extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9,pl;q=0.8")
		.contentTypeHeader("application/x-www-form-urlencoded")
		.doNotTrackHeader("1")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36")

	val headers_0 = Map(
		"Cache-Control" -> "max-age=0",
		"Origin" -> "http://computer-database.gatling.io")



	val scn = scenario("firsttest")
		.exec(http("request_0")
			.post("/computers")
			.headers(headers_0)
			.formParam("name", "aaaaaaaa")
			.formParam("introduced", "0000-11-11")
			.formParam("discontinued", "0000-12-12")
			.formParam("company", "1"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}