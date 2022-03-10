package yang.wallpaper;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class DouyinTest {
    public static void main(String[] args) throws IOException {
        Connection con= Jsoup.connect("https://www.douyin.com/user/MS4wLjABAAAAlrxZwarwD9gjtqlJ4QSnh14jSEIF2DjDjm88ltrrfRQ");
        con.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36 Edg/99.0.1150.36");
        Connection.Response resp=con.method(Connection.Method.GET).execute();
        String s = resp.url().toString();
        Document parse = Jsoup.parse(new URL(s), 3000);
        System.out.println(parse);
        System.out.println(s);
//        String videoUrl= videoPath+getItemId(resp.url().toString());
//        System.out.println(videoUrl);
    }
}
