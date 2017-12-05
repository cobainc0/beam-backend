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
        if ((config.getAdminPassword()).equals(credentials.getPassword())) {
                return java.util.Optional.of(new User());
            }
            return java.util.Optional.empty();
    }

}
