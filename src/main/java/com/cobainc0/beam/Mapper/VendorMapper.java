package com.cobainc0.beam.Mapper;

import com.cobainc0.beam.core.Vendor;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorMapper implements ResultSetMapper<Vendor>{
    private static final Logger LOGGER = LoggerFactory.getLogger(VendorMapper.class);
    private static final String SPACING = "----------------------";

    @Override
    public Vendor map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        LOGGER.info("Index: "+index);
        LOGGER.info(SPACING);
        LOGGER.info("ResultSet: "+r);
        LOGGER.info("StatementContext: "+ctx.getLocatedSql());
        LOGGER.info(SPACING);

        Vendor vendor = new Vendor();
        vendor.setVendorId(r.getLong("vendorId"));
        vendor.setVendorName(r.getString("vendorName"));
        vendor.setVendorAddress1(r.getString("vendorAddress1"));
        vendor.setVendorAddress2(r.getString("vendorAddress2"));
        vendor.setVendorAddress3(r.getString("vendorAddress3"));
        vendor.setVendorPostcode(r.getString("vendorPostcode"));
        vendor.setVendorEmail(r.getString("vendorEmail"));
        vendor.setVendorTelephone(r.getString("vendorTelephone"));
        vendor.setVendorWebsite(r.getString("vendorWebsite"));
        vendor.setVendorType(r.getString("vendorType"));
        vendor.setVendorLat(r.getString("vendorLat"));
        vendor.setVendorLng(r.getString("vendorLng"));
        return vendor;
    }
}
