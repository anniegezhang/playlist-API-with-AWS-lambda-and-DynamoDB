package com.amazon.ata.music.playlist.service.lambda;

import com.amazon.ata.music.playlist.service.activity.UpdatePlaylistActivity;
import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.models.requests.UpdatePlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.UpdatePlaylistResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Singleton;

public class UpdatePlaylistActivityProvider implements RequestHandler<UpdatePlaylistRequest, UpdatePlaylistResult> {

    //private static App app;

    public UpdatePlaylistActivityProvider() {

    }

//    @Override
//    public UpdatePlaylistResult handleRequest(final UpdatePlaylistRequest updatePlaylistRequest, Context context) {
//        return getApp().provideUpdatePlaylistActivity().handleRequest(updatePlaylistRequest, context);
//    }
//
//    private App getApp() {
//        if (app == null) {
//            app = new App();
//        }
//
//        return app;
//    }

    @Override
    public UpdatePlaylistResult handleRequest(final UpdatePlaylistRequest updatePlaylistRequest, Context context) {
        return updatePlaylistActivity.handleRequest(updatePlaylistRequest, context);
    }

    @Singleton
    ServiceComponent component = DaggerServiceComponent.create();

    UpdatePlaylistActivity updatePlaylistActivity = component.provideUpdatePlaylistActivity();
}
