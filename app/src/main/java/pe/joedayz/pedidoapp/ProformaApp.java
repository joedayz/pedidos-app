package pe.joedayz.pedidoapp;

import android.app.Application;


import pe.joedayz.pedidoapp.login.di.DaggerLoginComponent;
import pe.joedayz.pedidoapp.productlist.di.ArticuloListComponent;
import pe.joedayz.pedidoapp.productlist.di.ArticuloListModule;

import pe.joedayz.pedidoapp.productlist.di.DaggerArticuloListComponent;
import pe.joedayz.pedidoapp.productlist.ui.ArticuloListView;
import pe.joedayz.pedidoapp.lib.di.LibsModule;

import pe.joedayz.pedidoapp.login.di.LoginComponent;
import pe.joedayz.pedidoapp.login.di.LoginModule;
import pe.joedayz.pedidoapp.login.ui.LoginView;


/**
 * Created by josediaz on 2/12/2016.
 */

public class ProformaApp extends Application {

    private final static String USERNAME_KEY = "pe.joedayz.pedidoapp.userName";

    private LibsModule libsModule;

    private ProformaAppModule proformaAppModule;

    @Override
    public void onCreate() {
        super.onCreate();

        initModules();
    }

    private void initModules() {
        libsModule = new LibsModule();
        proformaAppModule = new ProformaAppModule(this);
    }

    public static String getUserNameKey() {
        return USERNAME_KEY;
    }

    public LoginComponent getLoginComponent(LoginView view) {
        return DaggerLoginComponent
                .builder()
                .proformaAppModule(proformaAppModule)
                .libsModule(libsModule)
                .loginModule(new LoginModule(view))
                .build();

    }


    public ArticuloListComponent getArticuloListComponent(ArticuloListView view) {
        return DaggerArticuloListComponent
                .builder()
                .proformaAppModule(proformaAppModule)
                .libsModule(libsModule)
                .articuloListModule(new ArticuloListModule(view))
                .build();

    }


}
