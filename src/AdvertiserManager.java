import java.util.HashMap;
import java.util.Map;

public class AdvertiserManager {
    private Map<String, Advertiser> advertisers;
    private static AdvertiserManager instance = new AdvertiserManager();

    private AdvertiserManager() {
        advertisers = new HashMap<>();
    }

    public static AdvertiserManager getInstance() {
        return instance;
    }

    public void addAdvertiser(Advertiser advertiser) {
        advertisers.put(advertiser.getAdvertiserId(), advertiser);
    }

    public Advertiser getAdvertiserById(String advertiserId) {
        return advertisers.get(advertiserId);
    }
}
