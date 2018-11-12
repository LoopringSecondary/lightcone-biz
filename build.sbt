import sbt._
import Keys._
import Settings._
import Dependencies._

lazy val biz = (project in file("."))
  .enablePlugins(AutomateHeaderPlugin)
  .settings(
    basicSettings,
    libraryDependencies ++= commonDependency,
    libraryDependencies ++= databaseDependency)
