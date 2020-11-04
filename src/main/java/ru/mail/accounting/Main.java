package ru.mail.accounting;

import org.flywaydb.core.Flyway;

import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://127.0.0.1:5432/database1", "postgres", "")
                .locations("db")
                .load();
        flyway.clean();
        flyway.migrate();

        //SQL queries.
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/database1", "postgres", "")) {
            System.out.println("Connection OK.");
            //Insert data into Organization
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('Magnit',34,432432451)");
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('Patyorochka',344314,43244451)");
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('Centre',34214314,43243224451)");
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('Perekrestok',342143134,4324434232451)");
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('Xiaomi',3314424242,4342224322451)");
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('adidas',34314,43422243245142)");
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('FixPrice',7414,434243245143)");
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('Nike',2177314,43422243245421)");
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('Puma',3443217744314,43422254241)");
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('Billa',34214,4241)");
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('Mail',3421774314,434222)");
                stmt.executeUpdate("INSERT INTO organization(name,\"INN\",checking_account) VALUES('Yandex',342177225314,434224341)");
            }

            //Into Waybill.
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  1,'2010-04-01','Magnit')");
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  2,'2010-05-01','Patyorochka')");
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  3,'2010-06-01','Perekrestok')");
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  4,'2010-07-01','Centre')");
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  5,'2010-08-01','Xiaomi')");
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  6,'2010-09-01','adidas')");
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  7,'2010-10-01','FixPrice')");
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  8,'2010-11-01','Nike')");
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  9,'2010-12-01','Puma')");
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  10,'2011-01-01','Billa')");
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  11,'2010-02-01','Mail')");
                stmt.executeUpdate("INSERT INTO waybill(waybill_num,waybill_date,org_sender) VALUES(  12,'2010-03-01','Yandex')");


            }
            //Insert into Nomenclature.
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate("INSERT INTO nomenclature(id,name,internal_code) VALUES(1,'Milk',2242) ");
                stmt.executeUpdate("INSERT INTO nomenclature(id,name,internal_code) VALUES(2,'Sneaker',24432) ");
                stmt.executeUpdate("INSERT INTO nomenclature(id,name,internal_code) VALUES(3,'Smart_Station',3224) ");
               /* stmt.executeUpdate("INSERT INTO nomenclature(id,name,internal_code) VALUES(5,'',53224) ");
                stmt.executeUpdate("INSERT INTO nomenclature(id,name,internal_code) VALUES(6,'',0786543) ");
                stmt.executeUpdate("INSERT INTO nomenclature(id,name,internal_code) VALUES(7,'',73252) ");
                stmt.executeUpdate("INSERT INTO nomenclature(id,name,internal_code) VALUES(8,'',843452) ");
                stmt.executeUpdate("INSERT INTO nomenclature(id,name,internal_code) VALUES(9,'',6324) ");
                stmt.executeUpdate("INSERT INTO nomenclature(id,name,internal_code) VALUES(10,'',52523) ");
                stmt.executeUpdate("INSERT INTO nomenclature(id,name,internal_code) VALUES(11,'',532269) ");
                stmt.executeUpdate("INSERT INTO nomenclature(id,name,internal_code) VALUES(12,'',9765) ");*/

            }
            //Into WayBill_position.
            try (Statement stmt = connection.createStatement()) {

                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (1,540000,1,40000,1)");
                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (2,550000,1,41000,2)");
                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (3,530000,1,44000,3)");
                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (4,540000,1,42000,4)");
                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (5,520000,1,44000,7)");
                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (6,560000,1,40000,10)");

                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (7,1000000,2,5200,6)");
                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (8,1200000,2,5100,8)");
                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (9,1400000,2,5400,9)");

                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (10,500000,3,11000,5)");
                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (11,510000,3,13200,12)");
                stmt.executeUpdate("INSERT INTO waybill_position(position ,price,nomenclature,amount,waybill) VALUES (12,490000,3,13100,11)");
            }

//

            System.out.println("Report 1: Top 10 suppliers of the number of delivered goods ");
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("select w.org_sender\n" +
                        "from waybill w \n" +
                        "where w.waybill_num in\n" +
                        "(select  wp.waybill\n" +
                        "from  waybill_position wp \n" +
                        "order by wp.amount DESC\n"+
                        "limit 10);")) {
                    while (rs.next()) {
                        System.out.println(rs.getString("org_sender"));
                    }
                }
            }
            System.out.println("Report 2: suppliers of the number of delivered goods greater than 42000");
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("select w.org_sender \n" +
                        "from waybill w  \n" +
                        "where w.waybill_num in (select wp.waybill\n" +
                        "from  waybill_position wp \n" +
                        "where wp.amount >42000\n" +
                        ");")) {
                    while (rs.next()) {
                        System.out.println(rs.getString("org_sender"));
                    }
                }
            }
            System.out.println("Report 3: ");
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("select w.org_sender \n" +
                        "from waybill w  \n" +
                        "where w.waybill_num in (select wp.waybill\n" +
                        "from  waybill_position wp \n" +
                        "where wp.amount >42000\n" +
                        ");")) {
                    while (rs.next()) {
                        System.out.println(rs.getString("org_sender"));
                    }
                }
            }
        } catch (SQLException throwables) {
            System.out.println("Connection failure.");
            throwables.printStackTrace();
        }
    }
}
