1.docker build -t eureka:v1 .

2.docker run -di -p 10080:8000 eureka:v1

3.docker ps

4.docker logs $containerId in step 3

5.open browser and link to url localhost:10080