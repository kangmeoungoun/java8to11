package me.goldapple.java8to11;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

public class App {
    public static void main(String[] args) {
        //기게용 API 시간을 재거나 메소드 실행시간을 비교할때 사용
        Instant instant = Instant.now();
        System.out.println(instant); //기준시 UTC, GMT
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);  //어느 존의 기준으로 현재시간을 볼것이냐.
        System.out.println(zonedDateTime);
        //인간용 API
        System.out.println("============================");
        //코드가 동작하고 있는 서버의 로컬 시간 서버가 미국에 있으면 미국시간.
        LocalDateTime now  = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthDay = LocalDateTime.of(1991 , Month.DECEMBER , 2 , 0 , 0 , 0);
        System.out.println(birthDay);


        //서로 변환 가능.
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);
        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);
        System.out.println("========================");
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2021 , Month.DECEMBER , 2);

        System.out.println(today);
        System.out.println(thisYearBirthday);
        Period period = Period.between(today , thisYearBirthday);


        //휴먼용 시간 비교 PERIOD 기계용 DURATION
        Period until = today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.MONTHS));

        System.out.println("==========================");
        Instant now1 = Instant.now();
        Instant plus = now1.plus(1 , ChronoUnit.DAYS);
        Duration between = Duration.between(now1 , plus);
        System.out.println(between.getSeconds());

        LocalDateTime now2 = LocalDateTime.now();
        DateTimeFormatter MMddyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter basicIsoDate = DateTimeFormatter.BASIC_ISO_DATE;
        System.out.println(now2.format(MMddyy));
        System.out.println(System.currentTimeMillis());
        System.out.println("==========================");

        String text = "12/01/1991";
        LocalDate parse = LocalDate.parse(text , MMddyy);
        System.out.println(parse);

        Date date = new Date();
        Instant instant1 = date.toInstant();
        Date newDate1 = Date.from(instant1);

        ZoneId zoneId1 = TimeZone.getTimeZone("Asia/Seoul").toZoneId();
        System.out.println(zoneId1);



        System.out.println(now2.plus(1,ChronoUnit.WEEKS)
        );
    }

}
