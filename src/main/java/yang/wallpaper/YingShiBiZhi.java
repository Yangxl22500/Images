package yang.wallpaper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

public class YingShiBiZhi {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 20; i++) {
            String url = "http://xinzhuobu.com/?cat=23&paged=" + i;
            Document document = Jsoup.parse(new URL(url), 5000);
            Elements elements = document.getElementsByClass("row posts-wrapper");
            Elements elements1 = elements.get(0).getElementsByClass("col-lg-1-5 col-6 col-sm-6 col-md-4 col-lg-3");
            for (Element element : elements1) {
                Elements img = element.getElementsByTag("img");
                String attr = img.attr("data-src");
                String alt = img.attr("alt");
                URL tatget = new URL(attr);
                URLConnection urlConnection = tatget.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                File file;
                try {
                    OutputStream outputStream = new FileOutputStream("E:\\Reptile\\影视壁纸2\\" + alt + ".jpg");
                    int temp = 0;
                    while ((temp = inputStream.read()) != -1 ){
                        outputStream.write(temp);
                    }
                    inputStream.close();
                    outputStream.close();
                    System.out.println(alt + ".jpg下载完成");
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
        }
    }
}
