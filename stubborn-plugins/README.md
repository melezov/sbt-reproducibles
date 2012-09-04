stubborn-plugins
================

Although I've setup the repository only to use our company Nexus proxy,
and turned off other resolvers via the externalResolvers key in 
*project/plugins.sbt*, it doesn't seem to have effect.

  resolvers := Seq(
    "Element Nexus" at "http://maven.element.hr/nexus/content/groups/public/"
  , Resolver.url("Element Nexus (Ivy)",
      url("http://maven.element.hr/nexus/content/groups/public/"))(Resolver.ivyStylePatterns)
  )

  externalResolvers <<= resolvers map { rS =>
    Resolver.withDefaultResolvers(rS, mavenCentral = false)
  } 

I already overrode the sbt.boot.properties, plugins and project resolvers.
It seems to work for the downloading the SBT and project dependencies,
but for some reason *the stubborn plugins keep downloading from the 
typesafe repository*.

And http://typesafe.artifactoryonline.com/ seems to be down again...

For the reduced example I'm only using the sbteclipse plugin, but usually we are using
at least 5 different plugins per project cluster. What must one do in order to download
plugins directly from the company Nexus proxy?
