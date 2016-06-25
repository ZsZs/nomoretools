rm -fr build
mkdir build
cp ../target/core-1.0.0-SNAPSHOT.jar build
docker build -t zsuffazs/nomoretools .
docker run -d -p 8080:8080 --name nomoretools zsuffazs/nomoretools