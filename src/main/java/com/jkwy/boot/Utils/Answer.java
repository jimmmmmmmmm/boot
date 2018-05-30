package com.jkwy.boot.Utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by wangxinghao on 2018/5/15.
 */
public class Answer {

    private static final String  URL="https://www.qiushibaike.com/imgrank/page/";

    //下载地址
    private static final String  filePath="D:\\doutu\\qiubai";

    public static void main(String[] args) throws IOException{
        //一共13页         下3页
        for(int i =1 ; i<= 3; i++){
            down(URL,i);
        }

    }

    public static void down(String url,int a) throws IOException{

        // 解析网页源代码 伪装成浏览器
        Document document = Jsoup.connect(URL+a)
                .userAgent(
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
                .timeout(10000).get();

        Elements titles = document.select("div[class^=article block]");


        for(Element e : titles){
            //图片地址
            String herf = "http://"+(e.select("div[class=thumb]").first().getElementsByTag("img").attr("src").substring(2));
            //图片标题
            String title  = e.select("div[class=content]").first().getElementsByTag("span").text();


            System.out.println(herf+"=="+title+"，第"+a+"页");
            // 截取图片的名称
            String fileName = ("/" + title + herf.substring(herf.lastIndexOf("."))).replace(" ","").replace("", "");
            System.out.println(fileName);
            // 判断文件夹是否存在，如果不存在就创建一个文件夹
            File files = new File(filePath);
            if (!files.exists()) {
                files.mkdirs();
            }
            try {
                URL urls = new URL(herf);
                HttpURLConnection connection = (HttpURLConnection) urls.openConnection();
                InputStream is = connection.getInputStream();
                // 创建文件
                File file = new File(filePath + fileName);
                FileOutputStream out = new FileOutputStream(file);
                int i = 0;
                while ((i = is.read()) != -1) {
                    out.write(i);
                }
                is.close();
                out.close();
            } catch (Exception c) {
                c.printStackTrace();
            }

        }
        System.out.println(" 第"+a+"页"+"下载完成");
    }


}
