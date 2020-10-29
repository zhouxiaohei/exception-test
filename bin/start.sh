#!/bin/sh
if [ ! -d "logs" ]; then
  mkdir logs
fi
rm -f pid
nohup java -jar  XX.jar> /dev/null 2>logs/test.log &

echo $! > pid
echo "server is runing"