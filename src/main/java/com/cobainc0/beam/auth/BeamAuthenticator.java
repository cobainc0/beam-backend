package com.cobainc0.beam.auth;

import com.cobainc0.beam.BeamConfiguration;
import com.cobainc0.beam.core.User;
import com.google.common.base.Optional;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;



public class BeamAuthenticator
        implements Authenticator<BasicCredentials, User>{

    private final BeamConfiguration config;

    public BeamAuthenticator(BeamConfiguration config){
        this.config = config;
    }


    //searches [db] for matching credentials and returns a User, as defined above
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) {
        if ((config.getAdminPassword()).equals(credentials.getPassword())) {
            return Optional.of(new User()); //Guava Optional containing User
        } else {
            return Optional.absent(); //empty Guava Optional
        }
    }
}
