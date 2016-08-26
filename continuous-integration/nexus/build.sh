docker build -t zsuffazs/ci-nexus --rm=true .
docker run -d -p 8081:8081 --name ci-nexus zsuffazs/ci-nexus