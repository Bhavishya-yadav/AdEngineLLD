import java.util.HashMap;
import java.util.Map;

public class AdCampaignManager {
    private Map<String, AdCampaign> campaigns;

    private AdCampaignManager campaignManager = new AdCampaignManager();

    private AdCampaignManager() {
        campaigns = new HashMap<>();
    }

    public AdCampaignManager getInstance() {
        return campaignManager;
    }

    public void addCampaigns(AdCampaign campaign) {
        campaigns.put(campaign.getCampaignId(), campaign);
    }
    
}

/*
Provide an interface to create an advertisement campaign for the advertiser.
create_campaign(advertiser_id, bid_amount, url, type, age, city, constraints)
Provide an interface to request best best-matching advertisement from the system. This should return a single advertisement per API call.
match_advertisement(user_id, city)
All the above api syntaxes are symbolic. Please design and write the method names, method parameters as per the best coding practices.
*/
