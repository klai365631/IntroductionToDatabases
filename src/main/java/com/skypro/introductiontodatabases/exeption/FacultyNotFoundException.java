package com.skypro.introductiontodatabases.exeption;

public class FacultyNotFoundException extends RuntimeException{

    public final long id;

    public FacultyNotFoundException(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
