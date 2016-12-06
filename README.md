#spring-cloud-simple

##Start 2 instances for user-service
* java -jar user-service-1.0.0.jar --server.port=9220 >log9220.log
* java -jar user-service-1.0.0.jar --server.port=9221 >log9221.log

##Start 2 instances for eureka-server
* java -jar eureka-server-1.0.0.jar --server.port=9200 >log9200.log
* java -jar eureka-server-1.0.0.jar --server.port=9201 >log9201.log