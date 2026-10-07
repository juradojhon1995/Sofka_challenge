package co.com.sofka.challenge.runners;

import com.intuit.karate.junit5.Karate;

class PetStoreRunner {
    
    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:co/com/sofka/challenge/features").relativeTo(getClass());
    }    
}
