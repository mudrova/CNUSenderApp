package sender.protocols

import spray.json.DefaultJsonProtocol

case class Message(body: String, id: Int)

trait MessageProtocol extends DefaultJsonProtocol {
  implicit val format = jsonFormat2(Message.apply)

}