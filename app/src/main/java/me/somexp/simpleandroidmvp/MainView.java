package me.somexp.simpleandroidmvp;

/**
 * Created by xuanhong on 4/4/17.
 *
 * which utilities view can do for display info: show/hide dialog, show/hide toast
 *
 * how view populate data after receiving from presenter
 *
 */

public interface MainView {

    // view's utilitites
    void showLoadingDialog();

    void hideLoadingDialog();

    // how view action when received result
    void navigateToWelcome();

    void showMessage(String message);
}
