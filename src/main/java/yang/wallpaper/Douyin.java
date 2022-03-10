package yang.wallpaper;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class Douyin {
    //视频链接(固定)
    private static final String videoPath="https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=";
    //视频保存目录
    private static final String videoSavePath="E:\\Reptile\\";
    //分享链接（手动修改）
    private static String targetPath = "2.00 jpQ:/ 敢这样对待女教官的人也就只有他何晨光了！  https://v.douyin.com/NjhTkQ1/ 复制此链接，打开Dou音搜索，直接观看视频！";

    public static void main(String[] args) throws IOException {
        Connection con= Jsoup.connect(filterUrl(targetPath));
        con.header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 Version/12.0 Safari/604.1");
        Connection.Response resp=con.method(Connection.Method.GET).execute();
        String videoUrl= videoPath+getItemId(resp.url().toString());
        System.out.println(videoUrl);
        String jsonStr = Jsoup.connect(videoUrl).ignoreContentType(true).execute().body();
        JSONObject json =JSONObject.parseObject(jsonStr);
        String videoAddress= json.getJSONArray("item_list").getJSONObject(0).getJSONObject("video").getJSONObject("play_addr").getJSONArray("url_list").get(0).toString();
        System.out.println(videoAddress);
        String title= json.getJSONArray("item_list").getJSONObject(0).getJSONObject("share_info").getString("share_title");
//        videoAddress=videoAddress.replaceAll("playwm","play");
//        HashMap<String, String> headers = MapUtil.newHashMap();
//        headers.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 Version/12.0 Safari/604.1");
//        String finalVideoAddress = HttpUtil.createGet(videoAddress).addHeaders(headers).execute().header("Location");

        //注:打印获取的链接
//        System.out.println("-----抖音去水印链接-----\n"+finalVideoAddress );
//        //下载无水印视频到本地
//        downVideo(finalVideoAddress,title);
    }
    /**
     * 方法描述: 下载无水印视频方法
     *
     * @param httpUrl
     * @param title
     * @author tarzan
     * @date 2020年08月04日 10:34:09
     */
    public static void downVideo(String httpUrl,String title) {
        String fileAddress = videoSavePath+title+".mp4";
        int byteRead;
        try {
            URL url = new URL(httpUrl);
            //获取链接
            URLConnection conn = url.openConnection();
            //输入流
            InputStream inStream = conn.getInputStream();
            //封装一个保存文件的路径对象
            File fileSavePath = new File(fileAddress);
            //注:如果保存文件夹不存在,那么则创建该文件夹
            File fileParent = fileSavePath.getParentFile();
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }
            //写入文件
            FileOutputStream fs = new FileOutputStream(fileSavePath);
            byte[] buffer = new byte[1024];
            while ((byteRead = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteRead);
            }
            inStream.close();
            fs.close();
            System.out.println("\n-----视频保存路径-----\n"+fileSavePath.getAbsolutePath());
        } catch (FileNotFoundException e) {
//            log.error(e.getMessage());
        } catch (IOException e) {
//            log.error(e.getMessage());
        }
    }
    /**
     * 方法描述: 获取分享视频id
     *
     * @param url
     * @Return {@link String}
     * @author tarzan
     * @date 2020年08月03日 17:36:12
     */
    public static String getItemId(String url){
        int start = url.indexOf("/video/")+7;
        int end = url.lastIndexOf("/");
        String itemId = url.substring(start, end);
        return  itemId;
    }
    /**
     * 方法描述: 过滤分享链接的中文汉字
     *
     * @param url
     * @Return {@link String}
     * @author tarzan
     * @date 2020年08月03日 17:36:33
     */
    public static String filterUrl(String url) {
        int start = url.indexOf("http");
        int end = url.lastIndexOf("/");
        String filterUrl = url.substring(start, end);
        return filterUrl;
    }
}
