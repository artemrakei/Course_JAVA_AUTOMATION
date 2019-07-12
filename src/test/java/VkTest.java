import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.net.URISyntaxException;

public class VkTest {
    private static final Logger log = Logger.getLogger(Vk.class);
    Vk vk;
    private static String post_id;




@BeforeTest
    void setUp() {
        vk = new Vk();
    }


    @Test (priority = 1)
    public void postMessageTest() throws URISyntaxException, IOException {
        log.info("It's information message");
        URIBuilder builder = vk.postMessages("Hello");
        EntityUtils.toString(vk.execute(builder).getEntity());
        post_id=vk.post_id;
        System.out.println(post_id);
    }
    @Test (priority = 2)
    public void editMessageTest() throws URISyntaxException, IOException {
        log.warn("Maybe this will not work");
        System.out.println(post_id);
        URIBuilder builder = vk.editMessages("Hello World",post_id);
        EntityUtils.toString(vk.execute(builder).getEntity());

    }
    @Test (priority = 3)
    public void deleteMessageTest() throws URISyntaxException, IOException {
        log.error("But you should try running it");
        log.fatal("As you see nothing happened");
        System.out.println(post_id);
        URIBuilder builder = vk.deleteMessages(post_id);
        EntityUtils.toString(vk.execute(builder).getEntity());

    }




}
