if exist "%CATALINA_HOME%/jre1.6.0_20/win" (
	if not "%JAVA_HOME%" == "" (
		set JAVA_HOME=
	)

	set "JRE_HOME=%CATALINA_HOME%/jre1.6.0_20/win"
)

set "CATALINA_OPTS=%CATALINA_OPTS% -Dfile.encoding=UTF8 -Djava.net.preferIPv4Stack=true  -Dorg.apache.catalina.loader.WebappClassLoader.ENABLE_CLEAR_REFERENCES=false -Duser.timezone=GMT -server -d64 -XX:NewSize=3072m -XX:MaxNewSize=3072m -Xms6144m -Xmx6144m -XX:MaxPermSize=1024m -XX:+UseConcMarkSweepGC -XX:SurvivorRatio=10"