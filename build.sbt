name := "lose yourself"

version := "0.1"

scalaVersion := "2.11.11"

//tip don't use your cats imports here, let freestyle get it's own cats version

libraryDependencies += "io.frees" %% "freestyle" % "0.3.1"

addCompilerPlugin("org.scalameta" % "paradise" % "3.0.0-M9" cross CrossVersion.full)
