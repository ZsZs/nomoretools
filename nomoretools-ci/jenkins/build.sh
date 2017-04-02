docker build -t zsuffazs/nomoretools-ci-jenkins:dev .
docker run -it -p 8080:8080 --name ci-jenkins zsuffazs/nomoretools-ci-jenkins:dev