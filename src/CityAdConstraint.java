public class CityAdConstraint implements AdConstraintsInterface{

    @Override
    public boolean shouldShowAd(User user, AdCampaign campaign) {
        return user.getCity().equals(campaign.getCity());
    }
    
}
