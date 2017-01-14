package pe.joedayz.pedidoapp.login;

/**
 * Created by josediaz on 2/12/2016.
 */

public interface LoginRepository {
    void signIn(String username, String password);

    void checkRememberMe();
}
