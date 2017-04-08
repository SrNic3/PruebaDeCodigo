package com.arstotzka.pruebadecodigo.Utils;

/**
 * Created by Dani on 08/04/2017.
 */

public interface NetCallback<T extends Object> {

    void onSuccess(T o);

    void onError(Object o);
}
