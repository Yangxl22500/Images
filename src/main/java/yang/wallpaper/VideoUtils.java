package yang.wallpaper;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Map;

public class VideoUtils {
    // 抖音火山视频
    private final static String huoShanParseUrl= "https://share.huoshan.com/api/item/info?item_id=";
    private final static String huoShanRealUrl= "http://hotsoon.snssdk.com/hotsoon/item/video/_playback/?video_id=";

    // 抖音视频
    private final static String douYinParseUrl= "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=";

    // 微视
    private final static String weiShiParseUrl= "https://h5.qzone.qq.com/webapp/json/weishi/WSH5GetPlayPage?feedid=";

    /**
     * 快手视频
     * @param url
     */
    public static String kuaiShouParseUrl(String url) {

        String redirectUrl = HttpUtil.createGet(url).addHeaders(headers()).execute().header("Location");
        String body = HttpUtil.createGet(redirectUrl).addHeaders(headers()).execute().body();
        Document doc = Jsoup.parse(body);
        Elements videoElement = doc.select("script[type=text/javascript]");
        String videoInfo = videoElement.get(3).data().replaceAll("window.pageData= ", "");

        // 获取当前视频用户信息
        JSONObject json = JSONObject.parseObject(videoInfo);
        // 获取当前视频信息
        JSONObject video = json.getJSONObject("video");
        // 无水印视频地址
        String videoUrl = video.getString("srcNoMark");

        // 截取前面的数据
        videoUrl = videoUrl.substring(0, videoUrl.indexOf("?"));
        return videoUrl;
    }

    /**
     * 抖音视频
     * @param url
     */
    public static String douYinParseUrl(String url) {
        String videoUrl = "https://www.douyin.com/video/7072232344328949023";
        try {

            /**
             *  加上/video/这个7位数
             *  获取 视频ID = 获取/video/ 和 / 中间的数据
             */
            String itemId = resp(url).split("/video/")[1].split("/")[0];

            /**
             * （固定）https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=
             *  videoUrl = 视频链接 + 视频ID
             */
            String jsonStr = Jsoup.connect(douYinParseUrl + itemId).ignoreContentType(true).execute().body();

            JSONObject obj = JSONObject.parseObject(jsonStr);

            // 获取当前的视频的真实url
            String videoAddress= obj.getJSONArray("item_list").getJSONObject(0).getJSONObject("video").getJSONObject("play_addr").getJSONArray("url_list").get(0).toString();
            /**
             * https://aweme.snssdk.com/aweme/v1/playwm/?video_id=
             * 把playwm替换成play
             */
            videoAddress = videoAddress.replaceAll("playwm", "play");

            // 该视频的原地址
            videoUrl = HttpUtil.createGet(videoAddress).addHeaders(headers()).execute().header("Location");

        }catch (Exception e){
            e.printStackTrace();
        }
        return videoUrl;
    }

    /**
     * 抖音火山视频
     * @param url
     */
    public static String huoShanParseUrl(String url) {
        String videoUrl = "";
        try {
            // 获取短视频ID
            String itemId = resp(url).split("item_id=")[1].split("&")[0];

            /**
             * （固定）https://share.huoshan.com/api/item/info?item_id=
             *  videoUrl = 视频链接 + 视频ID
             */
            String jsonStr = Jsoup.connect(huoShanParseUrl + itemId).ignoreContentType(true).execute().body();

            JSONObject obj = JSONObject.parseObject(jsonStr);

            // 获取当前的视频的真实url
            String video_url= obj.getJSONObject("data").getJSONObject("item_info").getString("url");
            String video_id = video_url.split("video_id=")[1].split("&")[0];

            // 该视频的原地址
            videoUrl = HttpUtil.createGet(huoShanRealUrl + video_id).addHeaders(headers()).execute().header("Location");

        }catch (Exception e){
            e.printStackTrace();
        }
        return videoUrl;
    }

    /**
     * 微视视频
     * @param url
     */
    public static String weiShiParseUrl(String url) {
        String videoUrl = "";
        try {

            // 获取短视频ID
            String itemId = resp(url).split("feedid=")[1].split("&")[0];

            /**
             * （固定）https://h5.qzone.qq.com/webapp/json/weishi/WSH5GetPlayPage?feedid
             *  videoUrl = 视频链接 + 视频ID
             */
            String jsonStr = Jsoup.connect(weiShiParseUrl+ itemId).ignoreContentType(true).execute().body();

            JSONObject obj = JSONObject.parseObject(jsonStr);

            // 获取当前的视频的真实url
            videoUrl= obj.getJSONObject("data").getJSONArray("feeds").getJSONObject(0).getString("video_url");

        }catch (Exception e){
            e.printStackTrace();
        }
        return videoUrl;
    }

    private static String resp(String url){
        try {
            Connection con= Jsoup.connect(url);
            con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            con.header("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
            con.header("Accept-Encoding", "gzip, deflate, sdch, br");
            con.header("Accept-Language", "zh-cn,zh;q=0.8");
            con.header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 Version/12.0 Safari/604.1");
            Connection.Response resp= con.method(Connection.Method.GET).execute();
            return con.method(Connection.Method.GET).execute().url().toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // 定义请求头
    private static Map<String, String> headers(){
        Map<String, String> headers = MapUtil.newHashMap();
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        headers.put("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
        headers.put("Accept-Encoding", "gzip, deflate, sdch, br");
        headers.put("Accept-Language", "zh-cn,zh;q=0.8");
        headers.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 Version/12.0 Safari/604.1");
        return headers;
    }

    public static void main(String[] args) {
        String url = "https://www.douyin.com/video/7072232344328949023";
        douYinParseUrl(url);
    }
}
