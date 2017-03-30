docker build -t zsuffazs/nomoretools-ci-proxy .
docker run -d -p 80:80 --name ci-proxy zsuffazs/nomoretools-ci-proxy