package com.cobainc0.beam.db;

import com.cobainc0.beam.core.Vendor;
import com.cobainc0.beam.core.VendorDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private DBI dbi;
    private VendorDAO dao;

    private static final String PASSWORD = "pa55word";
    private static final String USERNAME = "root";

    @Before
    public void setUp() throws Exception {
    // using in-memory H2 database via a pooled DataSource
//        JdbcConnectionPool ds = JdbcConnectionPool.create("jdbc:h2:mem:test;" +
//                "MODE=Mysql;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;INIT=" +
//                "CREATE SCHEMA IF NOT EXISTS Vendor");
//        dbi =  new DBI("jdbc:h2:mem:test;" +
//                "MODE=Mysql;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;INIT=" +
//                "CREATE SCHEMA IF NOT EXISTS Vendor");

        Class.forName("com.mysql.jdbc.Driver");
        dbi =  new DBI("jdbc:mysql://localhost:3306/beam", USERNAME, PASSWORD);

        dao = dbi.open(VendorDAO.class);

    }

    @After
    public void tearDown() throws Exception{
        dao.close();
    }

    @Test
    public void listAllBusiness() {
        dropTable();
        createTable();
        addRecord();
        addRecord();
        addRecord();
        int actualSize = dao.findAll().size();
        assertEquals(3, actualSize);
    }

    @Test
    public void findByName(){
        dropTable();
        createTable();
        addRecord();
        String expectedVendorName = "AdventureLand";
        List<Vendor> returnedVendor = dao.findByVendorName(expectedVendorName);
        String actualVendorName =
                returnedVendor
                .get(0).getVendorName();
        assertEquals(expectedVendorName, actualVendorName);
    }

    private void createTable(){
        dao.createVendorTbl();
    }

    private void dropTable(){
        dao.dropVendorTbl();
    }

    private void addRecord(){
     dao.insert("AdventureLand", "18 Gisburn Road", "Hornsey", "London",
                "N8 7BS", "02083476941", "no email", "", "Other", "", "" );
//        Logger LOGGER = LoggerFactory.getLogger(DatabaseTest.class);
//        LOGGER.info("BLAH...."+blah.toString());
    }
}
