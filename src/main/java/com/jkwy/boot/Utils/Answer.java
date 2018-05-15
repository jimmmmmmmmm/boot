package com.jkwy.boot.Utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by wangxinghao on 2018/5/15.
 */
public class Answer {

    public static void mian()throws IOException{
        Document document = Jsoup.connect("")
                .userAgent(
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
                .timeout(10000).get();
    }


}
