cd "%~dp0repro"

java "-Dsbt.boot.properties=boot-2.12.12.properties" "-Duser.home=../user-home" -jar "../sbt-launch.jar" test:compile
java "-Dsbt.boot.properties=boot-2.12.13.properties" "-Duser.home=../user-home" -jar "../sbt-launch.jar" test:compile