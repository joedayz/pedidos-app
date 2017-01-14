package pe.joedayz.pedidoapp.login.events;

/**
 * Created by josediaz on 2/12/2016.
 */

public class LoginEvent {

    public final static int onSignInError = 0;
    public final static int onSignInSuccess = 2;
    public final static int onFailedToRecoverSession = 4;

    private int eventType;
    private String errorMesage;
    private String loggedUserEmail;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMesage() {
        return errorMesage;
    }

    public void setErrorMesage(String errorMesage) {
        this.errorMesage = errorMesage;
    }

    public String getLoggedUserEmail() {
        return loggedUserEmail;
    }

    public void setLoggedUserEmail(String loggedUserEmail) {
        this.loggedUserEmail = loggedUserEmail;
    }
}
