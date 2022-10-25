package com.skypro.introductiontodatabases.exeption;

public class StudentNotFoundException extends RuntimeException{

    public final long id;

    public StudentNotFoundException(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
