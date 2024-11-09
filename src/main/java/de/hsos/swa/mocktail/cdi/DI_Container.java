package de.hsos.swa.mocktail.cdi;


import jakarta.enterprise.inject.Produces;

public class DI_Container {
    private static int id = 1;

    @Produces
    public static int createId() {
        return id++;
    }
}
