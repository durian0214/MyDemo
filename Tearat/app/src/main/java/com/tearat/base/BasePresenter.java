package com.tearat.base;



/**
 * Durian
 * 2017-2017/3/15
 */
public class BasePresenter <V> {
  public  V myView;
    public void attachView(V myView) {
        this.myView = myView;
    }
    public void detachView() {
        this.myView = null;
    }


}
