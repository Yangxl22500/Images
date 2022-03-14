package yang.wallpaper;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.db.Entity;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.time.LocalDateTime;

public class Main implements Runnable{

    private static String absolutePath;//视频存放路径


    @Override
    public void run() {
        while (true) {
//            System.out.println(Thread.currentThread().getId());
            try {
//                ThreadUtil.sleep(5000);
                down("https://www.douyin.com/user/MS4wLjABAAAAlrxZwarwD9gjtqlJ4QSnh14jSEIF2DjDjm88ltrrfRQ");//开始下载
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("******************************************************************");
        System.err.println("欢迎使用抖音视频下载工具，如有问题请加QQ群交流：317896269");
        System.err.println("可以爬到抖音的作者信息，音乐信息，视频信息，图片信息等等，这里只下载了视频，其他信息以json形式打印了出来，需要的请自主存库！");
        System.err.println("源代码地址在GitHub欢迎下载：https://github.com/liupeng328/GetDouYin");
        System.err.println("该版本为单机版，如需要分布式部署，商业级软件，请加QQ群，另外获取最新版本请关注GitHub或QQ群！");
        System.err.println("开始抓取数据……");
        absolutePath = FileUtil.getAbsolutePath(new File(""));
        absolutePath = absolutePath + File.separator + "下载到的视频" + File.separator;
        System.err.println("下载到的视频存放路径为： " + absolutePath);
        //多线程下载
        ThreadUtil.execute(new Main());
//        ThreadUtil.execute(new Main());
    }

    /**
     * 下载视频
     */
    private static void down(String url) {
        String body = HttpRequest.get(url).header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36").execute().body();
        System.out.println(body);
        JSONObject json = JSONUtil.parseObj(body);
        //System.out.println(JSONUtil.formatJsonStr(body));
        //抽取数据 响应数据详细解析见： doc/抖音视频列表接口分析.json
        JSONArray list = json.getJSONArray("aweme_list");
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                JSONObject object = list.getJSONObject(i);
                //作者信息
                JSONObject authorJson = object.getJSONObject("author");
                String authorId = authorJson.getStr("uid");
                if (authorJson != null) {
                    Entity author = Entity.create("author")
                            .set("uid", authorJson.getStr("uid"))//id
                            .set("short_id", authorJson.getStr("short_id"))//短id
                            .set("nickname", authorJson.getStr("nickname"))//昵称
                            .set("gender", authorJson.getStr("gender"))//性别
//                            .set("signature", authorJson.getStr("signature"))//个性签名
                            //头像图片uri 唯一标示 保存最大分辨率的那个
                            .set("avatar_larger_uri", authorJson.getJSONObject("avatar_larger") == null ? null :
                                    authorJson.getJSONObject("avatar_larger").getStr("uri"))
                            //头像图片url 主机+uri 保存最大分辨率的那个
                            .set("avatar_larger_url_list", authorJson.getJSONObject("avatar_larger") == null ? null :
                                    authorJson.getJSONObject("avatar_larger").getJSONArray("url_list") == null ? null :
                                            authorJson.getJSONObject("avatar_larger").getJSONArray("url_list").getStr(0))
                            .set("birthday", authorJson.getStr("birthday"));//生日
                    System.out.println("作者信息： " + JSONUtil.formatJsonStr(JSONUtil.toJsonStr(author)));
                }


                //音频信息
                JSONObject musicJson = object.getJSONObject("music");
                if (musicJson != null) {
                    Entity music = Entity.create("music")
                            .set("uid", musicJson.getStr("id"))//id
                            .set("title", musicJson.getStr("title"))//标题
                            .set("author", musicJson.getStr("author"))//作者
                            .set("album", musicJson.getStr("album"))//专辑
                            //音乐uri 唯一标识 只保留最大的那个
                            .set("play_url_uri", musicJson.getJSONObject("play_url") == null ? null :
                                    musicJson.getJSONObject("play_url").getStr("uri"))
                            //音乐url
                            .set("play_url_url_list", musicJson.getJSONObject("play_url") == null ? null :
                                    musicJson.getJSONObject("play_url").getJSONArray("url_list") == null ? null :
                                            musicJson.getJSONObject("play_url").getJSONArray("url_list").getStr(0))
                            //高清图uri 唯一标识 只保留最大的那张
                            .set("cover_hd_uri", musicJson.getJSONObject("cover_hd") == null ? null :
                                    musicJson.getJSONObject("cover_hd").getStr("uri"))
                            //高清图url 只存最大的图
                            .set("cover_hd_url_list", musicJson.getJSONObject("cover_hd") == null ? null :
                                    musicJson.getJSONObject("cover_hd").getJSONArray("url_list") == null ? null :
                                            musicJson.getJSONObject("cover_hd").getJSONArray("url_list").getStr(0));
                    System.out.println("背景音乐信息： " + JSONUtil.formatJsonStr(JSONUtil.toJsonStr(music)));

                }

                //视频信息
                JSONObject videoJson = object.getJSONObject("video");
                if (videoJson != null) {
                    Entity video = Entity.create("video")
                            .set("author_id", authorId)
                            //视频uri 唯一标识 只保留最高清的那个
                            .set("uid", videoJson.getJSONObject("play_addr") == null ? null :
                                    videoJson.getJSONObject("play_addr").getStr("uri"))
                            //高清视频url 只存最高清那个
                            .set("play_addr_url_list", videoJson.getJSONObject("play_addr") == null ? null :
                                    videoJson.getJSONObject("play_addr").getJSONArray("url_list") == null ? null :
                                            getUrl(videoJson.getJSONObject("play_addr").getJSONArray("url_list")))
                            //动态图uri 唯一标识 只保留最高清的那个
                            .set("dynamic_cover_uri", videoJson.getJSONObject("dynamic_cover") == null ? null :
                                    videoJson.getJSONObject("dynamic_cover").getStr("uri"))
                            //动态图uil 只存最高清那个
                            .set("dynamic_cover_url_list", videoJson.getJSONObject("dynamic_cover") == null ? null :
                                    videoJson.getJSONObject("dynamic_cover").getJSONArray("url_list") == null ? null :
                                            videoJson.getJSONObject("dynamic_cover").getJSONArray("url_list").getStr(0))
                            //视频封面图uri 唯一标识 只保留最高清的那个
                            .set("origin_cover_uri", videoJson.getJSONObject("origin_cover") == null ? null :
                                    videoJson.getJSONObject("origin_cover").getStr("uri"))
                            //视频封面图uil 只存最高清那个
                            .set("origin_cover_url_list", videoJson.getJSONObject("origin_cover") == null ? null :
                                    videoJson.getJSONObject("origin_cover").getJSONArray("url_list") == null ? null :
                                            videoJson.getJSONObject("origin_cover").getJSONArray("url_list").getStr(0));
                    ;
                    System.out.println("视频信息： " + JSONUtil.formatJsonStr(JSONUtil.toJsonStr(video)));

                    //下载视频
//                    HttpResponse response = HttpRequest.get(video.getStr("play_addr_url_list")).execute();
//                    if (response.getStatus() == 302) {
//                        String location = response.header("location");
//                        HttpUtil.downloadFile(location, absolutePath + video.getStr("dynamic_cover_uri") + ".mp4");
//                        System.err.println(absolutePath + video.getStr("dynamic_cover_uri") + ".mp4" + "下载成功！！！");
//                    } else {
//                        HttpUtil.downloadFile(video.getStr("play_addr_url_list"), absolutePath + video.getStr("dynamic_cover_uri") + ".mp4");
//                    }

                }

            }
        } else {
            System.err.println("休息5分钟再试 当前时间： " + LocalDateTime.now());
            ThreadUtil.sleep(1000 * 60 * 5);//休息5分钟再试
        }


    }


    /**
     * 获得url列表中可以浏览器访问的那个url
     * 即：包含api.amemv.com 信息的url
     *
     * @param jsonArray
     * @return
     */
    private static String getUrl(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.size(); i++) {
            if (jsonArray.getStr(i).contains("api.amemv.com")) {
                return jsonArray.getStr(i);
            }
        }
        return null;
    }

}
