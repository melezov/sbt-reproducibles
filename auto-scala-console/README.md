auto-scala-console
==================

In the 0.12.x line, running the console with the autoScalaLibrary set to false produces an error:
    
    [error] (Thread-1) java.lang.Error: typeConstructor inapplicable for <none>
      java.lang.Error: typeConstructor inapplicable for <none>
        at scala.tools.nsc.symtab.SymbolTable.abort(SymbolTable.scala:34)
        
Googling the error message brings back tales from the crypt, but nothing constructive.

I still find it impossible to run the project console on these projects.
One workaround for this error (without actually setting the autoScalaLibrary to true) is to create
a proxy project with dependsOn the first project and sets the autoScalaLibrary to true.

    lazy val fooProxy = Project(
      "Foo-Console"
    , file(".")
    , settings = defaults ++ Seq(
        autoScalaLibrary := true
      )
    ) dependsOn(foo)
    
    
In the previous version of SBT (0.11.x) this error does not occurr - the console runs just fine.
