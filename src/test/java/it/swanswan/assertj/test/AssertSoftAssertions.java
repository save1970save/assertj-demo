package it.swanswan.assertj.test;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AssertSoftAssertions {
    @Test
   // @Disabled
    void assertSofltyTest (){
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat("Hello World")
                .isNotNull()
                .hasSize(11)
                .contains("Hello")
                .isInstanceOf(String.class)
                .doesNotContain("Hi");

        System.out.println("Im here !");

        softly.assertAll();
    }

}
