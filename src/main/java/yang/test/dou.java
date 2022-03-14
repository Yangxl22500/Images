package yang.test;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class dou {
    public static void main(String[] args) throws Exception {
        String url = "https://v.douyin.com/JSefMcD/";
        final String videoPath = "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=";
        Connection con = Jsoup.connect(url);
        con.header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1");
        Connection.Response resp = con.method(Connection.Method.GET).execute();
        String strUrl = resp.url().toString();
        String itemId = strUrl.substring(strUrl.indexOf("video/"), strUrl.lastIndexOf("/")).replace("video/", "");
        String videoUrl = videoPath + itemId;
        String jsonStr = Jsoup.connect(videoUrl).ignoreContentType(true).execute().body();
        JSONObject json = new JSONObject(Boolean.parseBoolean(jsonStr));
        /*String videoAddress = json.getJSONArray("item_list").getJSONObject(0).getJSONObject("video").getJSONObject("play_addr").getJSONArray("url_list").get(0).toString();
        HashMap headers = MapUtil.newHashMap();
        headers.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1");
        String replace = videoAddress.replace("playwm", "play");
        System.out.println(replace);
        HttpResponse execute = HttpUtil.createGet(replace).addHeaders(headers).execute();
        String finalVideoAddress = execute.header("Location");
        downloadVideo(finalVideoAddress);*/
    }

    private static void downloadVideo(String videoAddress) throws Exception {
        int byteRead;
        try {
            URL url = new URL(videoAddress);
            //获取链接
            URLConnection conn = url.openConnection();
            //输入流
            InputStream inStream = conn.getInputStream();
            //封装一个保存文件的路径对象
            File fileSavePath = new File("d:/SanMu/1.mp4");
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
        } catch (IOException e) {
        }
    }
}
