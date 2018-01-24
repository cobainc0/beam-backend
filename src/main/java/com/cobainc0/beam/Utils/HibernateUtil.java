//package com.cobainc0.beam.Utils;
//
//
//import com.cobainc0.beam.BeamConfiguration;
//import com.cobainc0.beam.core.User;
//import com.cobainc0.beam.core.Vendor;
//import io.dropwizard.db.PooledDataSourceFactory;
//import io.dropwizard.hibernate.HibernateBundle;
//
//public class HibernateUtil {
//
//    private static HibernateBundle<BeamConfiguration> hibernateBundle;
//
//    public HibernateUtil(){
//        //hibernate bundle
//         hibernateBundle = new HibernateBundle<BeamConfiguration>(
//                //pass all entity classes
//                Vendor.class,
//                User.class
//        ) {
//            @Override
//            public PooledDataSourceFactory getDataSourceFactory(BeamConfiguration configuration) {
//                return configuration.getDataSourceFactory();
//            }
//        };
//    }
//
//
//
//    public static HibernateBundle<BeamConfiguration> getHibernateBundle(){
//        return hibernateBundle;
//    }
//
//}
