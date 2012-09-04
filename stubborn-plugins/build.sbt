name := "stubborn-plugins"

resolvers := Seq(
  "Element Nexus" at "http://maven.element.hr/nexus/content/groups/public/"
)

externalResolvers <<= resolvers map { rS =>
  Resolver.withDefaultResolvers(rS, mavenCentral = false)
}
