docker build -t zsuffazs/ci-jenkins --rm=true .
docker run -d -p 8080:8080 --name ci-jenkins zsuffazs/ci-jenkins