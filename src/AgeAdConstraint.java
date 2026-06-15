import java.time.LocalDate;
import java.time.Period;

public class AgeAdConstraint implements AdConstraintsInterface {

    @Override
    public boolean shouldShowAd(User user, AdCampaign campaign) {
        int userAge = Period.between(user.getDob(), LocalDate.now()).getYears();
        return userAge >= campaign.getMinAge() && userAge < campaign.getMaxAge();
    }
    
}
