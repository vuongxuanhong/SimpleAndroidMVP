package me.somexp.simpleandroidmvp;

/**
 * Created by xuanhong on 4/4/17.
 *
 * how presenter process the data after received from view
 *
 * presenter usually have life-cycle methods to handle configuration changed or handle activity life-cycle
 */

public interface MainPresenter {

    /**
     * submit login information
     * @param name
     * @param pass
     */
    void submit(String name, String pass);

    /**
     * resume the view after interruption, can perform some action like refresh view or something else ...
     */
    void onResume();
}
