import java.time.LocalDate;
import java.util.List;

public class AdEngineApplication {
    public static void main(String[] args) throws Exception {
        UserManager userManager = UserManager.getInstance();

        User u1 = new User("Bhavishya", LocalDate.of(1999, 1, 15), Gender.MALE, "Rewari");
        String user1Id = u1.getUserId();

        userManager.addUser(u1);


        Advertiser adidas = new Advertiser("Adidas", 5000);
        String advertiserId = adidas.getAdvertiserId();
        AdvertiserManager advertiserManager = AdvertiserManager.getInstance();
        advertiserManager.addAdvertiser(adidas);

        AdConstraintsInterface ageConstraint = new AgeAdConstraint();
        AdCampaign campaign = new AdCampaign(advertiserId, 10, "https://adidas.com", AdType.IMAGE, 30, 25, 
        "Rewari", List.of(ageConstraint));
        AdCampaignManager adCampaignManager = AdCampaignManager.getInstance();
        adCampaignManager.addCampaigns(campaign);


        AdEngineManager adEngineManager = AdEngineManager.getInstance();

        adEngineManager.showCampaign(user1Id, campaign);
    }
}


