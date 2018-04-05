/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hsleiden.service;

import java.util.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.Authorizer;
import io.dropwizard.auth.basic.BasicCredentials;
import javax.inject.Inject;
import javax.inject.Singleton;
import nl.hsleiden.model.Follower;
import nl.hsleiden.persistence.FollowerDAO;

/**
 *
 * @author Peter van Vliet
 */
@Singleton
public class AuthenticationService implements Authenticator<BasicCredentials, Follower>, Authorizer<Follower>
{
    private final FollowerDAO followerDAO;
    
    @Inject
    public AuthenticationService(FollowerDAO followerDAO)
    {
        this.followerDAO = followerDAO;
    }

    @Override
    public Optional<Follower> authenticate(BasicCredentials credentials) throws AuthenticationException
    {
        Follower follower = followerDAO.getByEmailAddress(credentials.getUsername());
        
        if (follower != null && follower.getPassword().equals(credentials.getPassword()))
        {
            return Optional.of(follower);
        }
        
        return Optional.empty();
    }

    @Override
    public boolean authorize(Follower follower, String roleName)
    {
        return follower.hasRole(roleName);
    }
}
