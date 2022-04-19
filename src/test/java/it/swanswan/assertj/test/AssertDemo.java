package it.swanswan.assertj.test;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class AssertDemo {
    @Test
  //  @Disabled
    void stringsTest () {
        String temp = "Hello World";
        String a = "";
        String b = "    ";

        Assertions.assertThat(temp)
                .as("String is null").isNotNull()
                .as("String is empty").isNotEmpty()
                .as("String is blank").isNotBlank()
               // .isEqualTo("Hello World")
                .contains("Hello")
                .doesNotContain("Hi")
                .containsWhitespaces()
                .containsIgnoringCase("world")
                .matches("\\w.*" + " World")
                .doesNotContainPattern("\\d.*")
                .hasSize(11)
                .hasSizeGreaterThan(10)
                .hasSizeLessThan(20)
                .hasSizeBetween(10,20)
                .endsWith("World")
                .isInstanceOf(String.class);
    }

    @Test
    // @Disabled
    void numbersTest () {
        int a = 10;

        Assertions.assertThat(a)
                .isEqualTo(10)
                .as("is not close to").isCloseTo(15, Offset.offset(5)  )
                .isInstanceOf(Integer.class)
                .isBetween(3,15)
                .isCloseTo(12, Percentage.withPercentage(30)  )
                .isNotCloseTo(15, Percentage.withPercentage(30))
                .isPositive()
                .isEven()
                .isGreaterThanOrEqualTo(5)
                .isLessThanOrEqualTo(20);
    }

    @Test
    // @Disabled
    void listTest () {
        List<String> list = Arrays.asList("Testing","Mini","Bytes");
        List<String> list2 = Arrays.asList("Testing","Mini");
        List<String> list3 = Arrays.asList("Automation","Selenium");

        Assertions.assertThat(list)
                .hasSize(3)
                .hasSizeBetween(2,4)
                .hasAtLeastOneElementOfType(String.class)
                .isNotEmpty()
                .contains("Testing")
                .doesNotContain("Automation")
                .startsWith("Testing")
                .containsExactlyInAnyOrder("Mini","Bytes","Testing")
                .containsExactly("Testing","Mini","Bytes")
                .withFailMessage("String can not be less than 3").allMatch(s -> s.length() < 10)
                .containsAll(list2)
                .doesNotContainAnyElementsOf(list3);

    }

    @Test
    // @Disabled
    void mapTest (){
        Map<String, String> map = new HashMap<>();
        map.put("name","Amuthan");
        map.put("channel","Testing mini bytes");
        map.put("game","Cricket");

        Assertions.assertThat(map)
                .containsEntry("game", "Cricket")
                .hasSize(3)
                .isNotEmpty()
                .doesNotContainEntry("game", "Soccer")
                .doesNotContainKey("fav")
                .containsKey("game")
                .as("does not contain Cricket value").containsValue("Cricket");

    }


    @Test
    // @Disabled
    void assertBDDTestStyle (){
        BDDAssertions.then("Hello World")
                .isInstanceOf(String.class)
                .hasSize(11)
                .matches("\\w.*" + "World")
                .endsWith("World")
                .containsIgnoringCase("hello");
    }

    @Test
    void customClassTest (){
        Employee emp1 = new Employee(40,"sunchin", 100);
        Employee emp2 = new Employee(40,"sunchin", 100);
        Assertions.assertThat(emp1)
                .isEqualToComparingFieldByField(emp2)
                .isNotNull()
                .isInstanceOf(Employee.class)
                .hasFieldOrProperty("age")
                .hasFieldOrPropertyWithValue("name","sunchin")
                .extracting(e -> e.getAge()).isNotEqualTo(24);

    }


}
