package me.somexp.simpleandroidmvp;

/**
 * Created by xuanhong on 4/4/17.
 */

public class MainPresenterImpl implements MainPresenter, MainInteractor.OnMainFinishedListener {

    MainView view;
    MainInteractor interactor;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        interactor = new MainInteractorImpl(new MainModelImpl());
    }

    @Override
    public void submit(String name, String pass) {
        view.showLoadingDialog();
        interactor.login(name, pass, this);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onLoginSuccessful() {
        view.hideLoadingDialog();
        view.navigateToWelcome();
    }

    @Override
    public void onLoginFailed() {
        view.hideLoadingDialog();
        view.showMessage("Login failed");
    }
}
