package org.example.is_lab1;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.example.is_lab1.controllers.CoordinatesController;
import org.example.is_lab1.controllers.LocationController;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(CoordinatesController.class);
        classes.add(LocationController.class);

        return classes;
    }
}
