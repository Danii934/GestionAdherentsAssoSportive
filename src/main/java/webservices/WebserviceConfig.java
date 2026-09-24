package webservices;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/projetPWA")
public class WebserviceConfig extends ResourceConfig {
    public WebserviceConfig() {
        packages("webservices");
    }
}
