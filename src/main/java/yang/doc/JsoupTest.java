package yang.doc;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.MalformedURLException;
import java.net.URL;

public class JsoupTest {
    public static void main(String[] args) throws Exception {
        String url = "https://www.douyin.com/user/MS4wLjABAAAAyEwckq1iESm4xM75cjIFAJ5PeyI8E1sqUiiOXlkl3no";
//        Document document = Jsoup.parse(new URL(url), 30000);
//        System.out.println(document);
        getHtmlPageResponse(url);
    }

    public static String getHtmlPageResponse(String url) throws Exception {

        //请求超时时间,默认20秒
        int timeout = 20000;
        //等待异步JS执行时间,默认20秒
        int waitForBackgroundJavaScript = 20000;
        String result = "";

        final WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);//是否启用CSS
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX

        webClient.getOptions().setTimeout(timeout);//设置“浏览器”的请求超时时间
        webClient.setJavaScriptTimeout(timeout);//设置JS执行的超时时间

        HtmlPage page;
        try {
            page = webClient.getPage(url);
        } catch (Exception e) {
            webClient.close();
            throw e;
        }
        webClient.waitForBackgroundJavaScript(waitForBackgroundJavaScript);//该方法阻塞线程

        result = page.asXml();
        webClient.close();

        return result;
    }
}
