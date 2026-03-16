package com.ownproject.springboot2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot2Application {

		/*
		Ez nem kell mindig:
		mvn clean install (Létrehozza a target mappát és előkészíti a buildet. A jar fájl olyan, mint egy sima zip fájl, csak jar a kiterjesztése.)

		Starthoz terminálban:		
		mvn spring-boot:run (elindítja a szervert)
		A terminál melletti port fülön is láthatod a webcímet. 
		
		Leállítás: terminálban ctrl+c*/

	public static void main(String[] args) {
		SpringApplication.run(Springboot2Application.class, args);
		System.out.println("Elindult.");

		//A render.com-ról van az External Database URL egy része kell és eléraktam "jdbc:"
		//External Database: postgresql://database_olpd_user:sekoojWQ5YUGrgC3080avcnkVvgY4LSQ@dpg-d69k87buibrs739i5fu0-a.frankfurt-postgres.render.com/database_olpd

		String url="jdbc:postgresql://dpg-d69k87buibrs739i5fu0-a.frankfurt-postgres.render.com/database_olpd";
		Properties props=new Properties();
		props.setProperty("user", "database_olpd_user");
		props.setProperty("password", "sekoojWQ5YUGrgC3080avcnkVvgY4LSQ");

		try {
			Connection conn=DriverManager.getConnection(url,props);
			System.out.println("Rákapcsolódtunk az adatbázisra.");

			//sql-es lekérdezés.
			Statement statement=conn.createStatement(); //import java.sql.Statement;

			//sima statement
			statement.executeUpdate("INSERT INTO dog_owner(first_name, last_name) VALUES ('alma','körte')");

			//A prepared statement jobb.

		} catch (SQLException e) {
			
		}
		

	}

}
