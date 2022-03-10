package yang.test;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientTest {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://www.kuaishou.com/graphql");
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String s = EntityUtils.toString(response.getEntity());
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
