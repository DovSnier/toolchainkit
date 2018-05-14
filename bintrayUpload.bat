@echo off
@echo "bintray execute..."
gradlew --stacktrace --info clean install bintrayUpload > bintray.log
@exit
