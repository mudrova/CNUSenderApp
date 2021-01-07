package sender.model

import sender.common.Configuration

import java.time.LocalDateTime
import scala.io.Source
import scala.util.{Failure, Success, Try}

object MessageManager {

  val filePath = Configuration.idPath
  val id = readIdFromFile(filePath)


  def buildMessageEntity = {
    MessageEntity(Configuration.body, id, LocalDateTime.now().toString)
  }

  def readIdFromFile(path: String) : Int = {

    //TODO: resolve empty or corrupted file and close stream ?
    //    val bufferedSource = {
    //      Try(Source.fromFile(filePath)) match {
    //        case Success(idSource) => idSource
    //        case Failure(e) => println(e)
    //      }
    //    }

    val bufferedSource = Source.fromResource(filePath)
    val id = bufferedSource.getLines().mkString
    bufferedSource.close()

    id match {
      case id: String => id.toInt
      case _ => 1
    }
  }
}
