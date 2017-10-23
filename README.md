# wait-for-200
Waits for an http 200.

Usage :
docker run runo/wait-for-200 "http://someurl" --timeout=30

This command will issue http requests to the url "http://someurl" until an http 200 is received or 30s elapsed since the beginning of the command.
The interval between each attempt is 100ms.

The docker image is available on docker hub :
https://hub.docker.com/r/runo/wait-for-200/
