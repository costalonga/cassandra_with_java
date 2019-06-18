package com.example.helloworld;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Cluster cluster = null;

        try {
            cluster = Cluster.builder().addContactPoint("localhost").build();

            Session session = cluster.connect();

            ResultSet rs = session.execute("Select release_version from system.local");
            Row row = rs.one();
            System.out.println(row.getString("release_version"));

        } finally {
            if (cluster != null) cluster.close();
        }

    }

}
