#!/bin/sh

# 各自の環境に合わせて記述
CLASSPATH=/home/yamauchi/instantclient_12_1/ojdbc7.jar:.

export CLASSPATH
java $1
