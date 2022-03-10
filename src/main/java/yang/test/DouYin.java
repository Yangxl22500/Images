package yang.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class DouYin {
    public static void main(String[] args) throws Exception {
//        String url = "https://www.douyin.com/user/MS4wLjABAAAAxHqCLnTmAPwDpnx2UDR410Cls9pAZt97Q9AP1ovKCPJAT1FGVwQw_3d589YpkJ7v";
        String url = "https://www.kuaishou.com/profile/3x9mr5wvey9afuw";
        Document document = Jsoup.parse(new URL(url), 10000);
        System.out.println(document);
        Element element = document.getElementById("root");
//        System.out.println(element);
        Elements elements = document.getElementsByClass("_bEYe5zo");
        System.out.println(elements);
    }
}
