#!/usr/bin/env bash

#generate memory options for JVM according to the memory size of current system
#-------------Using G1 GC
#1 G Xms=512m MaxMetaspaceSize=64m ReservedCodeCacheSize=32m InitialCodeCacheSize=32m
#2 G Xms=1g MaxMetaspaceSize=128m ReservedCodeCacheSize=64m InitialCodeCacheSize=64m
#4 G Xms=3g MaxMetaspaceSize=128m ReservedCodeCacheSize=64m InitialCodeCacheSize=64m
#8 G Xms=6g MaxMetaspaceSize=256m ReservedCodeCacheSize=128m InitialCodeCacheSize=128m
#16G Xms=12g MaxMetaspaceSize=512m ReservedCodeCacheSize=256m InitialCodeCacheSize=256m
#22-28G Xms=18g MaxMetaspaceSize=512m ReservedCodeCacheSize=256m InitialCodeCacheSize=256m
#32-44G Xms=24g MaxMetaspaceSize=1g ReservedCodeCacheSize=512m InitialCodeCacheSize=512m
#64-88G Xms=32g MaxMetaspaceSize=2g ReservedCodeCacheSize=1g InitialCodeCacheSize=1g

function init() {
    WORK_PATH=./cerberus-app/target/
    if [ -z "$LOG_PATH" ]; then
        LOG_PATH="/opt/com.greek.mythology.cerberus/logs"
    fi
    mkdir -p $LOG_PATH

   # 定时清理日志
   cleanpath="/opt/com.greek.mythology.cerberus/clean.sh"
   echo "#!/bin/bash" > $cleanpath
   echo "find $LOG_PATH -mtime +7 -exec /bin/gzip {} \;" >> $cleanpath
   echo "find $LOG_PATH -mtime +60 -exec rm -fr {} \;" >> $cleanpath
   chmod +x $cleanpath
   (crontab -l|grep -v $cleanpath ; echo "58 05 * * * /bin/bash $cleanpath > /dev/null 2>&1" ) | crontab
}

function run() {
    JAVA_CMD="java"

    EXEC="exec"
    CONTEXT=/
    JVM_HEAP=`getJVMMemSizeOpt`
    JVM_ARGS="-server -Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8 -Djava.io.tmpdir=/tmp -Djava.net.preferIPv6Addresses=false"
    JVM_GC_G1="-XX:+UseG1GC -XX:G1HeapRegionSize=4M -XX:InitiatingHeapOccupancyPercent=40 -XX:MaxGCPauseMillis=100 -XX:+TieredCompilation -XX:CICompilerCount=4 -XX:-UseBiasedLocking -XX:+PrintGCDetails -XX:+PrintHeapAtGC -XX:+PrintTenuringDistribution -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintStringTableStatistics -XX:+PrintAdaptiveSizePolicy -XX:+PrintGCApplicationStoppedTime -XX:+PrintFlagsFinal -XX:-UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=10M"
    EXEC_JAVA="$EXEC $JAVA_CMD $JVM_ARGS $JVM_HEAP $JVM_GC_G1 "
	EXEC_JAVA=$EXEC_JAVA" -Xloggc:$LOG_PATH/cerberus.gc.log -XX:ErrorFile=$LOG_PATH/cerberus.vmerr.log -XX:HeapDumpPath=$LOG_PATH/cerberus.heaperr.log"

    if [ "$UID" = "0" ]; then
        ulimit -n 1024000
        umask 000
    else
        echo $EXEC_JAVA
    fi
    cd $WORK_PATH
    echo $WORK_PATH
    pwd
    $EXEC_JAVA -jar cerberus.jar 2>&1
}


function getTotalMemSizeMb() {
    memsizeMb=8096
}

function outputJvmArgs() {
	jvmSize=$1
	MaxMetaspaceSize=$2
	ReservedCodeCacheSize=$3
	InitialCodeCacheSize=$4
	echo "-Xss512k -Xmx"$jvmSize" -Xms"$jvmSize" -XX:MetaspaceSize="$MaxMetaspaceSize"
-XX:MaxMetaspaceSize="$MaxMetaspaceSize" -XX:+AlwaysPreTouch -XX:ReservedCodeCacheSize="$ReservedCodeCacheSize"
-XX:InitialCodeCacheSize="$InitialCodeCacheSize" -XX:+HeapDumpOnOutOfMemoryError "
}


function getJVMMemSizeOpt() {
	memsizeMb=`getTotalMemSizeMb`

	# 机器的可用内存比实际标的数字要小，比如8G实际是7900M左右，一般误差小于1G
	let maxSize_lvl1=63*1024
	let maxSize_lvl2=31*1024
	let maxSize_lvl3=21*1024
	let maxSize_lvl4=15*1024
	let maxSize_lvl5=7*1024
	let maxSize_lvl6=3*1024
	let maxSize_lvl7=1*1024

	jvmSize="4g"
	MaxMetaspaceSize="256m"
	ReservedCodeCacheSize="128m"
	InitialCodeCacheSize="128m"

	outputJvmArgs $jvmSize $MaxMetaspaceSize $ReservedCodeCacheSize $InitialCodeCacheSize
	exit 0
}

# ------------------------------------
# actually work
# ------------------------------------
init
run
