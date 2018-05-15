package com.jkwy.boot.Utils;

/**
 * Created by wangxinghao on 2018/5/15.
 */
public class Answer {

    Document document = Jsoup.connect(URL)
            .userAgent(
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
            .timeout(10000).get();

}
