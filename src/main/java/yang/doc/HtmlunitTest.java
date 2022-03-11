package yang.doc;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlunitTest {
    public static void main(String[] args) throws Exception {
        String url = "https://www.douyin.com/user/MS4wLjABAAAAnLi0U64jXuDasA51NEU-ZLqICRBj_3b1YJcAg4i2hKo";

        final WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);//是否启用CSS
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX

        webClient.getOptions().setTimeout(30000);//设置“浏览器”的请求超时时间
        webClient.setJavaScriptTimeout(30000);//设置JS执行的超时时间

        HtmlPage page;
        try {
            page = webClient.getPage(url);
        } catch (Exception e) {
            webClient.close();
            throw e;
        }
        webClient.waitForBackgroundJavaScript(30000);//该方法阻塞线程

        String result = page.asXml();
        System.out.println(page);
        System.out.println(page.asText());
//        System.out.println(page.getHtmlElementById("ECMy_Zdt"));
//        System.out.println(page.getBody());
//        System.out.println(page.getPage());
//        System.out.println(page.getDocumentElement());
        DomNodeList<DomElement> a = page.getElementsByTagName("ul");
        for (DomElement domElement : a) {
            DomNodeList<HtmlElement> a1 = domElement.getElementsByTagName("a");
            for (HtmlElement htmlElement : a1) {
                String href = htmlElement.getAttribute("href");
                System.out.println(href + "?modeFrom=userPost&secUid=MS4wLjABAAAAnLi0U64jXuDasA51NEU-ZLqICRBj_3b1YJcAg4i2hKo");
            }
//            System.out.println(domElement);
        }
//        System.out.println(result);
        webClient.close();
    }


}
