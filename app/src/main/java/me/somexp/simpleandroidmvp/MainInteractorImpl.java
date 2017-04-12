package me.somexp.simpleandroidmvp;

/**
 * Created by xuanhong on 4/12/17.
 */

public class MainInteractorImpl implements MainInteractor {

    MainModel model;

    public MainInteractorImpl(MainModel model) {
        this.model = model;
    }

    @Override
    public void login(String name, String pass, OnMainFinishedListener listener) {
        boolean isRightUser = model.isRightUser(name, pass);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (listener != null)
            if (isRightUser) listener.onLoginSuccessful();
            else listener.onLoginFailed();

    }
}
