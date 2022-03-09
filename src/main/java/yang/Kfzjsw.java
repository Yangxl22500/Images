package yang;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 孔夫子旧书网
 */
public class Kfzjsw {
    public static void main(String[] args) throws Exception {
        //简单爬取列表图片
//        easy();
        //根据书籍爬取详细信息
        minute();
    }

    public static void minute() throws Exception {
        String url = "https://item.kongfz.com/Cxiaoshuo/tag_k34k33k30k30k31w" + "1";
        Document document = Jsoup.parse(new URL(url), 10000);
        Element element = document.getElementById("listBox");
        Elements elements = element.getElementsByClass("item-info");
        int j = 0;
        for (Element el : elements) {
            Elements title = el.getElementsByClass("title");
            for (Element ti : title) {
                Elements a = ti.getElementsByTag("a");
                for (Element a1 : a) {
                    String href = a1.attr("href");
                    Document document1 = Jsoup.parse(new URL(href), 10000);
                    //图书名
                    Elements bookTitle = document1.getElementsByClass("detail-title");
                    System.out.println(j++ + "." + bookTitle.get(0).text());
                    Elements elements1 = document1.getElementsByClass("detail-con clearfix");
                    Elements elements2 = elements1.get(0).getElementsByClass("info-con-box info-con-box-left");
                    Elements item = elements2.get(0).getElementsByClass("item");
                    for (int i = 0; i < item.size(); i++) {
                        String items = item.get(i).text();
                        System.out.println(items);
                    }
                    /*//作者:
                    String author = item.get(0).text();
                    System.out.println(author);
                    //出版社:
                    String press = item.get(1).text();
                    System.out.println(press);
                    //出版时间:
                    String time = item.get(2).text();
                    System.out.println(time);
                    //版次:
                    String revision = item.get(3).text();
                    System.out.println(revision);
                    //ISBN:
                    String ISBN = item.get(4).text();
                    System.out.println(ISBN);
                    //定价:
                    String price = item.get(5).text();
                    System.out.println(price);*/

                    System.out.println("=============================================");

                }

            }

        }

    }

    /**
     * 简单爬取列表图片
     *
     * @throws Exception
     */
    public static void easy() throws Exception {
        String url = "https://item.kongfz.com/Cxiaoshuo/tag_k34k33k30k30k31w" + "2";
        Document document = Jsoup.parse(new URL(url), 10000);
        Element listBox = document.getElementById("listBox");
        Elements elements = listBox.getElementsByClass("big-img-box");
        for (Element el : elements) {
            Elements img = el.getElementsByTag("img");
            String src = img.attr("src");
            String alt = img.attr("alt");
            System.out.println(src + alt);
            URL target = new URL(src);
            URLConnection urlConnection = target.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            OutputStream outputStream = new FileOutputStream("E:\\Reptile\\孔夫子旧书网\\" + alt + ".jpg");
            int temp = 0;
            while ((temp = inputStream.read()) != -1) {
                outputStream.write(temp);
            }
            System.out.println(alt + "下载完成");
            inputStream.close();
            outputStream.close();

        }
    }
}
