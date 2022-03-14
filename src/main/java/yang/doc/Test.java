package yang.doc;

import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class Test {
    private static final String videoPath = "";
    public static void main(String[] args) throws IOException {
        String url = "https://www.douyin.com/user/MS4wLjABAAAAlrxZwarwD9gjtqlJ4QSnh14jSEIF2DjDjm88ltrrfRQ";
        /*Connection con= Jsoup.connect(url);
        con.header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 Version/12.0 Safari/604.1");
        Connection.Response resp=con.method(Connection.Method.GET).execute();*/
        String body = Jsoup.connect(url).ignoreContentType(true).execute().body();
        System.out.println(body);
        JSONObject json =JSONObject.parseObject(body);
//        String videoUrl= videoPath+getItemId(resp.url().toString());
//        System.out.println(videoUrl);
    }
}
