package de.hsos.swa.drink.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.jboss.logging.Logger;

@ApplicationScoped
public class IdProducer {


    private int id = 1;

    @Produces
    public int createId() {
        return id++;
    }
}
