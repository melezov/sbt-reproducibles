zero-libs
=========

The SBT 0.11.x version, if one overrode the libraryDependencies by setting them to Nil,
everything compiled successfully, and the resulting POM would not contain the scala library dependency
(which one could elaborate as setting the scala library as a "provided" dependency, to be added in runtime).

In the 0.12.x line, compiling a scala source file with libraryDependencies set to Nil produces an error:
    
    scala.tools.nsc.MissingRequirementError: object scala not found.
      at scala.tools.nsc.symtab.Definitions$definitions$.getModuleOrClass(Definitions.scala:655)

It goes without saying that the error message is quice confusing, especially if it occurred when porting
a 0.11.x project into 0.12.0, when it isn't immediately obvious what actually happened.

conclusion
==========

It was a misfeature to allow Scala code to be compiled without the scala-library on the classpath.

The right way is to declare it as provided:

    // don't automatically add the scala-library dependency in 'compile'
    autoScalaLibrary := false

    libraryDependencies +=
      "org.scala-lang" % "scala-library" % "2.9.2" % "provided"

For detailed information see the change summary for 0.12.0 here:
https://github.com/harrah/xsbt/wiki/ChangeSummary_0.12.0