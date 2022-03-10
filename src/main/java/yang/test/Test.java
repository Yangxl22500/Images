package yang.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Test {

    public static void main(String[] args) throws Exception {
        String url = "https://www.zhihu.com/question/302378021/answer/1853976015";
        Document document = Jsoup.parse(new URL(url), 10000);
        Elements elements = document.getElementsByClass("RichContent-inner");
        for (Element element : elements) {
            Elements noscript = element.getElementsByTag("noscript");
            int i = 0;
            for (Element element1 : noscript) {
                Elements img = element1.getElementsByTag("img");
                String src = img.attr("src");
                System.out.println(src);
                URL target = new URL(src);
                URLConnection urlConnection = target.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                i++;
                OutputStream outputStream = new FileOutputStream("E:\\Reptile\\Images\\" + i + ".jpg");
                int temp = 0;
                while ((temp = inputStream.read()) != -1){
                    outputStream.write(temp);
                }
                System.out.println(i + ".jpg下载完毕");
                outputStream.close();
                inputStream.close();
                /*int i = 0;
                System.out.println(element);
                for (Element element2 : img) {
                    String src = element2.attr("src");
                    System.out.println(element2);
                    //获取输入流
                    URL target = new URL(src);
                    URLConnection urlConnection = target.openConnection();
                    InputStream inputStream = urlConnection.getInputStream();
                    i++;
                    OutputStream outputStream = new FileOutputStream("E:\\Reptile\\Images\\" + i + ".jpg");
                    int temp = 0;
                    while ((temp = inputStream.read()) != -1){
                        outputStream.write(temp);
                    }
                    System.out.println(i + ".jpg下载完毕");
                    outputStream.close();
                    inputStream.close();
                }*/
            }

        }
    }
}
