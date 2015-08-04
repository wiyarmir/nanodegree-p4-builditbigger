package es.guillermoorellana.jokes.backend.models;

/**
 * The object model for the data we are sending through endpoints
 */
public class Joke {
    
    private String text;
    
    public String getText() {
        return text;
    }
    
    public void setText(String data) {
        text = data;
    }
}