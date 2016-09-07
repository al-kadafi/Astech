package id.ac.ub.filkom.sekcv.astech.controller.main_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.ub.filkom.sekcv.appstroke.R;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    Database db;
    Cursor cursor;

    @BindView(R.id.input_email)
    EditText _emailText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_login)
    Button _loginButton;
    @BindView(R.id.link_signup)
    TextView _signupLink;
    @BindView(R.id.spinner)
    Spinner _spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        db = new Database(this);

        List<String> item = new ArrayList<String>();
        item.add("Indonesia");
        item.add("English");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LoginActivity.this, android.R.layout.simple_spinner_dropdown_item,
                item);

//untuk menentukan model adapter nya
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        _spinner.setBackgroundTintList(ColorStateList.valueOf(R.color.black));
        //menerapkan adapter pada spinner sp
        _spinner.setAdapter(adapter);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");
        SharedPreferences              pref   = getApplicationContext().getSharedPreferences("CekLogin", MODE_WORLD_READABLE); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();
        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
//        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        final String email = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.
        SQLiteDatabase dbUser = db.getReadableDatabase();

        cursor = dbUser.rawQuery("SELECT * FROM user where email = '"+email+"'", null);
//        boolean jumColom=false;


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            String emailDb    = cursor.getString(4);
                            String passwordDb = cursor.getString(3);
                            Log.d("email", email + "" +emailDb);
                            Log.d("pass", password + "" +passwordDb);

                            if (email.equalsIgnoreCase(emailDb) && password.equalsIgnoreCase(passwordDb)) {
                                Toast.makeText(getBaseContext(), "Login success", Toast.LENGTH_LONG).show();
                                onLoginSuccess();
                                editor.putBoolean("login", false);
                                editor.putString("date", cursor.getString(1));
                                editor.putString("name", cursor.getString(2));
                                editor.putString("password", cursor.getString(3));
                                editor.putString("email", cursor.getString(4));
                                editor.apply();
                                progressDialog.dismiss();
                            } else {
                                String pesan = "Data not valid, please check your data again";
                                Toast.makeText(getBaseContext(), pesan, Toast.LENGTH_LONG).show();
                                onLoginFailed();
                                progressDialog.dismiss();
                            }
                        } else {
                            Toast.makeText(getBaseContext(), "User not register", Toast.LENGTH_LONG).show();
                            onLoginFailed();
                            progressDialog.dismiss();
                        }
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onLoginFailed() {


        _loginButton.setEnabled(true);
        //finish();
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}
