import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private LocalDate dob;
    private Gender gender;
    private List<String> interests;
    private String city;
    
    public User(String name, LocalDate dob, Gender gender, String city) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.userId = UUID.randomUUID().toString().substring(6);
        this.interests = new ArrayList<>();
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Gender getGender() {
        return gender;
    }

    public String getUserId() {
        return userId;
    }

    public void addInterest(String interest) {
        this.interests.add(interest);
    }

    public List<String> getInterests() {
        return interests;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return String.format(
        """
        User   name: %s, dob: %s, gender: %s, userId: %s         
        """, name, dob.toString(), gender.name(), userId);
    }
    
}
