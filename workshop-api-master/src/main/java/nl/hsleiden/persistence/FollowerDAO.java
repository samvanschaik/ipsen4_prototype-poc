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
public class FollowerDAO //Dit is een DAO
{

    private final List<Follower> followers;

    public FollowerDAO() {
        Follower followersDay1 = new Follower();
        followersDay1.setTotalFollowers(203329);
        followersDay1.setId(1);

        Follower followersDay2 = new Follower();
        followersDay2.setTotalFollowers(293139);
        followersDay2.setId(2);

        followers = new ArrayList<>();
        followers.add(followersDay1);
        followers.add(followersDay2);

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



}