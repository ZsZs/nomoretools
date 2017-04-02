docker build -t zsuffazs/nomoretools-ci-nexus:dev .
docker run -it -p 8080:8080 --name ci-nexus zsuffazs/nomoretools-ci-nexus:dev