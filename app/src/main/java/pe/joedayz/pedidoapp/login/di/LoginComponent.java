package pe.joedayz.pedidoapp.login.di;

import javax.inject.Singleton;

import dagger.Component;


import pe.joedayz.pedidoapp.ProformaAppModule;
import pe.joedayz.pedidoapp.lib.di.LibsModule;
import pe.joedayz.pedidoapp.login.ui.LoginActivity;

/**
 * Created by josediaz on 2/12/2016.
 */

@Singleton
@Component(modules = {LoginModule.class,  LibsModule.class, ProformaAppModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
