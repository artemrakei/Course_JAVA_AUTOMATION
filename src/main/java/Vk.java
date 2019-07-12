import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;


public class Vk {
    private URIBuilder builder;
   public String post_id;



    //+375292538629
    // ct6aLKjayVXZstU
//    public static void main( String[] args ) throws IOException, URISyntaxException
//    {
//        HttpClient client = HttpClientBuilder.create().build();
//        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post?");
//        builder.setParameter("access_token", "a514cb82bf1bad069a6df42e7289dfb9e8f584bfeb78ba7c22515785ce09e8b75333bfc8a59ad896a4e8b")
//                .setParameter("owner_id", "552470481")
//                .setParameter("message", "Hello")
//                .setParameter("v", "5.101");
//        HttpGet request = new HttpGet(builder.build());
//        HttpResponse response = client.execute(request);
//        System.out.println(EntityUtils.toString(response.getEntity()));
//    }


    public HttpResponse execute(URIBuilder builder) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        post_id = result.replaceAll("[^0-9]", "");
        System.out.println(post_id);

        return client.execute(request);
    }
    public URIBuilder createBasicURL(String methodName) throws URISyntaxException {

        String urlName = String.format("https://api.vk.com/method/wall.%s?", methodName);
        builder = new URIBuilder(urlName);
        builder.setParameter("owner_id", "552470481")
                .setParameter("access_token", "d8752845fb8e3859cdc1e01736cc51bed955b6c6ed4f2bbee347e6970e5b7e29e7a35a19383feded33ea8")
                .setParameter("v", "5.101");
        return builder;
    }


    public URIBuilder postMessages(String message) throws URISyntaxException {
        builder = createBasicURL("post");

        builder.setParameter("message", message);

        return builder;
    }

    public URIBuilder editMessages(String message, String param) throws URISyntaxException {

        builder = createBasicURL("edit");
        builder.setParameter("post_id", param);
        builder.setParameter("message", message);

        return builder;
    }

    public URIBuilder deleteMessages(String param) throws URISyntaxException {
        builder = createBasicURL("delete");
        builder.setParameter("post_id", param);

        return builder;
    }


}
