package com.example.jokerlib;

import java.util.Random;

public class Joker {

    private final String jokes[] = {
            "How do functions break up? \"They stop calling each other!\"",
            "In what unit do you measure a function's length? \"In Para meters...\"",
            "What did the flirtatious function say? \"Call me ;)\"",
            "Joke joke joke ",
            "Joke jokitty joke joke joke"
    };
    public String getJoke(){
        Random rand = new Random();
        int value = rand.nextInt(jokes.length - 1);
        return jokes[value];
    }
}
