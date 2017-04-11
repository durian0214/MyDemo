package com.tearat.user.presenter;

import com.tearat.base.BasePresenter;
import com.tearat.user.view.LoginView;

/**
 * Durian
 * 2017-2017/4/11
 * 登录
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    public LoginPresenter(LoginView view) {
        attachView(view);
    }
}
