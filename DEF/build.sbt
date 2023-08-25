name := "DEF"

version := "1.0"
//"mysql" % "mysql-connector-java" % "5.1.18",
scalaVersion := "2.12.2"
libraryDependencies ++= Seq("com.typesafe.slick" %% "slick" % "3.2.0",
  "org.slf4j" % "slf4j-api" % "1.6.4",
  "org.slf4j" % "slf4j-simple" % "1.6.4",
  "mysql" % "mysql-connector-java" % "5.1.21","com.jsuereth" %% "scala-arm" % "1.3")

//libraryDependencies ++= Seq("com.typesafe.slick" %% "slick" % "3.2.0",
//  "org.slf4j" % "slf4j-api" % "1.6.4","org.slf4j" % "slf4j-nop" % "1.6.4",
//  "org.slf4j" % "slf4j-simple" % "1.6.4",
//  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
//  "ch.qos.logback" % "logback-classic" % "1.2.3",
//  "mysql" % "mysql-connector-java" % "5.1.21","com.jsuereth" %% "scala-arm" % "1.3")
