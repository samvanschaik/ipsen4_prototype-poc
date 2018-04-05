package nl.actorius.service;

import nl.hsleiden.service.AuthenticationService;
import java.util.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.basic.BasicCredentials;
import nl.hsleiden.model.Follower;
import nl.hsleiden.persistence.FollowerDAO;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Peter van Vliet <peter@actorius.nl>
 */
public class AuthenticationServiceTest
{
    private final AuthenticationService subject;
    
    public AuthenticationServiceTest()
    {
        FollowerDAO followerDAO = new FollowerDAO();
        
        subject = new AuthenticationService(followerDAO);
    }
    
    @Before
    public void setUp()
    {
        
    }
    
    @After
    public void tearDown()
    {
        
    }
    
    @Test
    public void testAuthenticateSuccess() throws AuthenticationException
    {
        BasicCredentials credentials = new BasicCredentials("second@user.com", "second");
        
        Optional<Follower> actual = subject.authenticate(credentials);
        
        assertTrue(actual.isPresent());
    }
    
    @Test
    public void testAuthenticateWrongEmail() throws AuthenticationException
    {
        BasicCredentials credentials = new BasicCredentials("second@user.net", "second");
        
        Optional<Follower> actual = subject.authenticate(credentials);
        
        assertFalse(actual.isPresent());
    }
    
    @Test
    public void testAuthenticateWrongPassword() throws AuthenticationException
    {
        BasicCredentials credentials = new BasicCredentials("second@user.com", "first");
        
        Optional<Follower> actual = subject.authenticate(credentials);
        
        assertFalse(actual.isPresent());
    }
    
    @Test
    public void testAuthorizeSuccess()
    {
        Follower follower = new Follower();
        follower.setRoles(new String[] { "GUEST", "ADMIN" });
        
        boolean actual = subject.authorize(follower, "ADMIN");
        
        assertTrue(actual);
    }
    
    @Test
    public void testAuthorizeFailed()
    {
        Follower follower = new Follower();
        follower.setRoles(new String[] { "GUEST" });
        
        boolean actual = subject.authorize(follower, "ADMIN");
        
        assertFalse(actual);
    }
}
