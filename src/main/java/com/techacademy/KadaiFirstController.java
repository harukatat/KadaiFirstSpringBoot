package com.techacademy;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.Calendar;//追加 結局使用せず

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController{

    @GetMapping("/")
    public String index() {
        return "Hello SpringBoot!";
    }
 // ----- 追加:ここから -----
    @GetMapping("/dayofweek/{daytxt}")
  //日付をLocalDate型に変換

    public String dispDayOfWeek(@PathVariable String daytxt) {

        int yyyy = Integer.parseInt(daytxt.substring(0,4));
        int mm   = Integer.parseInt(daytxt.substring(4,6));
        int dd   = Integer.parseInt(daytxt.substring(6,8));


            //日付をLocalDate型に変換
            LocalDate ld = LocalDate.of(yyyy, mm,  dd);
            //曜日を取得
            DayOfWeek w = ld.getDayOfWeek();

            int day = w.getValue();
            if (day == 0) {
                return "Sunday";
            } else if(day == 1) {
                return "Monday";
            } else if(day == 2) {
                return "Tuesday";
            } else if(day == 3) {
                return "Wednesday";
            } else if(day == 4) {
                return "Thursday";
            } else if(day == 5) {
                return "Friday";
            } else if(day == 6) {
                return "Saturday";}
            return daytxt;

        }

 // もう一つの課題：計算
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res1 = 0;
        res1 = val1 + val2;
        return "計算結果：" + res1;
    }
    @GetMapping("/minus/{val3}/{val4}")
    public String calcMinus(@PathVariable int val3, @PathVariable int val4) {
        int res2 = 0;
        res2 = val3 - val4;
        return "計算結果：" + res2;
    }
    @GetMapping("/times/{val5}/{val6}")
    public String calcTimes(@PathVariable int val5, @PathVariable int val6) {
        int res3 = 0;
        res3 = val5 * val6;
        return "計算結果：" + res3;
    }
    @GetMapping("/divide/{val7}/{val8}")
        public String calcDivide(@PathVariable double val7, @PathVariable double val8) {
            double res4 = 0;
            res4 = val7 / val8;
            return "計算結果：" + res4;

    }

}