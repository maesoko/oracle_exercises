#!/bin/sh

# 各自の環境に合わせて記述
LD_LIBRARY_PATH=/home/yamauchi/instantclient_12_1
PATH=/home/yamauchi/instantclient_12_1:$PATH

# 以降は共通
NLS_LANG=JAPANESE_JAPAN.AL32UTF8
export LD_LIBRARY_PATH PATH NLS_LANG
export no_proxy=localhost,172.16.40.4
echo -n "ユーザ名："
read user
stty -echo
echo -n "パスワード："
read pass
stty echo
rlwrap sqlplus $user/$pass@172.16.40.4:1521/db11
#rlwrap sqlplus $user/$pass@172.16.40.4:1521/db11 as sysdba
