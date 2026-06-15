import java.util.UUID;

public class Advertiser {
    private String advertiserName;
    private int budget;
    private String advertiserId;
    
    public Advertiser(String advertiserName, int budget) {
        this.advertiserName = advertiserName;
        this.budget = budget;
        this.advertiserId = UUID.randomUUID().toString().substring(6);
    }
    public String getAdvertiserName() {
        return advertiserName;
    }
    public int getBudget() {
        return budget;
    }
    public String getAdvertiserId() {
        return advertiserId;
    }

    public void deductAmount(int amount) {
        budget -= amount;
    }

}
