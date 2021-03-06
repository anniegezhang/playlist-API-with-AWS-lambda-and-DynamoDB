package com.amazon.ata.music.playlist.service.lambda;

import com.amazon.ata.music.playlist.service.activity.AddSongToPlaylistActivity;
import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.models.requests.AddSongToPlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.AddSongToPlaylistResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Singleton;

public class AddSongToPlaylistActivityProvider implements RequestHandler<AddSongToPlaylistRequest, AddSongToPlaylistResult> {
    //private static App app;

    public AddSongToPlaylistActivityProvider() {

    }

//    @Override
//    public AddSongToPlaylistResult handleRequest(final AddSongToPlaylistRequest addSongToPlaylistRequest, Context context) {
//        return getApp().provideAddSongToPlaylistActivity().handleRequest(addSongToPlaylistRequest, context);
//    }

//    private App getApp() {
//        if (app == null) {
//            app = new App();
//        }
//
//        return app;
//    }

    @Override
    public AddSongToPlaylistResult handleRequest(final AddSongToPlaylistRequest addSongToPlaylistRequest, Context context) {
        return addSongToPlaylistActivity.handleRequest(addSongToPlaylistRequest, context);
    }

    @Singleton
    ServiceComponent component = DaggerServiceComponent.create();

    AddSongToPlaylistActivity addSongToPlaylistActivity = component.provideAddSongToPlaylistActivity();
}
