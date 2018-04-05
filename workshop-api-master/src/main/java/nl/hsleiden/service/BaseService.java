package nl.hsleiden.service;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import nl.hsleiden.model.Follower;

/**
 *
 * @author Peter van Vliet
 * @param <T>
 */
public class BaseService<T>
{
    public T requireResult(T model)
    {
        if (model == null)
        {
            throw new NotFoundException();
        }
        
        return model;
    }
    
    public void assertSelf(Follower follower1, Follower follower2)
    {
        if (!follower1.equals(follower2))
        {
            throw new ForbiddenException();
        }
    }
}
