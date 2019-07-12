import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.net.URISyntaxException;

public class VkTest {
    Vk vk;

    @BeforeEach
    void setUp() {
        vk = new Vk();
    }

    @Test
    public void postMessageTest() throws URISyntaxException, IOException {
        URIBuilder builder = vk.postMessages("Hello");
        EntityUtils.toString(vk.execute(builder).getEntity());
    }

    @Test
    public void editMessageTest() throws URISyntaxException, IOException {
        URIBuilder builder = vk.editMessages("Hello World");
        EntityUtils.toString(vk.execute(builder).getEntity());
    }

    @Test
    public void deleteMessageTest() throws URISyntaxException, IOException {
        URIBuilder builder = vk.deleteMessages();
        EntityUtils.toString(vk.execute(builder).getEntity());
    }

}
