package com.cobainc0.beam.auth;

import com.cobainc0.beam.core.User;
import io.dropwizard.auth.Authorizer;

public class BeamAuthoriser implements Authorizer<User> {

    public BeamAuthoriser() {}


    @Override
    public boolean authorize(User user, String role) {
        return (user.getName().equals("user") && user.getRole().equals("admin"));
    }

}