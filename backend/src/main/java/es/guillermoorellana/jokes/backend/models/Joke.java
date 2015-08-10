package es.guillermoorellana.jokes.backend.models;

import java.io.Serializable;

/**
 * The object model for the data we are sending through endpoints
 */
public class Joke implements Serializable {
    
    private String text;
    
    public String getText() {
        return text;
    }
    
    public void setText(String data) {
        text = data;
    }
}