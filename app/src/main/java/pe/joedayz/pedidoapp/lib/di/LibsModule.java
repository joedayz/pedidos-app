package pe.joedayz.pedidoapp.lib.di;

import android.app.Activity;
import android.support.v4.app.Fragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pe.joedayz.pedidoapp.lib.base.EventBus;
import pe.joedayz.pedidoapp.lib.GlideImageLoader;
import pe.joedayz.pedidoapp.lib.GreenRobotEventBus;
import pe.joedayz.pedidoapp.lib.base.ImageLoader;

/**
 * Created by josediaz on 2/12/2016.
 */

@Module
public class LibsModule {
    private Fragment fragment;

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }


    Activity activity;

    public LibsModule() {
    }
    public LibsModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    EventBus providesEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader(Fragment fragment) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (fragment != null) {
            imageLoader.setLoaderContext(fragment);
        }
        return imageLoader;
    }


    @Provides
    @Singleton
    Fragment providesFragment(){
        return this.fragment;
    }

    @Provides
    @Singleton
    Activity provideActivity(){
        return this.activity;
    }
}