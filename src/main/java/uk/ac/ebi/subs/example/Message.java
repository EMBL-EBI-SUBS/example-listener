package uk.ac.ebi.subs.example;

public class Message {

    private String someWords;
    private Long anIdentifier;
    private Boolean anotherProperty;

    public String getSomeWords() {
        return someWords;
    }

    public void setSomeWords(String someWords) {
        this.someWords = someWords;
    }

    public Long getAnIdentifier() {
        return anIdentifier;
    }

    public void setAnIdentifier(Long anIdentifier) {
        this.anIdentifier = anIdentifier;
    }

    public Boolean getAnotherProperty() {
        return anotherProperty;
    }

    public void setAnotherProperty(Boolean anotherProperty) {
        this.anotherProperty = anotherProperty;
    }

    @Override
    public String toString() {
        return "Message{" +
                "someWords='" + someWords + '\'' +
                ", anIdentifier=" + anIdentifier +
                ", anotherProperty=" + anotherProperty +
                '}';
    }
}
