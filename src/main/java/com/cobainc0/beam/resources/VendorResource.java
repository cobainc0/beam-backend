package com.cobainc0.beam.resources;

import com.cobainc0.beam.core.Vendor;
import com.cobainc0.beam.core.VendorDA0;
import io.dropwizard.hibernate.UnitOfWork;
import com.google.common.base.Optional;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("vendor")
@Produces(MediaType.APPLICATION_JSON)


public class VendorResource {

    private VendorDA0 vendorDA0;

    public VendorResource(VendorDA0 vendorDAO){
        this.vendorDA0 = vendorDAO;
    }


    @GET
    @UnitOfWork
    public List<Vendor> findByName(@QueryParam("vendorName") Optional<String> vendorName){
        if(vendorName.isPresent()){
            return vendorDA0.findByName(vendorName.get());
        }else{
            return vendorDA0.findAll();
        }
    }

    @GET
    @UnitOfWork
    @Path("/{vendorId}")
    public Optional<Vendor> getById(@PathParam("vendorId") LongParam id){
        return vendorDA0.getById(id.get());
    }


}
