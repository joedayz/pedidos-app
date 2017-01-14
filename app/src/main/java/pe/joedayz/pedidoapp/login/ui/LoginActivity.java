package pe.joedayz.pedidoapp.login.ui;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import pe.joedayz.pedidoapp.ProformaApp;
import pe.joedayz.pedidoapp.R;
import pe.joedayz.pedidoapp.login.LoginPresenter;


import pe.joedayz.pedidoapp.productlist.ui.ArticuloListActivity;


/**
 * Created by josediaz on 2/12/2016.
 */

public class LoginActivity extends AppCompatActivity
        implements LoginView {

    @Bind(R.id.btnSignin)
    Button btnSignIn;
    @Bind(R.id.editTxtUserName)
    EditText inputUserName;
    @Bind(R.id.editTxtPassword)
    EditText inputPassword;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.checkBoxRememberMe)
    CheckBox checkBoxRememberMe;

    @Inject
    LoginPresenter presenter;

    @Inject
    SharedPreferences sharedPreferences;

    private ProformaApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        app = (ProformaApp) getApplication();

        setupInjection();
        presenter.onCreate();
        presenter.checkRememberMe();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void setupInjection() {
        app.getLoginComponent(this).inject(this);
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    @OnClick(R.id.btnSignin)
    public void handleSignIn() {
        presenter.login(inputUserName.getText().toString(),
                inputPassword.getText().toString());
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, ArticuloListActivity.class));
    }

    @Override
    public void setUserName(String userName) {
        if (userName != null) {
            if(checkBoxRememberMe.isChecked()){
                String key = app.getUserNameKey();
                sharedPreferences.edit().putString(key, userName).commit();
            }
        }
    }

    @Override
    public void loginError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        inputPassword.setError(msgError);
    }

    private void setInputs(boolean enabled){
        btnSignIn.setEnabled(true);
        inputUserName.setEnabled(true);
        inputPassword.setEnabled(true);
    }


}
