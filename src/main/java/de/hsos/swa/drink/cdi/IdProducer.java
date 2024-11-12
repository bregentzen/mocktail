package de.hsos.swa.drink.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.jboss.logging.Logger;

@ApplicationScoped
public class IdProducer {
    private static final Logger logging = Logger.getLogger(IdProducer.class);

    private int id = 1;

    @Produces
    public int createId() {
        logging.info("Creating new ID");
        logging.trace("ID: " + id);
        return id++;
    }
}
