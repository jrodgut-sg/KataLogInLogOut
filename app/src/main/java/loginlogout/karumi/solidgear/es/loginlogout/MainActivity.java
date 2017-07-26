package loginlogout.karumi.solidgear.es.loginlogout;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private AppCompatEditText emailEditText = null;
    private AppCompatEditText passwordEditText = null;
    private AppCompatButton loginButton = null;
    private AppCompatButton logoutButton = null;
    private AppCompatTextView errorTextView = null;

    private ApiClient apiClient = new ApiClient(new Clock());

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            enableLoginButtonIfPossible();
        }
    };

    private View.OnClickListener onclickLoginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (apiClient.login(getEmail(), getPassword())) {
                showLogout();
            } else {
                showError();
            }
        }
    };

    private View.OnClickListener onclickLogoutListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (apiClient.logout()) {
                showLogin();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = (AppCompatEditText) findViewById(R.id.EmailEditText);
        passwordEditText = (AppCompatEditText) findViewById(R.id.PasswordEditText);
        loginButton = (AppCompatButton) findViewById(R.id.LoginButton);
        logoutButton = (AppCompatButton) findViewById(R.id.LogoutButton);
        errorTextView = (AppCompatTextView) findViewById(R.id.ErrorTextView);


        emailEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);

        loginButton.setOnClickListener(onclickLoginListener);

        logoutButton.setOnClickListener(onclickLogoutListener);

    }

    private String getEmail() {
        return emailEditText.getText().toString();
    }

    private String getPassword() {
        return passwordEditText.getText().toString();
    }

    private void enableLoginButtonIfPossible() {
        String email = getEmail();
        String password = getPassword();

        if (email.length() > 0 && password.length() > 0) {
            loginButton.setEnabled(true);
        }

    }

    private void showLogin() {
        emailEditText.setText("");
        emailEditText.setVisibility(View.VISIBLE);
        passwordEditText.setText("");
        passwordEditText.setVisibility(View.VISIBLE);

        loginButton.setVisibility(View.VISIBLE);
        logoutButton.setVisibility(View.GONE);

        errorTextView.setVisibility(View.VISIBLE);
    }

    private void showLogout() {
        emailEditText.setVisibility(View.GONE);
        passwordEditText.setVisibility(View.GONE);
        loginButton.setVisibility(View.GONE);
        logoutButton.setVisibility(View.VISIBLE);
        errorTextView.setVisibility(View.GONE);
    }

    private void showError() {
        errorTextView.setVisibility(View.VISIBLE);
    }

}
