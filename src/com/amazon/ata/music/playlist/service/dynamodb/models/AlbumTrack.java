package com.amazon.ata.music.playlist.service.dynamodb.models;

import com.amazon.ata.music.playlist.service.converters.AlbumTrackLinkedListConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

import java.util.List;
import java.util.Set;

/**
 * Represents a record in the playlists table.
 */
@DynamoDBTable(tableName = "album_tracks")
public class AlbumTrack {
    // m1m2 added the middle 4 attributes
    private String asin;
    private Integer track_number;
    private String  album_name;
    private String song_title;

    @DynamoDBHashKey(attributeName = "asin")
    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }
    @DynamoDBRangeKey(attributeName = "track_number")
    public Integer getTrack_number() {
        return track_number;
    }

    public void setTrack_number(Integer track_number) {
        this.track_number = track_number;
    }

    @DynamoDBAttribute(attributeName = "album_name")
    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    @DynamoDBAttribute(attributeName = "song_title")
    public String getSong_title() {
        return song_title;
    }

    public void setSong_title(String song_title) {
        this.song_title = song_title;
    }

}
