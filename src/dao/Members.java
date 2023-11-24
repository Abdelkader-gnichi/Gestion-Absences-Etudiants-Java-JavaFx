package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import lesclassesduprojet.Classe;
import lesclassesduprojet.Enseignant;
import lesclassesduprojet.Etudiant;
import lesclassesduprojet.Responsable;


public class Members {

	
	//etudiant avec jointure
	
	public static List<Etudiant> getEtudiant(){
		List<Etudiant> list = new ArrayList<Etudiant>();
		try {

			String sql ="SELECT * FROM etudiant INNER JOIN classe ON etudiant.id_classe = classe.id_classe";
			Connection con = DataBaseAccess.getConnection();
			PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				Classe classe=new Classe(resultSet.getInt(9),resultSet.getString(10),resultSet.getInt(11),resultSet.getString(12));
				Etudiant etudiant = new Etudiant(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),
						resultSet.getString(5),resultSet.getString(6),classe);
				
				
				list.add(etudiant);
				
			}
			
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return list;
		
	}
	
	
	//enseignant 
	
	public static List<Enseignant> getEnseignant(){
		List<Enseignant> list = new ArrayList<Enseignant>();
		try {
			/*SELECT population.id,population.pays,population.nb_pop,telephones_port.nb_portable
			FROM `population`,`telephones_port`
			WHERE population.id = telephones_port.id*/
			String sql ="SELECT * FROM enseignant WHERE 1";
			Connection con = DataBaseAccess.getConnection();
			PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				
				Enseignant enseignant = new Enseignant(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
				
				
				list.add(enseignant);
				
			}
			
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return list;
		
	}
	
	
	// responsable
	
	public static List<Responsable> getResponsable(){
		List<Responsable> list = new ArrayList<Responsable>();
		try {
			/*SELECT population.id,population.pays,population.nb_pop,telephones_port.nb_portable
			FROM `population`,`telephones_port`
			WHERE population.id = telephones_port.id*/
			String sql ="SELECT * FROM responsable WHERE 1";
			Connection con = DataBaseAccess.getConnection();
			PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				
				Responsable responsable = new Responsable(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
				
				
				list.add(responsable);
				
			}
			
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return list;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
