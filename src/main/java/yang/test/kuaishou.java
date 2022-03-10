package yang.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class kuaishou {
    public static void main(String[] args) throws Exception {
//        test();
        test1();
    }

    public static void test1() throws Exception {
        String url = "https://www.kuaishou.com/";
        Connection connection = Jsoup.connect(url);
        connection.header("accept","*/*");
        connection.header("Accept-Encoding","gzip, deflate, br");
        connection.header("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
        connection.header("Connection","keep-alive");
        connection.header("Content-Length","1290");
        connection.header("content-type","application/json");
        connection.header("Cookie","kpf=PC_WEB; kpn=KUAISHOU_VISION; clientid=3; did=web_484de65803f61c8f4de57fe8fc5c2373; ktrace-context=1|MS43NjQ1ODM2OTgyODY2OTgyLjg4NDk3ODUxLjE2NDY4ODkwMjI2MDUuMTM3OTEwMDQ=|MS43NjQ1ODM2OTgyODY2OTgyLjU5NjY1NTUyLjE2NDY4ODkwMjI2MDUuMTM3OTEwMDU=|0|graphql-server|webservice|false|NA");
        connection.header("Host","www.kuaishou.com");
        connection.header("Origin","https://www.kuaishou.com");
        connection.header("Referer","https://www.kuaishou.com/profile/3xtcvbmfitzkba9");
        connection.header("sec-ch-ua","\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"99\", \"Microsoft Edge\";v=\"99\"");
        connection.header("sec-ch-ua-mobile","?0");
        connection.header("sec-ch-ua-platform","\"Windows\"");
        connection.header("Sec-Fetch-Dest","empty");
        connection.header("Sec-Fetch-Mode","cors");
        connection.header("Sec-Fetch-Site","same-origin");
        connection.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36 Edg/99.0.1150.36");
        connection.ignoreHttpErrors(true);
        Connection.Response response = connection.method(Connection.Method.POST).execute();
        String body = response.body();
        System.out.println(body);
    }

    public static void test() throws Exception {
        String url = "https://www.kuaishou.com/";
        Connection connection = Jsoup.connect(url);
        /*connection.header("Connection","keep-alive");
        connection.header("Content-Encoding","gzip");
        connection.header("Content-Type","text/html; charset=utf-8");
        connection.header("Date","Thu, 10 Mar 2022 05:37:13 GMT");
        connection.header("Set-Cookie","kpf=PC_WEB; path=/; expires=Fri, 10 Mar 2023 05:37:12 GMT; domain=www.kuaishou.com; httponly");
        connection.header("Set-Cookie","kpn=KUAISHOU_VISION; path=/; expires=Thu, 10 Mar 2022 05:37:12 GMT; domain=.kuaishou.com; httponly");
        connection.header("Set-Cookie","kpn=KUAISHOU_VISION; path=/; expires=Fri, 10 Mar 2023 05:37:12 GMT; domain=www.kuaishou.com; httponly");
        connection.header("Set-Cookie","clientid=3; path=/; expires=Fri, 10 Mar 2023 05:37:12 GMT; domain=kuaishou.com; httponly");
        connection.header("Set-Cookie","did=web_484de65803f61c8f4de57fe8fc5c2373; path=/; expires=Fri, 10 Mar 2023 05:37:12 GMT; domain=kuaishou.com");
        connection.header("Transfer-Encoding","chunked");
        connection.header("X-KSClient-IP","183.162.230.254");
        connection.header("X-KSLOGID","646890632995781230");*/
        connection.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        connection.header("Accept-Encoding","gzip, deflate, br");
        connection.header("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
        connection.header("Cache-Control","max-age=0");
        connection.header("Connection","keep-alive");
        connection.header("Cookie","kpf=PC_WEB; kpn=KUAISHOU_VISION; clientid=3; did=web_484de65803f61c8f4de57fe8fc5c2373; ktrace-context=1|MS43NjQ1ODM2OTgyODY2OTgyLjg4NDk3ODUxLjE2NDY4ODkwMjI2MDUuMTM3OTEwMDQ=|MS43NjQ1ODM2OTgyODY2OTgyLjU5NjY1NTUyLjE2NDY4ODkwMjI2MDUuMTM3OTEwMDU=|0|graphql-server|webservice|false|NA");
        connection.header("Host","www.kuaishou.com");
        connection.header("Referer","https://cn.bing.com/");
        connection.header("sec-ch-ua","\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"99\", \"Microsoft Edge\";v=\"99\"");
        connection.header("sec-ch-ua-mobile","?0");
        connection.header("sec-ch-ua-platform","\"Windows\"");
        connection.header("Sec-Fetch-Dest","document");
        connection.header("Sec-Fetch-Mode","navigate");
        connection.header("Sec-Fetch-Site","same-origin");
        connection.header("Sec-Fetch-User","?1");
        connection.header("Upgrade-Insecure-Requests","1");
        connection.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36 Edg/99.0.1150.36");
        connection.ignoreHttpErrors(true);
        Connection.Response response = connection.method(Connection.Method.GET).execute();
        String body = response.body();
        System.out.println(body);
    }
}
