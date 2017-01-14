package pe.joedayz.pedidoapp.login.ui;

/**
 * Created by josediaz on 2/12/2016.
 */

public interface LoginView  {

    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignIn();

    void navigateToMainScreen();
    void setUserName(String userName);

    void loginError(String error);

}
