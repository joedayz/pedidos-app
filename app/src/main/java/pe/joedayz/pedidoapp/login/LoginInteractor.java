package pe.joedayz.pedidoapp.login;

/**
 * Created by josediaz on 2/12/2016.
 */

public interface LoginInteractor {

    void execute(String username, String password);

    void checkRememberMe();
}
