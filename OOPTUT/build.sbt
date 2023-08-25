name := "OOPTUT"

version := "1.0"

scalaVersion := "2.11.8"

// https://mvnrepository.com/artifact/com.typesafe.play/play-json
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.10"

// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.8.9"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-annotations" % "2.8.9"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.9"
// https://mvnrepository.com/artifact/com.typesafe.play/play-functional
libraryDependencies += "com.typesafe.play" %% "play-functional" % "2.6.10"
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.2.0"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.5"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.11"
// https://mvnrepository.com/artifact/com.typesafe.play/play-ahc-ws-standalone


libraryDependencies += "com.typesafe.play" %% "play-ws" % "2.4.0-M1"
libraryDependencies += "com.typesafe.play" %% "play-ws-standalone" % "1.1.1"
libraryDependencies += "com.typesafe.play" %% "play-ahc-ws-standalone" % "1.1.1"
libraryDependencies += "com.typesafe.play" %% "play-ws-standalone-json" % "1.1.1"
libraryDependencies += "com.typesafe.play" %% "play-ws-standalone-xml" % "1.1.1"
libraryDependencies += "com.typesafe.play" %% "play-ahc-ws" % "2.6.1"


libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.1"
libraryDependencies += "com.jsuereth" %% "scala-arm" % "1.4"