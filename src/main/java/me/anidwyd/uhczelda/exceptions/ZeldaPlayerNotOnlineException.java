package me.anidwyd.uhczelda.exceptions;

public class ZeldaPlayerNotOnlineException extends Exception {

    private static final long serialVersionUID = 1159293747235742412L;

    public ZeldaPlayerNotOnlineException(String name) {
        super("Error : Player " + name + " is not online");
    }
}
