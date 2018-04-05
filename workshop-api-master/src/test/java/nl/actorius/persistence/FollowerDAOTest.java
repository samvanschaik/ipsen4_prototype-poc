package nl.actorius.persistence;

import nl.hsleiden.persistence.FollowerDAO;
import nl.hsleiden.model.Follower;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Peter van Vliet <peter@actorius.nl>
 */
public class FollowerDAOTest
{
    private FollowerDAO subject;
    
    @Before
    public void setUp()
    {
        System.out.println("Set up");
        
        subject = new FollowerDAO();
    }
    
    @After
    public void tearDown()
    {
        System.out.println("Tear down");
        
        subject = null;
    }
    
    @Test
    public void testGetSuccess()
    {
        System.out.println("test get success");
        
        String expectedName = "Second user";
        Follower actual = subject.get(1);
        
        assertNotNull(actual);
        assertEquals(expectedName, actual.getName());
    }
    
    @Test
    public void testGetFailed()
    {
        System.out.println("Test get failed");
        
        Follower actual = subject.get(6);
        
        assertNull(actual);
    }
    
    @Test
    public void testGetByEmailAddress()
    {
        System.out.println("Test by email address");
        
        String expectedName = "First user";
        Follower actual = subject.getByEmailAddress("first@user.com");
        
        assertNotNull(actual);
        assertEquals(expectedName, actual.getName());
    }
    
    @Test
    public void testAdd()
    {
        System.out.println("Test add");
        
        Follower follower = new Follower();
        follower.setFullName("Peter van Vliet");
        
        subject.add(follower);
        
        int expectedSize = 3;
        int actualSize = subject.getAll().size();
        
        assertEquals(expectedSize, actualSize);
    }
}
