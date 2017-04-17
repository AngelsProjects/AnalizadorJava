package analizadorjava;

public class Tokens {

    private String name;
    private String token;

    public Tokens(String name, String token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpression() {
        return token;
    }

    public void setExpression(String token) {
        this.token = token;
    }
}
