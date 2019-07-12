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

    public URIBuilder createBasicURL(String methodName) throws URISyntaxException {
        String urlName = String.format("https://api.vk.com/method/wall.%s?", methodName);
        builder = new URIBuilder(urlName);
        builder.setParameter("accaes_token", "ab8635bef89a032945d71e4d69c0ba9d01dda78907b3714ec860dc518ea352d25c0c5350a46036f5167da")
                .setParameter("owner_id", "552470481")
                .setParameter("v", "5.101");
        return builder;
    }

    public URIBuilder postMessages(String message) throws URISyntaxException {
        URIBuilder builder = createBasicURL("post");
        builder.setParameter("message", message);
        return builder;
    }

    public URIBuilder editMessages(String message) throws URISyntaxException {
        URIBuilder builder = createBasicURL("edit");
        builder.setParameter("post_id", post_id);
        builder.setParameter("message", message);
        return builder;
    }

    public URIBuilder deleteMessages() throws URISyntaxException {
        URIBuilder builder = createBasicURL("delete");
        builder.setParameter("post_id", post_id);
        return builder;
    }

    public HttpResponse execute(URIBuilder builder) throws URISyntaxException, IOException {
        HttpGet request = new HttpGet(builder.build());
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        post_id = result.substring(23, 26);
        return client.execute(request);
    }
}
