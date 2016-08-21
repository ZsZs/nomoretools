rm -fr build
mkdir build
cp ../target/nomoretools-frontend-server-1.0.0-SNAPSHOT.jar build
docker build -t zsuffazs/nomoretools-frontend-server --rm=true .
docker run -d -p 8080:8080 --name nomoretools-frontend-server zsuffazs/nomoretools-frontend-server