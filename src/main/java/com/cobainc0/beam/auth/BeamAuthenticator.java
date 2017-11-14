package com.cobainc0.beam.auth;


import com.cobainc0.beam.BeamConfiguration;
import com.cobainc0.beam.core.User;
import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class BeamAuthenticator
        implements Authenticator<BasicCredentials, User> {

    private final BeamConfiguration config;

    public BeamAuthenticator(BeamConfiguration config){
        this.config = config;
    }

    @Override
    public java.util.Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if ((config.getAdminPassword()).equals("pa55word")) {
                return java.util.Optional.of(new User());
            }
            return java.util.Optional.empty();
    }

//    @Override
//    public java.util.Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
//        if ((config.getAdminPassword()).equals(credentials.getPassword())) {
//            return java.util.Optional.of(new User());
//        }
//        return java.util.Optional.empty();
//    }

//         public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
//            if ("secret".equals(credentials.getPassword())) {
//                return Optional.of(new User(credentials.getUsername()));
//            }
//            return Optional.absent();
//        }

 //searches [db] for matching credentials and returns a User, as defined above
//    @Override
//    public Optional<User> authenticate(BasicCredentials credentials)  throws AuthenticationException {
//        if ((config.getAdminPassword()).equals(credentials.getPassword())) {
//            return Optional.of(new User(credentials.getUsername()));
//        } else {
//            return Optional.absent(); //empty Guava Optional
//        }
//    }
}
