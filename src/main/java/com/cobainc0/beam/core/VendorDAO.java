package com.cobainc0.beam.core;

import com.cobainc0.beam.Mapper.VendorMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(VendorMapper.class)

public interface VendorDAO {

        @SqlUpdate("DROP TABLE IF EXISTS Vendor")
        void dropVendorTbl();

        @SqlUpdate("CREATE TABLE IF NOT EXISTS Vendor (vendorId INT PRIMARY KEY NOT NULL AUTO_INCREMENT, vendorName varchar(100), vendorAddress1 varchar(100)," +
                " vendorAddress2 varchar(100), vendorAddress3 varchar(100), vendorPostcode varchar(100), " +
                "vendorTelephone varchar(100), vendorEmail varchar(100), vendorWebsite varchar(100), " +
                "vendorType varchar(100), vendorLat varchar(100), vendorLng varchar(100))")
        void createVendorTbl();

        @SqlUpdate("INSERT INTO Vendor (vendorName, vendorAddress1, vendorAddress2, vendorAddress3, vendorPostcode, vendorTelephone, vendorEmail, vendorWebsite, vendorType, vendorLat, vendorLng)" +
                " values (:vendorName, :vendorAddress1, :vendorAddress2, :vendorAddress3, :vendorPostcode, :vendorTelephone, :vendorEmail, :vendorWebsite, :vendorType, :vendorLat, :vendorLng)")
        void insert(@Bind("vendorName") String vendorName, @Bind("vendorAddress1") String vendorAddress1, @Bind("vendorAddress2") String vendorAddress2, @Bind("vendorAddress3") String vendorAddress3,
                    @Bind("vendorPostcode") String vendorPostcode, @Bind("vendorTelephone") String vendorTelephone, @Bind("vendorEmail") String vendorEmail, @Bind("vendorWebsite") String vendorWebsite,
                    @Bind("vendorType") String vendorType, @Bind("vendorLat") String vendorLat, @Bind("vendorLng") String vendorLng);

        @SqlQuery("SELECT * FROM Vendor")
        List<Vendor> findAll();

        @SqlQuery("SELECT * FROM Vendor WHERE vendorName LIKE :name")
        List<Vendor> findByVendorName(@Bind("name") String name);

        @SqlQuery("SELECT * FROM Vendor WHERE vendorId = :id")
        List<Vendor> findById(@Bind("id") Long id);

        @SqlQuery("SELECT vendorName, vendorAddress1, vendorAddress2, vendorAddress3, vendorPostcode" +
                " FROM Vendor WHERE vendorPostcode LIKE :postcode")
        List<Vendor> findByPostcode(@Bind("postcode") String postcode);

        void close();



}
