package com.amazon.ata.music.playlist.service.dynamodb;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;

import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.exceptions.AlbumTrackNotFoundException;
import com.amazon.ata.music.playlist.service.exceptions.PlaylistNotFoundException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/**
 * Accesses data for an album using {@link AlbumTrack} to represent the model in DynamoDB.
 */
public class AlbumTrackDao {
    private final DynamoDBMapper dynamoDbMapper;

    /**
     * Instantiates an AlbumTrackDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the album_track table
     */
    public AlbumTrackDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    //m3
    public AlbumTrack getAlbumTrack(String asin, Integer track_number) {
        AlbumTrack albumTrack = this.dynamoDbMapper.load(AlbumTrack.class, asin, track_number);

        if (albumTrack == null ) {
            throw new AlbumTrackNotFoundException("The album doesnot exist for the ASIN provided " +
                    "or the track number does not exist for the ASIN provided");
        }

        albumTrack.setTrack_number(track_number);

        return albumTrack;
    }

    //m1m2
    public AlbumTrack saveAlbumTrack(AlbumTrack albumTrack) {
        this.dynamoDbMapper.save(albumTrack);
        return albumTrack;
    }
}
