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
        String url = "https://www.douyin.com/aweme/v1/web/aweme/post/?device_platform=webapp&aid=6383&channel=channel_pc_web&sec_user_id=MS4wLjABAAAAViovMw_TvOh5CvYZaEtj4th6nb8DiDakONVPWygGi4k&max_cursor=1647188319000&locate_query=false&count=10&publish_video_strategy_type=2&version_code=170400&version_name=17.4.0&cookie_enabled=true&screen_width=1536&screen_height=864&browser_language=zh-CN&browser_platform=Win32&browser_name=Edge&browser_version=99.0.1150.39&browser_online=true&engine_name=Blink&engine_version=99.0.4844.51&os_name=Windows&os_version=10&cpu_core_num=12&device_memory=8&platform=PC&downlink=10&effective_type=4g&round_trip_time=50&webid=7073303726223967777&msToken=NkvbpoNMZjYdSr060736mNW26k3snLtT4XJ06ECq1x2AP_HZWKdPOvas7AT5NnIEQHHpscwtmCvgdz6TbEJcViIgcP-6TSoeggo0_w5tli6RX9977Yb2-i8=&X-Bogus=DFSzsdVEcSGANCdbS2Yz1KXAIQ22&_signature=_02B4Z6wo00001RSdffwAAIDAd5e9lpYdk6kUmXlAACcMG8N7qYBQJKLobJN58IBX34aS-XZjLSYzIosOJRHADgrc39AF.c1Cfi-1SSmFCt.gkZZRTUdkTDjd7Crz9JnEoDAR3Ot0oK9YPFkP1b";
        Connection connection = Jsoup.connect(url);
        connection.header(":authority","www.douyin.com");
        connection.header(":method","GET");
        connection.header(":path","/aweme/v1/web/aweme/post/?device_platform=webapp&aid=6383&channel=channel_pc_web&sec_user_id=MS4wLjABAAAAViovMw_TvOh5CvYZaEtj4th6nb8DiDakONVPWygGi4k&max_cursor=1647188319000&locate_query=false&count=10&publish_video_strategy_type=2&version_code=170400&version_name=17.4.0&cookie_enabled=true&screen_width=1536&screen_height=864&browser_language=zh-CN&browser_platform=Win32&browser_name=Edge&browser_version=99.0.1150.39&browser_online=true&engine_name=Blink&engine_version=99.0.4844.51&os_name=Windows&os_version=10&cpu_core_num=12&device_memory=8&platform=PC&downlink=10&effective_type=4g&round_trip_time=50&webid=7073303726223967777&msToken=NkvbpoNMZjYdSr060736mNW26k3snLtT4XJ06ECq1x2AP_HZWKdPOvas7AT5NnIEQHHpscwtmCvgdz6TbEJcViIgcP-6TSoeggo0_w5tli6RX9977Yb2-i8=&X-Bogus=DFSzsdVEcSGANCdbS2Yz1KXAIQ22&_signature=_02B4Z6wo00001RSdffwAAIDAd5e9lpYdk6kUmXlAACcMG8N7qYBQJKLobJN58IBX34aS-XZjLSYzIosOJRHADgrc39AF.c1Cfi-1SSmFCt.gkZZRTUdkTDjd7Crz9JnEoDAR3Ot0oK9YPFkP1b");
        connection.header(":scheme","https");
        connection.header("accept","application/json, text/plain, */*");
        connection.header("accept-encoding","gzip, deflate, br");
        connection.header("accept-language","zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
        connection.header("cookie","ttcid=5257ad6920e6435cb8bf787be0a542c912; ttwid=1%7CsfhZEOzaH2lVYWWp4u9ojZONpoBrYqtgFGmS8o2y36A%7C1646881869%7C296e40c4de24bb2e23bc1bb74083576855218ad537d38405ee6fca646cc097f9; MONITOR_DEVICE_ID=ca6e0ce8-50c2-4934-89f7-8d38602985bc; MONITOR_WEB_ID=c79038d5-d342-46f2-bc6c-3279fe8855f4; _tea_utm_cache_6383=undefined; _tea_utm_cache_1300=undefined; MONITOR_WEB_ID=b3728c6e-256d-49e6-8cbd-91bc0fc29cd6; passport_csrf_token_default=f6b15c84c326c8a0875a5c020d289a95; passport_csrf_token=f6b15c84c326c8a0875a5c020d289a95; _tea_utm_cache_2285=undefined; pwa_guide_count=3; THEME_STAY_TIME=299311; IS_HIDE_THEME_CHANGE=1; _tea_utm_cache_2018=undefined; strategyABtestKey=1647234037.114; s_v_web_id=verify_l0q8m61o_7hHLxvl8_7Q9H_4Hiu_Bkxy_srPW0uoPf9aM; AB_LOGIN_GUIDE_TIMESTAMP=1647234037045; DOUYIN_WEB_HIDE_IM_LOGIN_GUIDE=1; _tea_utm_cache_1243=undefined; msToken=Z-zpmWggiSZQ7svfvQZCcc5XQuXnhVHSbQ58Bh-dNKLu2TI44iKSUXa8zgBMKxAYYSctoxnJxGB77jRuHOwsNKuJW2C1SdYeNZt210W05Y5D59-IBbHhRv8=; douyin.com; __ac_nonce=0622ee66f00ec3e3f2151; __ac_signature=_02B4Z6wo00f012ZAZRQAAIDCBUqlf2ha5hNmZGGAALvKe0ElkgHMNogrLc6MZCfGrpA12QUn0MDE9-SyR4lHKXj8YTuSW9S6o6nZHh2tI9gtw9fGjdYgn26TEQXJIOeuniZelnaAYnaiWTldcd; home_can_add_dy_2_desktop=1; msToken=NkvbpoNMZjYdSr060736mNW26k3snLtT4XJ06ECq1x2AP_HZWKdPOvas7AT5NnIEQHHpscwtmCvgdz6TbEJcViIgcP-6TSoeggo0_w5tli6RX9977Yb2-i8=; tt_scid=NzVUcD2w5BRLmJhFh2GFeODM-7l3SRjIi02uxG3THi40yd3W5QifXzIPsrnfY7S-07a8");
        connection.header("referer","https://www.douyin.com/user/MS4wLjABAAAAViovMw_TvOh5CvYZaEtj4th6nb8DiDakONVPWygGi4k");
        connection.header("sec-ch-ua","\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"99\", \"Microsoft Edge\";v=\"99\"");
        connection.header("sec-ch-ua-mobile","?0");
        connection.header("sec-ch-ua-platform","\"Windows\"");
        connection.header("sec-fetch-dest","");
        connection.header("sec-fetch-dest","empty");
        connection.header("sec-fetch-mode","cors");
        connection.header("sec-fetch-site","same-origin");
        connection.header("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36 Edg/99.0.1150.39");
        connection.ignoreHttpErrors(true);
        Connection.Response response = connection.method(Connection.Method.GET).execute();
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
