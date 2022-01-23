package com.amazon.ata.music.playlist.service.dependency;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazon.ata.music.playlist.service.activity.CreatePlaylistActivity;
import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DaoModule {

    @Singleton
    @Provides
    public PlaylistDao providePlaylistDao(DynamoDBMapper dynamoDbMapper) {
        return new PlaylistDao(dynamoDbMapper);
    }

    @Singleton
    @Provides
    public AlbumTrackDao provideAlbumTrackDao(DynamoDBMapper dynamoDbMapper) {
        return new AlbumTrackDao(dynamoDbMapper);
    }


}