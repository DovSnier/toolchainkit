@echo off
@echo "bintrayInstall..."
gradle --stacktrace --info install > bintrayInstall.log
@echo "bintrayUpload..."
gradle --stacktrace --info bintrayUpload > bintrayUpload.log
@exit
