package nl.hsleiden.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Singleton;
import nl.hsleiden.model.Follower;

/**
 *
 * @author Peter van Vliet
 */
@Singleton
public class UserDAO //Dit is een DAO
{
    private final List<Follower> followers;
    
    public UserDAO()
    {
        Follower follower1 = new Follower();
        follower1.setFullName("First user");
        follower1.setPostcode("1234AB");
        follower1.setStreetnumber("12");
        follower1.setEmailAddress("first@user.com");
        follower1.setPassword("first");
        follower1.setRoles(new String[] { "GUEST", "ADMIN" });
        
        Follower follower2 = new Follower();
        follower2.setFullName("Second user");
        follower2.setPostcode("9876ZY");
        follower2.setStreetnumber("98");
        follower2.setEmailAddress("second@user.com");
        follower2.setPassword("second");
        follower2.setRoles(new String[] { "GUEST" });
        
        followers = new ArrayList<>();
        followers.add(follower1);
        followers.add(follower2);
    }
    
    public List<Follower> getAll()
    {
        return followers;
    }
    
    public Follower get(int id)
    {
        try
        {
            return followers.get(id);
        }
        catch(IndexOutOfBoundsException exception)
        {
            return null;
        }
    }
    
    public Follower getByEmailAddress(String emailAddress)
    {
        Optional<Follower> result = followers.stream()
            .filter(user -> user.getEmailAddress().equals(emailAddress))
            .findAny();
        
        return result.isPresent()
            ? result.get()
            : null;
    }
    
    public void add(Follower follower)
    {
        followers.add(follower);
    }
    
    public void update(int id, Follower follower)
    {
        followers.set(id, follower);
    }
    
    public void delete(int id)
    {
        followers.remove(id);
    }
}
