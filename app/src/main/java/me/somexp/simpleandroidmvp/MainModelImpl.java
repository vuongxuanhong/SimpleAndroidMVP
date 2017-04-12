package me.somexp.simpleandroidmvp;

/**
 * Created by xuanhong on 4/12/17.
 */

public class MainModelImpl implements MainModel {
    @Override
    public boolean isRightUser(String username, String password) {
        return username.equalsIgnoreCase("hong") && password.equalsIgnoreCase("hong123");
    }
}
