import java.util.List;
import java.util.UUID;

public class AdCampaign {
    // (advertiser_id, bid_amount, url, type, age, city, constraints)
    private String campaignId;
    private String advertiserId;
    private int bidAmount;
    private String url;
    private AdType type;
    private int maxAge;
    private int minAge;
    private String city;
    private List<AdConstraintsInterface> constraints;

    public AdCampaign(String advertiserId, int bidAmount, String url, AdType type, int maxAge, int minAge,
            String city, List<AdConstraintsInterface> constraints) {
        this.advertiserId = advertiserId;
        this.bidAmount = bidAmount;
        this.url = url;
        this.type = type;
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.city = city;
        this.campaignId = UUID.randomUUID().toString().substring(6);
        this.constraints = constraints;
    }

    public String getCampaignId() {
        return campaignId;
    }
    public String getAdvertiserId() {
        return advertiserId;
    }
    public int getBidAmount() {
        return bidAmount;
    }
    public String getUrl() {
        return url;
    }
    public AdType getType() {
        return type;
    }
    public int getMaxAge() {
        return maxAge;
    }
    public int getMinAge() {
        return minAge;
    }
    public String getCity() {
        return city;
    }

    public List<AdConstraintsInterface> getConstraints() {
        return constraints;
    }
    
}
