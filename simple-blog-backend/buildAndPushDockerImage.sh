#!/bin/bash
./gradlew build -x test
docker build -t ryanhealey/simple-blog-backend:latest .
docker push ryanhealey/simple-blog-backend:latest