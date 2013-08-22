scalaVersion := "2.10.2"

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.typesafe" %% "play-mini" % "2.1-RC2" 
  // this must be uncommented in order to successfully update with SBT 0.13.0-RC5
  // exclude("com.github.scala-incubator.io", "scala-io-file_2.10.0-RC1")
, "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.2"
)
