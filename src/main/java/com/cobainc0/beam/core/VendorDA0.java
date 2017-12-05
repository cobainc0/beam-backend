package com.cobainc0.beam.core;


import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class VendorDA0 extends AbstractDAO<Vendor>{

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public VendorDA0(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List findAll(){
        return list(
                namedQuery("com.cobainc0.beam.core.Vendor.findAll"));
    }

    public List findByName(String vendorName){
        StringBuilder builder = new StringBuilder("%");
        builder.append(vendorName).append("%");
        return list(
                namedQuery("com.cobainc0.beam.core.Vendor.findByVendorName")
                .setParameter("vendorName", builder.toString())
        );
    }

    public Optional<Vendor> getById(long vendorId){
        return Optional.fromNullable((Vendor) get(vendorId));
    }
}
