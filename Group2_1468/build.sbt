name := "Group_2_Assignment"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies ++= Seq("org.mockito" %% "mockito-scala-scalatest" % "1.15.0" % Test,
  "org.mockito" %% "mockito-scala" % "1.14.8",
  "org.scalatest" %% "scalatest" % "3.2.2" % Test  ,
  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "org.scalatest" %% "scalatest" % "3.1.1" % "test",
  "org.mockito" %% "mockito-scala" % "1.5.12" % "test")
