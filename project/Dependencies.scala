import sbt._

object Dependencies {
  lazy val commonDependency = Seq(
    "org.scalatest" %% "scalatest" % "3.0.0" % Test,
    "tv.cntt" %% "slf4s-api" % "1.7.25", //"org.slf4s" %% "slf4s-api" % "1.7.12",
    "ch.qos.logback" % "logback-classic" % "1.1.2",
    "com.github.nscala-time" %% "nscala-time" % "2.20.0",
    "net.codingwell" %% "scala-guice" % "4.2.1",
    "com.google.inject" % "guice" % "4.2.0",
    "org.loopring" %% "lightcone-lib" % "0.1.1-SNAPSHOT",
    "com.github.dozermapper" % "dozer-core" % "6.4.1"

  )

  lazy val databaseDependency = Seq(
    "com.lightbend.akka" %% "akka-stream-alpakka-slick" % "0.20",
    "org.hsqldb" % "hsqldb" % "2.3.5",
    "mysql" % "mysql-connector-java" % "6.0.6"
  )
}
