name := "CNUSenderApp"

version := "0.1"

scalaVersion := "2.12.11"

val akkaVersion = "2.6.5"
val akkaHttpVersion = "10.2.0"
val configVersion = "1.0.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.github.andyglow" %% "typesafe-config-scala" % configVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion
)