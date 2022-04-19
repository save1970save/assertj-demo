package it.swanswan.assertj.test;

//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.joda.time.LocalDate;
import org.assertj.jodatime.api.*;

public class AssertJodaDemo {
    @Test
    void dateTimeTest(){
        LocalDate date = new LocalDate(2000,1,1);

        Assertions.assertThat(date)
                .hasYear(2000)
                .hasMonthOfYear(1)
                .hasDayOfMonth(1)
                .isBefore("2000-01-02")
                .isBeforeOrEqualTo("2000-01-01")
                .isBeforeOrEqualTo(new LocalDate(2000,1,1))
                .isBeforeOrEqualTo("2000-01-02")
                .isBeforeOrEqualTo(new LocalDate(2000,1,2))
                .isEqualTo(new LocalDate(2000,1,1))
                .isEqualTo("2000-01-01")
                .isAfterOrEqualTo(new LocalDate(2000,1,1))
                .isAfterOrEqualTo("2000-01-01")
                .isAfterOrEqualTo(new LocalDate(1999,12,31))
                .isAfterOrEqualTo("1999-12-31")
                .isAfter(new LocalDate(1999,12,31))
                .isNotEqualTo("2000-01-15")
                .isNotEqualTo(new LocalDate(2000,1,15))
                .isIn(new LocalDate(1999,12,15), new LocalDate(2000,1,1))
                .isIn("2000-01-01", "2000-01-02")
                .isNotIn(new LocalDate(1999,11,15), new LocalDate(1999,12,15))
                .isNotIn("1999-11-15", "1999-12-15");
    }
}
