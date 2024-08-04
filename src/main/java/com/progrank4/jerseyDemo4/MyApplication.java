package com.progrank4.jerseyDemo4;

import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/webapi")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("com.yourcompany.yourapp");
        register(CORSFilter.class); // Register the CORS filter
    }
}
