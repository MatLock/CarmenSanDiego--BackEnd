import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "CarmenSanDiego-BackEnd"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "Prueba" % "prueba.p" % "0.0.1-SNAPSHOT"
)
  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
     resolvers += ("Local Maven" at "file:///home/matlock/.m2/repository"))

}
