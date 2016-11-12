rm -fr build
mkdir build
cp -a ../../nomoretools-acceptance-tests/. build
docker build -t zsuffazs/ci-fitnesse .
docker run -d -p 9123:9123 --name ci-fitnesse zsuffazs/ci-fitnesse
