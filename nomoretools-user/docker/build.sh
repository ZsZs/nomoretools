rm -fr build
mkdir build
cp ../target/nomoretools-user-1.0.0-SNAPSHOT.jar build
docker build -t zsuffazs/nomoretools-user .
docker run -d -p 8082:8082 --name nomoretools-user zsuffazs/nomoretools-user