package application;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.DataBaseAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JustificationController {
	 public void validerjustification(ActionEvent e) throws Exception
	    {
	    	try 
	    	{
	    		
	    		 
	    		String sql =" UPDATE absence  INNER JOIN etudiant ON etudiant.id_etudiant=absence.id_etudiant SET absence.justifiee=1  WHERE etudiant.login='"+LoginController.login+"' AND etudiant.pwd='"+LoginController.pwd+"'";
				 
				Connection con = DataBaseAccess.getConnection();
				PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
				prepareStatement.executeUpdate();
				
				con.close();
	    	}
	    	catch(Exception b) {
				b.printStackTrace();
			                    }
	    }
	 
	 public void retour(ActionEvent e) throws Exception 
		{
			 Stage primeryStage = new Stage();
		  		Parent root = FXMLLoader.load(getClass().getResource("/application/PageEtudiant.fxml"));
		  		Scene scene = new Scene(root);
		  		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		  		primeryStage.setScene(scene);
		  		primeryStage.show();
		  		((Node)e.getSource()).getScene().getWindow().hide();
		}
}
