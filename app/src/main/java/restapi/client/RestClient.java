//package restapi.client;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.hc.client5.http.classic.methods.HttpGet;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
//import org.apache.hc.client5.http.impl.classic.HttpClients;
//import org.apache.hc.core5.http.ClassicHttpResponse;
//import org.apache.hc.core5.http.Header;
//import org.apache.hc.core5.http.HttpException;
//import org.apache.hc.core5.http.io.HttpClientResponseHandler;
//import org.apache.hc.core5.http.io.entity.EntityUtils;
//import org.json.JSONObject;
//
//public class RestClient {
//
//    public <T> void get(String url) throws IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet getRequest = new HttpGet(url);
//        httpClient.execute(getRequest, new HttpClientResponseHandler<T>() {
//
//            @Override
//            public T handleResponse(ClassicHttpResponse response) throws HttpException, IOException {
//                // Status Code
//                response.getCode();
//
//                // Resonse
//                String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//                JSONObject responseJson = new JSONObject(responseString);
//
//                // Headers
//                Header[] headers = (Header[]) response.getHeaders();
//                Map<String, String> headersMap = new HashMap<>();
//                for(Header header: headers) {
//                    headersMap.put(header.getName(), header.getValue());
//                }
//                return null;
//            }
//
//        });
//    }
//
//}
