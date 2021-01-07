package sender.common

import com.typesafe.config.{Config, ConfigFactory}

object Configuration {
  val config = buildConfig(ConfigFactory.load())

  def body: String = config.body
  def idPath: String = config.idPath

  def buildConfig(config: Config): MessageConfig = {
    val message = config.getConfig("senderApp.message")

    MessageConfig(
      message.getString("text"),
      message.getString("path")
    )
  }

  case class MessageConfig(body: String, idPath: String)

}
