package yang.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class json {
    public static void main(String[] args) {

        tests();
    }

    public static void tests(){

        String s = "[" +
                "{\n" +
                "    \"type\": 1,\n" +
                "    \"author\": {\n" +
                "        \"id\": \"3xtcvbmfitzkba9\",\n" +
                "        \"name\": \"你的菲哥.\",\n" +
                "        \"following\": false,\n" +
                "        \"headerUrl\": \"https://p5.a.yximgs.com/uhead/AB/2020/07/12/18/BMjAyMDA3MTIxODQ5MTVfMjc5ODc0NjU1XzFfaGQxMjRfODkx_s.jpg\",\n" +
                "        \"headerUrls\": null,\n" +
                "        \"__typename\": \"Author\"\n" +
                "    },\n" +
                "    \"tags\": null,\n" +
                "    \"photo\": {\n" +
                "        \"id\": \"3x88ie2upkyqj7w\",\n" +
                "        \"duration\": 14700,\n" +
                "        \"caption\": \"不要和别人去完成我们未完成的约定.\",\n" +
                "        \"likeCount\": \"2227\",\n" +
                "        \"realLikeCount\": 2227,\n" +
                "        \"coverUrl\": \"https://p1.a.yximgs.com/upic/2022/03/01/20/BMjAyMjAzMDEyMDI3MTNfMjc5ODc0NjU1XzY4Njg3MTQ3NjE1XzFfMw==_Bf1c2f7d5c5dc258e7b35d2bea006b3d8.jpg?tag=1-1646893949-xpcwebprofile-0-kxllhjbhc8-83144431845d40d6&clientCacheKey=3x88ie2upkyqj7w.jpg&di=b7a2e6fe&bp=14734\",\n" +
                "        \"coverUrls\": null,\n" +
                "        \"photoUrls\": [\n" +
                "            {\n" +
                "                \"cdn\": \"v1.kwaicdn.com\",\n" +
                "                \"url\": \"https://v1.kwaicdn.com/upic/2022/03/01/20/BMjAyMjAzMDEyMDI3MTNfMjc5ODc0NjU1XzY4Njg3MTQ3NjE1XzFfMw==_b_B7a08ea299d414429ae189abc90b446f1.mp4?pkey=AAVo0GVmyDZvdTPOKT4sqRBPGE7qVUSrcmgu7YI_eiCumS6rTgNsK8EIFagrNCO4MpBcSLYPmgTyACLVbC1l0UyBuQ8qmQTygiYnEtwOlMpEVm3tWZYI5X6AQNx_uTvbYs4&tag=1-1646893949-xpcwebprofile-0-ksavzxvrux-acf8ce9a22a77526&clientCacheKey=3x88ie2upkyqj7w_b.mp4&tt=b&di=b7a2e6fe&bp=14734\",\n" +
                "                \"__typename\": \"Url\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cdn\": \"v2.kwaicdn.com\",\n" +
                "                \"url\": \"https://v2.kwaicdn.com/upic/2022/03/01/20/BMjAyMjAzMDEyMDI3MTNfMjc5ODc0NjU1XzY4Njg3MTQ3NjE1XzFfMw==_b_B7a08ea299d414429ae189abc90b446f1.mp4?pkey=AAXSDz19dpsggwYGLhUI0uq21Wq8tymQIkzbBeWV9odDI-d_zWkTVEVObEC1GvYkWKKkM5sSZoy_Oti_iBlq2XhXr3rIuWa5_8gSAW2VhCOZmO3iI-F5asSjlJ0WIdv6dVE&tag=1-1646893949-xpcwebprofile-1-wmib23deth-4870c1ee765ce15a&clientCacheKey=3x88ie2upkyqj7w_b.mp4&tt=b&di=b7a2e6fe&bp=14734\",\n" +
                "                \"__typename\": \"Url\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"photoUrl\": \"https://v1.kwaicdn.com/upic/2022/03/01/20/BMjAyMjAzMDEyMDI3MTNfMjc5ODc0NjU1XzY4Njg3MTQ3NjE1XzFfMw==_b_B7a08ea299d414429ae189abc90b446f1.mp4?pkey=AAVo0GVmyDZvdTPOKT4sqRBPGE7qVUSrcmgu7YI_eiCumS6rTgNsK8EIFagrNCO4MpBcSLYPmgTyACLVbC1l0UyBuQ8qmQTygiYnEtwOlMpEVm3tWZYI5X6AQNx_uTvbYs4&tag=1-1646893949-xpcwebprofile-0-ksavzxvrux-acf8ce9a22a77526&clientCacheKey=3x88ie2upkyqj7w_b.mp4&tt=b&di=b7a2e6fe&bp=14734\",\n" +
                "        \"liked\": false,\n" +
                "        \"timestamp\": 1646137658334,\n" +
                "        \"expTag\": \"1_i/2001203857046738306_xpcwebprofilexxnull0\",\n" +
                "        \"animatedCoverUrl\": \"https://p1.a.yximgs.com/upic/2022/03/01/20/BMjAyMjAzMDEyMDI3MTNfMjc5ODc0NjU1XzY4Njg3MTQ3NjE1XzFfMw==_animatedV5_Bf333c1b3941561bbc0caa886f98929bc.webp?tag=1-1646893949-xpcwebprofile-0-bfou0xojlk-2d11560fa11e3227&clientCacheKey=3x88ie2upkyqj7w_animatedV5.webp&di=b7a2e6fe&bp=14734\",\n" +
                "        \"stereoType\": 0,\n" +
                "        \"videoRatio\": 0.5625,\n" +
                "        \"profileUserTopPhoto\": null,\n" +
                "        \"__typename\": \"PhotoEntity\"\n" +
                "    },\n" +
                "    \"canAddComment\": 0,\n" +
                "    \"currentPcursor\": \"\",\n" +
                "    \"llsid\": \"2001203857046738306\",\n" +
                "    \"status\": 1,\n" +
                "    \"__typename\": \"Feed\"\n" +
                "}"
                + "]";

        JSONArray jsonarryA = JSON.parseArray(s);



//        JSONObject jsonarryb = JSON.parseObject(s);
        Set set = new HashSet();
        set.addAll(jsonarryA);
        JSONArray jsonarrys = JSON.parseArray(set.toString());
        JSONObject jsonObject = jsonarrys.getJSONObject(0);
        Set set1 = new HashSet();
        set1.addAll(jsonarrys);
        JSONArray jsonarryt = JSON.parseArray(set1.toString());
        Set set2 = new HashSet();
        Object photo = jsonObject.get("photo");
        set2.addAll(Collections.singleton(photo));
        JSONArray jsonarryp = JSON.parseArray(set2.toString());
        JSONObject jsonObjecqq = jsonarryp.getJSONObject(0);
        Object jsonOb = jsonObjecqq.get("photoUrl");
        System.out.println(jsonOb);
        System.out.println(jsonarryt);
        System.out.println(jsonObject);
//        jsonarryb.get("photo");
    }
}
