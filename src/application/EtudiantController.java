package application;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import dao.DataBaseAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lesclassesduprojet.Absence;
import lesclassesduprojet.Classe;
import lesclassesduprojet.Enseignant;
import lesclassesduprojet.Etudiant;
import lesclassesduprojet.Matiere;


public class EtudiantController implements Initializable {

	    @FXML
	    private ImageView imget;

	    @FXML
	    private Label nomet;

	    @FXML
	    private Label prenomet;

	    @FXML
	    private Label classeet;

	    @FXML
	    private Label filiereet;

	    @FXML
	    private TableView<Absence> tableet;

	    @FXML
	    private TableColumn<Absence, String> c1;

	    @FXML
	    private TableColumn<Absence,String> c2;

	    @FXML
	    private TableColumn<Absence, String> c3;

	    @FXML
	    private TableColumn<Absence, Integer> c4;

	    @FXML
	    private TableColumn<Absence, String> c5;

	  
	    
		
		public ObservableList<Absence> data = FXCollections.observableArrayList();

		@Override
		public void initialize(URL location,ResourceBundle resources) {
			//Statement st;
			try {
				
				
				String sql ="SELECT * FROM absence INNER JOIN etudiant ON etudiant.id_etudiant =absence.id_etudiant INNER JOIN enseignant ON enseignant.id_enseignant =absence.id_enseignant INNER JOIN matiere ON matiere.id_matiere=absence.id_matiere INNER JOIN classe ON etudiant.id_classe=classe.id_classe where etudiant.login='"+LoginController.login+"' AND etudiant.pwd='"+LoginController.pwd+"'";
						 
				Connection con = DataBaseAccess.getConnection();
				PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
				ResultSet resultSet = prepareStatement.executeQuery();
				while(resultSet.next()) {
					Classe classe=new Classe(resultSet.getInt(25),resultSet.getString(26),resultSet.getInt(27),resultSet.getString(28));
					Etudiant etudiant=new Etudiant(resultSet.getInt(8),resultSet.getString(9), resultSet.getString(10),resultSet.getString(11),resultSet.getString(12), resultSet.getString(13),classe);
					Enseignant enseignant=new Enseignant(resultSet.getInt(16),resultSet.getString(17),resultSet.getString(18),resultSet.getString(19),resultSet.getString(20),resultSet.getInt(21));
					Matiere matiere=new Matiere(resultSet.getInt(23), resultSet.getString(24));
				    data.add(new Absence(etudiant, enseignant, matiere, resultSet.getInt(4), resultSet.getString(5),1, 0));	
				    
				     nomet.setText(resultSet.getString(10));
					 prenomet.setText(resultSet.getString(9));
					 classeet.setText(resultSet.getString(26));
					 filiereet.setText(resultSet.getString(28));
					    Image F = new Image("F.png");
						Image M = new Image("M.png");
					 if(resultSet.getInt(15)==1)
					 {
						 
						 imget.setImage(F);
					 }
					 if(resultSet.getInt(15)==0)
					 {
						 imget.setImage(M);
					 }
					 
				   
				}
				 
				
				
				
				con.close();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			                    }
			
			c1.setCellValueFactory(new PropertyValueFactory<Absence,String>("date"));
			c2.setCellValueFactory(new PropertyValueFactory<Absence,String>("nomprof"));
			c3.setCellValueFactory(new PropertyValueFactory<Absence,String>("matiereet"));
			c4.setCellValueFactory(new PropertyValueFactory<Absence,Integer>("numseance"));
			c5.setCellValueFactory(new PropertyValueFactory<Absence,String>("etat"));
			
			
			tableet.setItems(data);
			
			
		}
	    public void justifier(ActionEvent e) throws Exception
	    {
	    	Stage primeryStage = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("/application/InterfaceJustification.fxml"));
    		Scene scene = new Scene(root);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		primeryStage.setScene(scene);
    		primeryStage.show();
    		
    		
	    }
	    public void retour1(ActionEvent e) throws Exception 
		{
			 Stage primeryStage = new Stage();
		  		Parent root = FXMLLoader.load(getClass().getResource("/application/PageLogin.fxml"));
		  		Scene scene = new Scene(root);
		  		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		  		primeryStage.setScene(scene);
		  		primeryStage.show();
		  		((Node)e.getSource()).getScene().getWindow().hide();
		}

}
