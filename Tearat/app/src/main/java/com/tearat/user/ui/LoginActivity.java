package com.tearat.user.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tearat.R;
import com.tearat.base.BaseActivity;
import com.tearat.user.presenter.LoginPresenter;
import com.tearat.user.view.LoginView;

/**
 * Durian
 * 2017-2017/4/11
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener ,LoginView {
    private EditText edtAccount, edtPW;
    private Button btnLogin;
    private LoginPresenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        presenter= new LoginPresenter(this);
        edtAccount = getId(R.id.edt_login_account);
        edtPW = getId(R.id.edt_login_pw);
        btnLogin = getId(R.id.btn_login);
    }

    @Override
    public void setOnclick() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void onClick(View v) {
        switch
                (v.getId()) {
            case R.id.btn_login:
                break;
        }
    }

    @Override
    public void netError(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
