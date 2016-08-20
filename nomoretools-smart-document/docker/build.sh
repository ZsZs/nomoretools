rm -fr build
mkdir build
cp ../target/nomoretools-smart-document-1.0.0-SNAPSHOT.jar build
docker build -t zsuffazs/nomoretools-smart-document .
docker run -d -p 8083:8083 --name nomoretools-smart-document zsuffazs/nomoretools-smart-document