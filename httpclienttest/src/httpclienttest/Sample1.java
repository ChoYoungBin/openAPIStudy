package httpclienttest;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class Sample1 {
    public static void main(String[] args) throws IOException {
        HttpGet httpGet = new HttpGet("http://10.4.3.100:8080/contacts");
        httpGet.setHeader("Accept", "application/json");

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            BasicResponseHandler handler = new BasicResponseHandler();
            String body = handler.handleResponse(response);
            System.out.println("ResponseBody = " + body);
        } else {
            System.out.println("Error StatusCode = " + response.getStatusLine().getStatusCode());
        }
    }
}
