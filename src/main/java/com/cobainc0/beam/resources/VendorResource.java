package com.cobainc0.beam.resources;

import com.cobainc0.beam.core.Vendor;
import com.cobainc0.beam.core.VendorDAO;
import io.dropwizard.jersey.params.LongParam;
import io.dropwizard.jersey.params.NonEmptyStringParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("vendor")
public class VendorResource {

    private VendorDAO vendorDA0;

    public VendorResource(VendorDAO vendorDAO){
        this.vendorDA0 = vendorDAO;
    }

    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Vendor> findByName(@QueryParam("name") String name) {
        StringBuilder builder = new StringBuilder("%");
        String searchName = String.valueOf(builder.append(name).append("%"));
        return vendorDA0.findByVendorName(searchName);
    }
//
//    @Path("/query")
//    @Produces(MediaType.APPLICATION_JSON)
//    @GET
//    public List<Vendor> findByPostcode(@QueryParam("postcode") String postcode){
//        StringBuilder builder = new StringBuilder("%");
//        String searchPostcode = String.valueOf(builder.append(postcode).append("%"));
//        return vendorDA0.findByPostcode(searchPostcode);
//    }

    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Vendor> findAll(){
        return vendorDA0.findAll();
    }

    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Vendor> findById(@PathParam("id") LongParam id) {
        return vendorDA0.findById(id.get());
    }
}
