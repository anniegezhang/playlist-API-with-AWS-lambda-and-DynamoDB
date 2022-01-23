package com.amazon.ata.music.playlist.service.dependency;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Provides;

import javax.inject.Singleton;

import dagger.Module;

// MapperModule.java
@Module
public class MapperModule {
    @Singleton
    @Provides
    public DynamoDBMapper provideDynamoDBMapper() {
        DynamoDBMapper dynamoDBMapper = null;
        if (null == dynamoDBMapper) {
            dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_EAST_2));
        }
        return dynamoDBMapper;
    }

    private Regions getRegion() {
        // some logic that might return appropriate region for THIS deployment
        // of the service
        return Regions.US_EAST_2;
    }
}