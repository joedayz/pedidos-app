package pe.joedayz.pedidoapp.login;

/**
 * Created by josediaz on 2/12/2016.
 */

public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRepository;

    public LoginInteractorImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void execute(String username, String password) {
        loginRepository.signIn(username, password);
    }

    @Override
    public void checkRememberMe() {
        loginRepository.checkRememberMe();
    }
}
