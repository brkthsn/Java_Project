package com.thy.mercury.seamstress.test.date;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
public class DateTest
{
    public static void main(String[] args)
    {
        System.out.println("DayOfWeek, Month enum types:");
        System.out.println();
        System.out.println("DayOfWeek.SUNDAY.minus(3) :" + DayOfWeek.SUNDAY.minus(3));
        DayOfWeek d = DayOfWeek.FRIDAY;
        System.out.println("d.getDisplayName(TextStyle.SHORT, Locale.ENGLISH) :" + d.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        System.out.println("Month.MARCH.getDisplayName(TextStyle.FULL, Locale.ITALY) :" + Month.MARCH.getDisplayName(TextStyle.FULL, Locale.ITALY));
        //////////////////////////
        System.out.println();
        System.out.println("LocalDate:");
        System.out.println();
        LocalDate local = LocalDate.of(1976, 6, 22);
        System.out.println("local :" + local);
        LocalDate nextWed = local.with((TemporalAdjusters.next(DayOfWeek.WEDNESDAY)));
        System.out.println("nextWed :" + nextWed);
        System.out.println("local.get(ChronoField.DAY_OF_WEEK) :" + local.get(ChronoField.DAY_OF_WEEK));
        System.out.println();
        System.out.println("local.compareTo(nextWed) :" + local.compareTo(nextWed));
        System.out.println("local.format(DateTimeFormatter.ISO_WEEK_DATE) :" + local.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println("local.format(DateTimeFormatter.ISO_DATE) :" + local.format(DateTimeFormatter.ISO_DATE));
        System.out.println("local.get(ChronoField.YEAR_OF_ERA) :" + local.get(ChronoField.YEAR_OF_ERA));
        System.out.println("local.get(ChronoField.DAY_OF_YEAR) :" + local.get(ChronoField.DAY_OF_YEAR));
        System.out.println("local.getDayOfMonth() :" + local.getDayOfMonth());
        System.out.println("local.getDayOfYear() :" + local.getDayOfYear());
        System.out.println();
        System.out.println("YearMonth:");
        System.out.println();
        YearMonth thisMonth = YearMonth.now();
        System.out.println("thisMonth :" + thisMonth);
        System.out.println("thisMonth.lengthOfMonth() :" + thisMonth.lengthOfMonth());
        YearMonth feb29 = YearMonth.of(2016, 2);
        YearMonth feb28 = YearMonth.of(2015, 2);
        System.out.println("feb29+\" \"+feb29.lengthOfMonth() + \" \" + feb29.lengthOfYear() :" + feb29 + " " + feb29.lengthOfMonth() + " " + feb29.lengthOfYear());
        System.out.println("feb28+\" \"+feb28.lengthOfMonth() + \" \" + feb28.lengthOfYear() :" + feb28 + " " + feb28.lengthOfMonth() + " " + feb28.lengthOfYear());
        System.out.println("feb28.isValidDay(29) :" + feb28.isValidDay(29));
        System.out.println();
        System.out.println("MonthDay:");
        System.out.println();
        MonthDay monthDay = MonthDay.of(2, 29);
        System.out.println("monthDay :" + monthDay);
        System.out.println("monthDay.isValidYear(2011) :" + monthDay.isValidYear(2011));
        System.out.println("monthDay.atYear(2012) :" + monthDay.atYear(2012));
        System.out.println();
        System.out.println("Year:");
        System.out.println();
        System.out.println("Year.of(1976).isLeap() :" + Year.of(1976).isLeap());
        System.out.println("Year.now() :" + Year.now());
        System.out.println();
        System.out.println("LocalTime:");
        System.out.println();
        LocalTime thisSec = LocalTime.now();
        System.out.println("thisSec.getHour() + \" \" + thisSec.getMinute() + \" \" + thisSec.getSecond() :" + thisSec.getHour() + " " + thisSec.getMinute() + " " + thisSec.getSecond());
        LocalDateTime dateTime = thisSec.atDate(LocalDate.of(2000, 01, 02));
        System.out.println("dateTime :" + dateTime);
        System.out.println();
        System.out.println("LocalDateTime:");
        System.out.println();
        System.out.println("LocalDateTime.now() :" + LocalDateTime.now());
        System.out.println("LocalDateTime.of(2010, 10, 6, 6, 45) :" + LocalDateTime.of(2010, 10, 6, 6, 45));
        System.out.println("LocalDateTime.ofInstant(Instant.now(), ZoneId.of(\"+3\")) :" + LocalDateTime.ofInstant(Instant.now(), ZoneId.of("+3")));
        System.out.println("LocalDateTime.now().plusDays(5) :" + LocalDateTime.now().plusDays(5));
        System.out.println("LocalDateTime.now().plusMonths(5) :" + LocalDateTime.now().plusMonths(5));
        System.out.println("LocalDateTime.now().minusMonths(15) :" + LocalDateTime.now().minusMonths(15));
        System.out.println();
        System.out.println("ZoneId/ZoneOffset:");
        System.out.println();
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        LocalDateTime dt = LocalDateTime.now();
        // Create a List using the set of zones and sort it.
        List<String> zoneList = new ArrayList<String>(allZones);
        Collections.sort(zoneList);
        for (String s : zoneList)
        {
            ZoneId zone = ZoneId.of(s);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            int secondsOfHour = offset.getTotalSeconds() % (60 * 60);
            String out = String.format("%35s %10s%n", zone, offset);
            // Write only time zones that do not have a whole hour offset
            // to standard out.
            if (secondsOfHour != 0)
            {
                System.out.printf(out);
            }
        }
        System.out.println();
        System.out.println("ZonedDateTime:");
        System.out.println();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  HH:mm");
        LocalDateTime leaving = LocalDateTime.of(2017, Month.JULY, 20, 19, 30);
        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);
        try
        {
            String out1 = departure.format(format);
            System.out.printf("LEAVING:  %s (%s)%n", out1, leavingZone);
        }
        catch (DateTimeException exc)
        {
            System.out.printf("%s can't be formatted!%n", departure);
            throw exc;
        }
        ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
        int flightTime = 650;
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusMinutes(flightTime);
        try
        {
            String out2 = arrival.format(format);
            System.out.printf("ARRIVING: %s (%s)%n", out2, arrivingZone);
        }
        catch (DateTimeException exc)
        {
            System.out.printf("%s can't be formatted!%n", arrival);
            throw exc;
        }
        if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant()))
            System.out.printf("  (%s daylight saving time will be in effect.)%n", arrivingZone);
        else
            System.out.printf("  (%s standard time will be in effect.)%n", arrivingZone);
        System.out.println();
        System.out.println("OffsetDateTime:");
        System.out.println();
        LocalDateTime localDate = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        ZoneOffset offset = ZoneOffset.of("-08:00");
        OffsetDateTime offsetDate = OffsetDateTime.of(localDate, offset);
        OffsetDateTime lastThursday = offsetDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        System.out.printf("The last Thursday in July 2013 is the %sth.%n", lastThursday.getDayOfMonth());
        System.out.println();
        System.out.println("OffsetTime:");
        System.out.println();
        System.out.println("OffsetTime.of(LocalTime.now(), ZoneOffset.ofHours(-4)) :" + OffsetTime.of(LocalTime.now(), ZoneOffset.ofHours(-4)));
        System.out.println();
        System.out.println("Instant:");
        System.out.println();
        Instant nowInstant = Instant.now();
        System.out.println("nowInstant :" + nowInstant);
        System.out.println("nowInstant.plusSeconds(60) " + nowInstant.plusSeconds(60));
        Instant futureInstance = Instant.ofEpochSecond(Integer.MAX_VALUE);
        System.out.println("futureInstance :" + futureInstance);
        System.out.println(nowInstant.until(futureInstance, ChronoUnit.HOURS));
        System.out.println(LocalDateTime.ofInstant(futureInstance, ZoneOffset.ofHours(3)));
    }
}
