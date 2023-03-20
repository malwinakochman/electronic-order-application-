package pl.Kochman;

import org.junit.jupiter.api.Test;

public class BaseTest {

    @Test
    void testIt() {
        assert true == true;
    }

    @Test
    void testIt2() {
        String myName = "Malwina";
        String output = String.format("Hello %s", myName);
        assert output.equals("Hello Malwina");

    }
}
