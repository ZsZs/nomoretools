rm -fr build
mkdir build
cp ../target/nomoretools-acceptance-tests-1.0.0-SNAPSHOT.jar build
docker build -t zsuffazs/nomoretools-acceptance-tests .
docker run -d -p 9123:9123 --name nomoretools-acceptance-tests zsuffazs/nomoretools-acceptance-tests