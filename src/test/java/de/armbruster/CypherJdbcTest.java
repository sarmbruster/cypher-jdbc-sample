package de.armbruster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.sql.*;

/**
 * Created by stefan on 16.05.14.
 */
@RunWith(JUnit4.class)
public class CypherJdbcTest {

    @Test
    public void shouldCypherJdbcWorkWithoutException() throws ClassNotFoundException, SQLException {
        // Make sure Neo4j Driver is registered
        Class.forName("org.neo4j.jdbc.Driver");

        // Connect
        Connection con = DriverManager.getConnection("jdbc:neo4j://localhost:7474/");

        // Querying
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("MATCH (n:Person) RETURN n.name");
            while (rs.next()) {
                System.out.println(rs.getString("n.name"));
            }
        }


    }
}
