import java.time.LocalDate;
import java.util.List;

public class AdEngineApplication {
    public static void main(String[] args) throws Exception {
        UserManager userManager = UserManager.getInstance();

        User u1 = new User("Bhavishya", LocalDate.of(1999, 1, 15), Gender.MALE, "Rewari");
        String user1Id = u1.getUserId();
        userManager.addUser(u1);

        User u2 = new User("Pintu", LocalDate.of(2000, 3, 18), Gender.MALE, "Rewari");
        String user2Id = u2.getUserId();
        userManager.addUser(u2);

        User u3 = new User("Ankit", LocalDate.of(2000, 4, 2), Gender.MALE, "Rewari");
        String user3Id = u3.getUserId();
        userManager.addUser(u3);

        User u4 = new User("Vipin", LocalDate.of(2000, 12, 12), Gender.MALE, "Rewari");
        String user4Id = u4.getUserId();
        userManager.addUser(u4);

        User u5 = new User("Himanshu", LocalDate.of(2000, 2, 22), Gender.MALE, "Rewari");
        String user5Id = u5.getUserId();
        userManager.addUser(u5);

        User u6 = new User("Varadraj", LocalDate.of(2000, 8, 9), Gender.MALE, "Bengaluru");
        String user6Id = u6.getUserId();
        userManager.addUser(u6);


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
        adEngineManager.showCampaign(user2Id, campaign);
        adEngineManager.showCampaign(user3Id, campaign);
        adEngineManager.showCampaign(user4Id, campaign);
        adEngineManager.showCampaign(user5Id, campaign);
        
        Thread.sleep(66_000);
        adEngineManager.showCampaign(user6Id, campaign);
        
    }
}


