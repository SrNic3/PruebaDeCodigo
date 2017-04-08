package com.arstotzka.pruebadecodigo.Utils;

/**
 * Created by Dani on 08/04/2017.
 */

public class ADB {

    private static Object object;

    public static void setObject(Object o) {
        object = o;
    }

    public static Object getObject() {
        Object o = object;
        object = null;
        return o;
    }
}
