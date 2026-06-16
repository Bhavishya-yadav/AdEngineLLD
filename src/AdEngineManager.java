import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AdEngineManager {
    
    private UserManager userManager;

    private AdvertiserManager advertiserManager;

    private final int maxUserLimit = 10;

    private final int globalLimit = 5;

    private final int windowSideInMinutes = 1;

    private Map<String, Queue<String>> userHistory; // userID -> Queue<Ad>

    private Map<String, Queue<LocalTime>> globalHistory; // adcampaignId -> time

    private static AdEngineManager adEngineManager = new AdEngineManager();

    private AdEngineManager() {
        userManager = UserManager.getInstance();
        advertiserManager = AdvertiserManager.getInstance();
        userHistory = new HashMap<>();
        globalHistory = new HashMap<>();
    }

    public static AdEngineManager getInstance() {
        return adEngineManager;
    }

    public void showCampaign(String userId, AdCampaign campaign) throws Exception {
        User user = userManager.getUserById(userId);
        String campaignId = campaign.getCampaignId();
        List<AdConstraintsInterface> constraints = campaign.getConstraints();
        if(user == null)
            throw new Exception("User doesn't exist");

        if(constraints.stream().allMatch(constraint -> constraint.shouldShowAd(user, campaign))) {
            Queue<String> userHistoryQueue = userHistory.getOrDefault(userId, new LinkedList<>());
            boolean condition1 = !userHistoryQueue.contains(campaignId);

            Queue<LocalTime> globalHistoryQueue = globalHistory.getOrDefault(campaignId, new LinkedList<>());
            boolean condition2 = globalHistoryQueue.size() < 5;
            LocalTime currTime = LocalTime.now();
            LocalTime windowStartTime = currTime.minusMinutes(windowSideInMinutes);
            while(!globalHistoryQueue.isEmpty() && globalHistoryQueue.size() == globalLimit) {
                LocalTime front = globalHistoryQueue.peek();
                if(front.isBefore(windowStartTime)) {
                    globalHistoryQueue.poll();
                    condition2 = true;
                } else {
                    condition2 = false;
                    break;
                }
            }
            Advertiser advertiser = advertiserManager.getAdvertiserById(campaign.getAdvertiserId());
            if(condition2 && condition1 && advertiser.getBudget() >= campaign.getBidAmount()) {
                userHistory.putIfAbsent(userId, new LinkedList<>());
                userHistory.get(userId).add(campaignId);
                if(userHistory.get(userId).size() > maxUserLimit) {
                    userHistory.get(userId).poll();
                }

                globalHistory.putIfAbsent(campaignId, new LinkedList<>());
                globalHistory.get(campaignId).add(currTime);

                
                advertiser.deductAmount(campaign.getBidAmount());

                System.out.println("Ad served to user ----------- userName: " + user.getName() + "  campaignId: " + campaignId + " advertiser current budget: " + advertiser.getBudget());
            } else {
                System.out.println("Add cannot be served!!!!!!");
            }
        } else {
            System.out.println("Add cannot be served!!!!!! constraint didn't matched");
        }

    }
}

/*
A user shouldn’t see the same advertisement if he has seen it in the last 10 fetch instances.

At the global level, don’t serve the same advertisement if it has been served 5 times in the last 1 minute.
match_advertisement can return null if all the advertisements after the criteria matching fail the system constraints validation for a user.
// t1, t2, t3, t4, t5 ,t6
*/
