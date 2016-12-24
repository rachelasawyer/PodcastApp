package rachelsawyer.com.podcastapp;

import org.junit.Test;

import rachelsawyer.com.podcastapp.services.RssService;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RssServiceTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void RssService_IsNotNull() throws Exception {
        RssService service = new RssService("https://audioboom.com/channels/4829847.rss");

        assertNotNull(service);
    }

}