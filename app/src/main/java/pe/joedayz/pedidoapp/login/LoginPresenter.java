package pe.joedayz.pedidoapp.login;

import pe.joedayz.pedidoapp.login.events.LoginEvent;

/**
 * Created by josediaz on 2/12/2016.
 */

public interface LoginPresenter {

    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);
    void login(String userName, String password);

    void checkRememberMe();
}
