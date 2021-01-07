package sender

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import sender.model.MessageManager
import sender.protocols.MessageProtocol


object CNUSenderApp extends MessageProtocol with SprayJsonSupport {
  implicit val system = ActorSystem("senderApp")
  val messageEntity = MessageManager.buildMessageEntity

  //TODO: unmarshal
  val route: Route = (path("api" / "message") & get) {
    complete(s"body: ${messageEntity.body}, id: ${messageEntity.id}")
  }

  def main(args: Array[String]): Unit = {

    //TODO: bindingFuture and terminate
    Http().newServerAt("localhost", 8081).bind(route)

    println(s"Server online at http://localhost:8081/")

  }

}