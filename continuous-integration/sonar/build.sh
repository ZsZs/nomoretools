docker build -t zsuffazs/ci-sonar --rm=true .
docker run -d -p 8800:9000 --name ci-sonar zsuffazs/ci-sonar