package yang;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class WangYiYun {
    public static void main(String[] args) throws Exception {
        URL target = new URL("http://m704.music.126.net/20220308103447/71cf0636bfe11203a3b13482df950f7b/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/11469317931/864c/c7b6/9bda/106f0bd35b4093405c498985bfba3ae7.m4a?authSecret=0000017f674a27ac1ab70aaba4fe2232");
        URLConnection urlConnection = target.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        OutputStream outputStream = new FileOutputStream("E:\\Reptile\\Images\\" + "sahnleba" + ".m4a");
        int temp = 0;
        while ((temp = inputStream.read()) != -1){
            outputStream.write(temp);
        }
        outputStream.close();
        inputStream.close();
    }
}
