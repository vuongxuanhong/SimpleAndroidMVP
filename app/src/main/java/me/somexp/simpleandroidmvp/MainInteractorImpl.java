package me.somexp.simpleandroidmvp;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by xuanhong on 4/12/17.
 */

public class MainInteractorImpl implements MainInteractor {

    MainModel model;

    public MainInteractorImpl(MainModel model) {
        this.model = model;
    }

    @Override
    public void login(final String name, final String pass, final OnMainFinishedListener listener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                final boolean isRightUser = model.isRightUser(name, pass);


                // the result should deliver result to main thread
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null)
                            if (isRightUser) listener.onLoginSuccessful();
                            else listener.onLoginFailed();
                    }
                }, 2000);
            }
        }).start();

    }


}
