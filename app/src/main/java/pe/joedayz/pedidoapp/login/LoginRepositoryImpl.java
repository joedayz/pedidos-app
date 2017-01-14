package pe.joedayz.pedidoapp.login;


import android.content.SharedPreferences;

import pe.joedayz.pedidoapp.lib.base.EventBus;
import pe.joedayz.pedidoapp.login.events.LoginEvent;

/**
 * Created by josediaz on 2/12/2016.
 */

public class LoginRepositoryImpl implements LoginRepository {

    private final static String USERNAME_KEY = "pe.joedayz.pedidoapp.userName";

    private EventBus eventBus;


    SharedPreferences sharedPreferences;



    public LoginRepositoryImpl(EventBus eventBus, SharedPreferences sharedPreferences) {

        this.eventBus = eventBus;
        this.sharedPreferences = sharedPreferences;
    }


    @Override
    public void signIn( String userName, String password) {
        if (userName != null && password != null) {
            if(userName.equals("joedayz") && password.equals("123456")){
                //TODO Usar API de autenticacion
                post(LoginEvent.onSignInSuccess, null, userName);
            }else{
                post(LoginEvent.onSignInError, "usuario invalido");
            }

        } else {
            //TODO manejar error
            post(LoginEvent.onSignInError, "usuario invalido");
        }
    }

    @Override
    public void checkRememberMe() {

        String userName = sharedPreferences.getString(USERNAME_KEY, null);

        if(userName!=null){
            post(LoginEvent.onSignInSuccess, null, userName);
        }else{

            

            post(LoginEvent.onFailedToRecoverSession);
        }
    }

    private void post(int type) {
        post(type, null);
    }

    private void post(int type, String errorMessage) {
        post(type, errorMessage, null);
    }

    private void post(int type, String errorMessage, String loggedUserEmail) {
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        loginEvent.setErrorMesage(errorMessage);
        loginEvent.setLoggedUserEmail(loggedUserEmail);
        eventBus.post(loginEvent);
    }

}