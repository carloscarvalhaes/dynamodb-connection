package com.aws.mvp.dynamolocalstack.config;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfig {

    @Value("${aws.dynamo.url}")
    private String dynamoDbIp;

    @Value("${aws.region}")
    private String awsRegion;

    @Bean
    public AmazonDynamoDB amazonDynamoDB (final AmazonDynamoDBClientBuilder builder) {
        return builder.build();
    }

    @Bean
    public EndpointConfiguration endpointConfig(){
        return new EndpointConfiguration(dynamoDbIp, awsRegion);
    }

    @Bean
    public AmazonDynamoDBClientBuilder clientBuilder (final EndpointConfiguration endpointConfiguration) {
        AmazonDynamoDBClientBuilder aws = AmazonDynamoDBClientBuilder.standard();
        aws.setEndpointConfiguration(endpointConfiguration);
        return aws;
    }


}
