package com.solvd.reflectionExample;



import java.util.Objects;

public class Greeting {
    private String message;

    public Greeting() {
    }

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greeting greeting = (Greeting) o;
        return Objects.equals(message, greeting.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "com.solvd.reflectionExample.Greeting{" +
                "message='" + message + '\'' +
                '}';
    }
}
