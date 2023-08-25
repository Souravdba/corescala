import sbt.Keys.libraryDependencies

name := "Sep17"

version := "1.0"

scalaVersion := "2.11.8"

///For joda
libraryDependencies += "org.joda" % "joda-time" % "2.4"
//For arm
libraryDependencies += "com.jsuereth" % "scala-arm" % "1.4"
///For logging
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
libraryDependencies += "ch.qos.logback" % "logback-core" % "1.2.3"
libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.12"
//For Config Parser
libraryDependencies += "com.typesafe" % "config" % "1.2.1"
//For Slick
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.2.0"
//libraryDependencies += "org.reactivesteams" % "reactive-streams" % "1.0.1"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.5"
//For XML
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
//For JSON

libraryDependencies += "com.typesafe.play" %% "play-json_2.12" % "2.6.0-M1"
libraryDependencies += "com.fasterxml.jackson.core" %% "jackson-core" % "2.9.0"
libraryDependencies += "com.fasterxml.jackson.core" %% "jackson-annotations" % "2.9.0"
libraryDependencies += "com.fasterxml.jackson.core" %% "jackson-databind" % "2.9.0"
libraryDependencies += "com.typesafe.play" %% "play-functional_2.12" % "2.6.0-M1"
//For rest client
libraryDependencies += "com.typesafe.play"%%"akka-stream_2.12"%"2.4.16"
libraryDependencies += "com.typesafe.play" %% "akka-actor_2.12" % "2.4.16"
libraryDependencies += "com.typesafe.play" %% "play-ws_2.12" % "2.6.0-M1"
libraryDependencies += "com.typesafe.play" %% "play-ahc-ws-standalone_2.12" % "1.1.1"
libraryDependencies += "com.typesafe.play" %% "play-ws-standalone_2.12" % "1.1.1"
libraryDependencies += "com.typesafe.play" %% "play-ws-standalone-json_2.12" % "1.1.1"
libraryDependencies += "com.typesafe.play" %% "play-ws-standalone-xml_2.12" % "1.1.1"
libraryDependencies += "com.typesafe" %% "ssl-config-core_2.12" % "0.2.2"
libraryDependencies += "com.typesafe.play" %% "play-ahc-ws_2.12" % "2.6.0-M4"
libraryDependencies += "org.asynchttpclient" %% "async-http-client" % "2.1.0-alpha19"
libraryDependencies += "com.typesafe.play" %% "shaded-asynchttpclient" % "1.1.1"
libraryDependencies += "com.typesafe.play" %% "cachecontrol_2.12" % "1.1.1"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators_2.12" % "1.0.6"
libraryDependencies += "javax.inject" %% "javax.inject" % "1"