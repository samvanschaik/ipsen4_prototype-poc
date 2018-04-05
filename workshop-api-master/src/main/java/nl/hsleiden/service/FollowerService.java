package nl.hsleiden.service;


import nl.hsleiden.model.Follower;
import nl.hsleiden.model.User;
import nl.hsleiden.persistence.FollowerDAO;
import nl.hsleiden.persistence.UserDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;

@Singleton
public class FollowerService {

    private final FollowerDAO dao;

    @Inject
    public FollowerService(FollowerDAO dao)
    {
        this.dao = dao;
    }


}


