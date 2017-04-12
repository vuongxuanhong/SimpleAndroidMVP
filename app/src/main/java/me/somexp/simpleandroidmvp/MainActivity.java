package me.somexp.simpleandroidmvp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.somexp.simpleandroidmvp.welcome.ActivityWelcome;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.submit)
    Button submit;

    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.password)
    EditText password;

    /**
     * each activity need a presenter to process events (system events & user events)
     */
    MainPresenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MainPresenterImpl(this);

        progressDialog = new ProgressDialog(this);
    }

    @OnClick (R.id.submit)
    void onClick(){
        presenter.submit(username.getText().toString(), password.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void showLoadingDialog() {
        if (progressDialog.isShowing()) return;

        progressDialog.setTitle("Loading ...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideLoadingDialog() {
        if (progressDialog.isShowing()) progressDialog.dismiss();
    }

    @Override
    public void navigateToWelcome() {
        startActivity(new Intent(this, ActivityWelcome.class));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
