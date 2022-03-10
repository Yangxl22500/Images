package yang.wallpaper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class BiAnTuWang {
    public static void main(String[] args) throws IOException {
        int j = 0;
        for (int i = 1; i < 142; i++) {
            String url = null;
            if (i == 1) {
                url = "https://pic.netbian.com/4kmeinv/";
            }else {
                url = "https://pic.netbian.com/4kmeinv/index_"+ i + ".html";
            }
            Document document = Jsoup.parse(new URL(url), 5000);
            Elements elements = document.getElementsByClass("slist");
            Elements ul = elements.get(0).getElementsByTag("ul");
            Elements img = ul.get(0).getElementsByTag("img");
            for (Element element : img) {
                String src = element.attr("src");
                String alt = element.attr("alt");
                src = "https://pic.netbian.com/" + src;
                URL tatget = new URL(src);
                URLConnection urlConnection = tatget.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                try {
                    OutputStream outputStream = new FileOutputStream("E:\\Reptile\\彼岸图网\\" + alt + ".jpg");
                    int temp = 0;
                    while ((temp = inputStream.read()) != -1) {
                        outputStream.write(temp);
                    }
                    outputStream.write(inputStream.read());
                    inputStream.close();
                    outputStream.close();
                    j++;
                    System.out.println(j + "." + alt + ".jpg下载完毕");
                } catch (IOException e) {
                    System.out.println("文件名有误。。。。。。。");
                    e.printStackTrace();
                }
            }

        }

    }
}
