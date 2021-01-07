package sender.protocols

import sender.model.MessageEntity
import spray.json.{DefaultJsonProtocol, JsonFormat}

object MessageEntityProtocol extends DefaultJsonProtocol {
  implicit val format: JsonFormat[MessageEntity] = jsonFormat3(MessageEntity)

}

