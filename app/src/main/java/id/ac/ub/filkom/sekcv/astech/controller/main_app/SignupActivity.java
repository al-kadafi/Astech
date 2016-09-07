package id.ac.ub.filkom.sekcv.astech.controller.main_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.joda.time.LocalDate;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.ub.filkom.sekcv.appstroke.R;

public class SignupActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private static final String   TAG     = "SignupActivity";
    public               boolean  cek     = true;
    public               Calendar tanggal = Calendar.getInstance();
    Database db;
    @BindView(R.id.input_name)
    EditText _nameText;
    @BindView(R.id.input_email)
    EditText _emailText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_signup)
    Button _signupButton;
    @BindView(R.id.link_login)
    TextView _loginLink;
    @BindView(R.id.input_tanggal)
    TextView _tanggalahir;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
//        _nameText.setText("kadafi");
//        _emailText.setText("al.kadafi20@gmail.com");
//        _passwordText.setText("aaaaaa");
        db = new Database(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });

        TextInputLayout tgl = (TextInputLayout) findViewById(R.id.pilihtanggal);


        _tanggalahir.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (cek) {
                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            SignupActivity.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    dpd.setAccentColor(getResources().getColor(R.color.primary));
                    dpd.setMaxDate(now);
                    dpd.show(getFragmentManager(), "Datepickerdialog");
                    cek = false;
                } else {
                    cek = true;
                }
            }
        });

        _tanggalahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        SignupActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setAccentColor(getResources().getColor(R.color.primary));
                dpd.setMaxDate(now);
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        Log.d("haha", "masuk");
        // TODO: Implement your own signup logic here.
        SQLiteDatabase dbUser = db.getWritableDatabase();
        dbUser.execSQL("insert into user(id_user, nama, tanggal, password, email, status) values(NULL,'" +
                name + "','" +
                //tanggal.get()+"','"+
                (new LocalDate(tanggal.getTime())).toString("yyyy-MM-dd") + "','" +
                password + "','" +
                email + "'," +
                "'false')");

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();

                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        Toast.makeText(getApplicationContext(), "Sign up success", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void onSignupFailed() {

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String tanggal = _tanggalahir.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if(tanggal.isEmpty()){
            _tanggalahir.setError("required");
            valid = false;
        } else {
            _tanggalahir.setError(null);
        }

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

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String date = dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        tanggal.set(year, monthOfYear, dayOfMonth);
        _tanggalahir.setText(date);
        //System.out.println(tanggal.getTimeInMillis());
    }
}