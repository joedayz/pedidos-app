package pe.joedayz.pedidoapp.login.di;



import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pe.joedayz.pedidoapp.lib.base.EventBus;
import pe.joedayz.pedidoapp.login.LoginInteractor;
import pe.joedayz.pedidoapp.login.LoginPresenter;
import pe.joedayz.pedidoapp.login.LoginPresenterImpl;
import pe.joedayz.pedidoapp.login.LoginRepository;
import pe.joedayz.pedidoapp.login.LoginRepositoryImpl;
import pe.joedayz.pedidoapp.login.ui.LoginView;
import pe.joedayz.pedidoapp.login.LoginInteractorImpl;

/**
 * Created by josediaz on 2/12/2016.
 */
@Module
public class LoginModule {

    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    LoginView providesLoginView() {
        return this.view;
    }

    @Provides @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor) {
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor);
    }

    @Provides @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository) {
        return new LoginInteractorImpl(repository);
    }


    @Provides @Singleton
    LoginRepository providesLoginRepository(EventBus eventBus, SharedPreferences sharedPreferences) {
        return new LoginRepositoryImpl( eventBus, sharedPreferences);
    }
}
