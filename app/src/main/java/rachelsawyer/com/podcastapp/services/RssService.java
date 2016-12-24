package rachelsawyer.com.podcastapp.services;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Rachel on 12/23/2016.
 */

public class RssService {
    private final URL url;

    public RssService(String feedUrl) {
        try {
            this.url = new URL(feedUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReadRss () {

    }
}
