package org.example.b1;

public class Hello {
    public static void main(String[] args) {
        String name = args.length == 0 ? "tanh" : String.join(" ", args);
        System.out.println("Hello " + name);
    }
}
