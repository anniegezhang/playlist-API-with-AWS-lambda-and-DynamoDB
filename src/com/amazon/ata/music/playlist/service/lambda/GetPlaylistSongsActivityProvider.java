package com.amazon.ata.music.playlist.service.lambda;

import com.amazon.ata.music.playlist.service.activity.GetPlaylistSongsActivity;
import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.models.requests.GetPlaylistSongsRequest;
import com.amazon.ata.music.playlist.service.models.results.GetPlaylistSongsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Singleton;

public class GetPlaylistSongsActivityProvider implements RequestHandler<GetPlaylistSongsRequest, GetPlaylistSongsResult> {

    //private static App app;

    public GetPlaylistSongsActivityProvider() {

    }

//    @Override
//    public GetPlaylistSongsResult handleRequest(final GetPlaylistSongsRequest getPlaylistSongsRequest, Context context) {
//        return getApp().provideGetPlaylistSongsActivity().handleRequest(getPlaylistSongsRequest, context);
//    }

//    private App getApp() {
//        if (app == null) {
//            app = new App();
//        }
//
//        return app;
//    }

    @Override
    public GetPlaylistSongsResult handleRequest(final GetPlaylistSongsRequest getPlaylistSongsRequest, Context context) {
        return getPlaylistSongsActivity.handleRequest(getPlaylistSongsRequest, context);
    }

    @Singleton
    ServiceComponent component = DaggerServiceComponent.create();

    GetPlaylistSongsActivity getPlaylistSongsActivity = component.provideGetPlaylistSongsActivity();
}
