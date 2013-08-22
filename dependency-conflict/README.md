dependency-conflict
===================

In the 0.12.x line, running update proceedes to sucessfully retrieve all dependencies.

As of 0.13.0-RC5, the following happens:

    [error] Modules were resolved with conflicting cross-version suffixes in {file:/D:/Code/xsbt-reproducibles/dependency-conflict/}dependency-conflict:
    [error]    com.jsuereth:scala-arm _2.10.0-RC1, _2.10
    [error]    com.github.scala-incubator.io:scala-io-core _2.10.0-RC1, _2.10
    [error]    com.github.scala-incubator.io:scala-io-file _2.10.0-RC1, _2.10
    java.lang.RuntimeException: Conflicting cross-version suffixes in: com.jsuereth:scala-arm, com.github.scala-incubator.io:scala-io-core, com.github.scala-incubator.io:scala-io-file

Thus, it is necessary to manually exclude the scala-io dependency from play-mini via:

    "com.typesafe" %% "play-mini" % "2.1-RC2" exclude("com.github.scala-incubator.io", "scala-io-file_2.10.0-RC1")

Two questions spring to mind:

1. Why in the world is play-mini even depending on a specific "2.10.0-RC1" version of scala-io instead of just "2.10"

2. Why do two different 2.10.x versions introduce a conflict - should these not be binary compatible? What gives?
