package dk.thrysoee;

public class GreeterImpl implements Greeter {

    @Override
    public String greet(final String name) {
        return "Hello " + name;
    }
}
