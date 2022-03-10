package yang.doc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.MalformedURLException;
import java.net.URL;

public class test {
    public static void main(String[] args) throws Exception {
        String url = "https://www.douyin.com/user/MS4wLjABAAAAyEwckq1iESm4xM75cjIFAJ5PeyI8E1sqUiiOXlkl3no";
        Document document = Jsoup.parse(new URL(url), 30000);
        System.out.println(document);
    }
}
