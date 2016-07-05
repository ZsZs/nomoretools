rm -fr build
mkdir build
cp ../target/nomoretools-core-1.0.0-SNAPSHOT.jar build
docker build -t zsuffazs/nomoretools-core .
docker run -d -p 8081:8081 --name nomoretools-core zsuffazs/nomoretools-core