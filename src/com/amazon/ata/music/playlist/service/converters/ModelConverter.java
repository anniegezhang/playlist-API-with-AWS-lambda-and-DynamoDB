package com.amazon.ata.music.playlist.service.converters;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.models.SongModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModelConverter {
    /**
     * Converts a provided {@link Playlist} into a {@link PlaylistModel} representation.
     * @param playlist the playlist to convert
     * @return the converted playlist
     */
    public PlaylistModel toPlaylistModel(Playlist playlist) {
        Set tagSet = playlist.getTags();
        List<String> tagList = null;
        if (tagSet != null) {
            tagList = new ArrayList<>(tagSet);
        }

        return PlaylistModel.builder()
                .withId(playlist.getId())
                .withCustomerId(playlist.getCustomerId())
                .withName(playlist.getName())
                .withTags(tagList)
                .withSongCount(playlist.getSongCount())
                .build();

        /*if (playlist.getTags() == null) {
            return PlaylistModel.builder()
                    .withId(playlist.getId())
                    .withName(playlist.getName())
                    .withCustomerId(playlist.getCustomerId())
                    .withSongCount(playlist.getSongCount())
                    .withTags(null)
                    .build();
        } else {
            int n = playlist.getTags().size();
            List<String> listVersion = new ArrayList<>(n);
            for (String playlistTag : playlist.getTags()) {
                listVersion.add(playlistTag);
            }
            return PlaylistModel.builder()
                    .withId(playlist.getId())
                    .withCustomerId(playlist.getCustomerId())
                    .withName(playlist.getName())
                    .withTags(listVersion)
                    .withSongCount(playlist.getSongCount())
                    .build();
        }*/
    }

    public SongModel toSongModel(AlbumTrack albumTrack) {

        return SongModel.builder()
                .withAsin(albumTrack.getAsin())
                .withTrackNumber(albumTrack.getTrack_number())
                .withAlbum(albumTrack.getAlbum_name())
                .withTitle(albumTrack.getSong_title())
                .build();
    }

    public List<SongModel> toSongModelList(List<AlbumTrack> songList) {

        List<SongModel> songModelList = new ArrayList<>();
        ModelConverter modelConverter = new ModelConverter();
        for (AlbumTrack albumTrack : songList) {
            SongModel songModel = modelConverter.toSongModel(albumTrack);
            songModelList.add(songModel);
        }

        return songModelList;
    }
}
