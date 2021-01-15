sbt-1.4.6-feat-scala-2.12.13
============================

With the release of Scala 2.12.13, SBT 1.4.6 started throwing 

    java.lang.NoSuchMethodError: scala.tools.nsc.Global.reporter()Lscala/tools/nsc/reporters/Reporter;
    
... and related errors.

Issue on sbt/sbt: https://github.com/sbt/sbt/issues/6251

