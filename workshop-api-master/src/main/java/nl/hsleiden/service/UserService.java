package nl.hsleiden.service;

import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;
import nl.hsleiden.model.Follower;
import nl.hsleiden.persistence.FollowerDAO;

/**
 *
 * @author Peter van Vliet
 */
@Singleton
public class UserService extends BaseService<Follower>
{
    private final FollowerDAO dao;
    
    @Inject
    public UserService(FollowerDAO dao)
    {
        this.dao = dao;
    }
    
    public Collection<Follower> getAll()
    {
        return dao.getAll();
    }
    
    public Follower get(int id)
    {
        return requireResult(dao.get(id));
    }
    
    public void add(Follower follower)
    {
        follower.setRoles(new String[] { "GUEST" });
        
        dao.add(follower);
    }
    
    public void update(Follower authenticator, int id, Follower follower)
    {
        // Controleren of deze gebruiker wel bestaat
        Follower oldFollower = get(id);
        
        if (!authenticator.hasRole("ADMIN"))
        {
            // Vaststellen dat de geauthenticeerde gebruiker
            // zichzelf aan het aanpassen is
            assertSelf(authenticator, oldFollower);
        }
        
        dao.update(id, follower);
    }
    
    public void delete(int id)
    {
        // Controleren of deze gebruiker wel bestaat
        Follower follower = get(id);
        
        dao.delete(id);
    }
}
