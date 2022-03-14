package yang.doc;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlunitTest {

   static final WebClient webClient = new WebClient(BrowserVersion.CHROME);

    public static void main(String[] args) throws Exception {
        String url = "https://www.douyin.com/user/";
        String user = "MS4wLjABAAAAViovMw_TvOh5CvYZaEtj4th6nb8DiDakONVPWygGi4k";
        url = url + user;
        HtmlPage result = result(url);

//        webClient.waitForBackgroundJavaScript(30000);//该方法阻塞线程

        DomNodeList<DomElement> ul = result.getElementsByTagName("ul");
        String aClass2 = ul.get(2).getAttribute("class");
        if (aClass2.equals("ARNw21RN")){
            DomNodeList<HtmlElement> a1 = ul.get(2).getElementsByTagName("a");
            for (HtmlElement htmlElement : a1) {
                String href = htmlElement.getAttribute("href");
                String pathUrl = "https:" + href;
                System.out.println(pathUrl);

            }

        }
        webClient.close();
    }

    public static HtmlPage result(String url) throws Exception{

        //当JS执行出错的时候是否抛出异常
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        //当HTTP的状态非200时是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setActiveXNative(false);
        //是否启用CSS
        webClient.getOptions().setCssEnabled(false);
        //很重要，启用JS
        webClient.getOptions().setJavaScriptEnabled(true);
        //很重要，设置支持AJAX
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        //设置“浏览器”的请求超时时间
        webClient.getOptions().setTimeout(30000);
        //设置JS执行的超时时间
        webClient.setJavaScriptTimeout(30000);
        HtmlPage page;
        try {
            page = webClient.getPage(url);
        } catch (Exception e) {
            webClient.close();
            throw e;
        }
        return page;
    }


}
