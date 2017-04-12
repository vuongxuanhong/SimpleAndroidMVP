package me.somexp.simpleandroidmvp;

/**
 * Created by xuanhong on 4/4/17.
 *
 * handle request form presenter and process it with db
 *
 * handle results and notify for presenter
 */

public interface MainInteractor {

    interface OnMainFinishedListener {
        void onLoginSuccessful();
        void onLoginFailed();
    }

    void login(String name, String pass, OnMainFinishedListener listener);
}
