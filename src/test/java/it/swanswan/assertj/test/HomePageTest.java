package it.swanswan.assertj.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class HomePageTest {
    @Test
    void test3 () {
        String title = "Il taglio del bosco";
        Assertions.assertThat(title)
                .as("Title is null").isNotNull()
                .as("It does not contain expected string").containsIgnoringCase("taglio")
                .matches("\\w.*" + "del bosco")
                .hasSizeBetween(10,50);

        List<String> lst = Arrays.asList("UNO","DUE","TRE","QUATTRO");
        Assertions.assertThat(lst)
                .hasSize(4)
                .containsAnyOf("TRE");
    }
}
