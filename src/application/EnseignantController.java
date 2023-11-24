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
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import lesclassesduprojet.Etudiant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class EnseignantController implements Initializable {
	  @FXML
	    private ImageView imageense;

	    @FXML
	    private Label prenomens;

	    @FXML
	    private Label nomens;

	    @FXML
	    private Label classeens;

	    @FXML
	    private Label matiereens;

	    @FXML
	    private Button ici;

	    @FXML
	    private TextField ns;

	    @FXML
	    private TableView<Etudiant> listepresence;

	    @FXML
	    private TableColumn<Etudiant, String> c1;

	    @FXML
	    private TableColumn<Etudiant, String> c2;

	    @FXML
	    private TableView<Etudiant> listedesabsences;

	    @FXML
	    private TableColumn<Etudiant,String> c3;

	    @FXML
	    private TableColumn<Etudiant,String> c4;

	    @FXML
	    private TableColumn<Etudiant,String> c5;

	    
	public ObservableList<Etudiant> data = FXCollections.observableArrayList();
	public ObservableList<Etudiant> dataet = FXCollections.observableArrayList();


	@Override
	public void initialize(URL location,ResourceBundle resources) {
		//Statement st;
		try {
			
			
			String sql ="SELECT * FROM correspondance INNER JOIN enseignant ON enseignant.id_enseignant =correspondance.id_enseignant INNER JOIN classe ON classe.id_classe =correspondance.id_classe INNER JOIN matiere ON matiere.id_matiere=correspondance.id_matiere INNER JOIN etudiant ON etudiant.id_classe=correspondance.id_classe WHERE enseignant.login='"+LoginController.login+"' AND enseignant.pwd='"+LoginController.pwd+"'AND matiere.libelle='"+SelectionEnseignantController.selectmatiere+"'AND classe.filiere='"+SelectionEnseignantController.selectfiliere+"' AND classe.libelle='"+SelectionEnseignantController.selectniveau+"'" ;
				
			
			Connection con = DataBaseAccess.getConnection();
			PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				/*Classe classe=new Classe(resultSet.getInt(24),resultSet.getString(25),resultSet.getInt(26),resultSet.getString(27));
				Etudiant etudiant=new Etudiant(resultSet.getInt(8),resultSet.getString(9), resultSet.getString(10),resultSet.getString(11),resultSet.getString(12), resultSet.getString(13),classe);
				Enseignant enseignant=new Enseignant(resultSet.getInt(16),resultSet.getString(17),resultSet.getString(18),resultSet.getString(19),resultSet.getString(20),resultSet.getInt(21));
				Matiere matiere=new Matiere(resultSet.getInt(21), resultSet.getString(22));*/
			    data.add(new Etudiant(resultSet.getInt(17),resultSet.getString(18),resultSet.getString(19), "","","",null));	
			    
			    nomens.setText(resultSet.getString(5));
			     prenomens.setText(resultSet.getString(6));
			     classeens.setText(resultSet.getString(12));
			     matiereens.setText(resultSet.getString(16));
				    Image F = new Image("ensei2.png");
					Image M = new Image("ensei1.png");
				 if(resultSet.getInt(10)==1)
				 {
					 
					 imageense.setImage(F);
				 }
				 if(resultSet.getInt(10)==0)
				 {
					 imageense.setImage(M);
				 }
				
			}
			 
			
			
			
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		                    }
		
		c1.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
		c2.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
		
		
		
		listepresence.setItems(data);
		
		
		
		
	}
	
	
	
	
	public void test() throws Exception {
    
		Etudiant etudiant = listepresence.getSelectionModel().getSelectedItem();
		
		
		
		System.out.println(etudiant.getNom()); 
		String sql ="SELECT * FROM correspondance INNER JOIN enseignant ON enseignant.id_enseignant =correspondance.id_enseignant INNER JOIN classe ON classe.id_classe =correspondance.id_classe INNER JOIN matiere ON matiere.id_matiere=correspondance.id_matiere INNER JOIN etudiant ON etudiant.id_classe=correspondance.id_classe WHERE enseignant.login='"+LoginController.login+"' AND enseignant.pwd='"+LoginController.pwd+"' AND matiere.libelle='"+SelectionEnseignantController.selectmatiere+"' AND etudiant.prenom='"+etudiant.getPrenom()+"' ";
		        
		Connection con = DataBaseAccess.getConnection();
		PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
		ResultSet resultSet = prepareStatement.executeQuery();		
   	    String nsi = ns.getText();    	 
   	    int ns1 = Integer.parseInt(nsi);
   	    
   	    
   	 		while(resultSet.next()) {
   	 		etudiant.setNset(ns.getText());
			PreparedStatement prepareStatement1 =(PreparedStatement) con.prepareStatement("INSERT INTO absence (id_etudiant,id_enseignant,id_matiere,numseance) VALUES ('"+resultSet.getInt(17)+"','"+resultSet.getInt(1)+"','"+resultSet.getInt(2)+"','"+ns1+"') ");
        	prepareStatement1.executeUpdate();
			
        	
        	dataet.add(new Etudiant(0,etudiant.getNom(),etudiant.getPrenom(),ns.getText(),"","",null));	
			
		}
   	 	
		con.close();
	     
		
		
		
		
		c3.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
		c4.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
		c5.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nset"));
		
		
		
		listedesabsences.setItems(dataet);
	
	}
	public void ici(ActionEvent e) throws Exception
	{
		
		String sql ="SELECT is_responsable FROM enseignant  WHERE enseignant.login='"+LoginController.login+"' AND enseignant.pwd='"+LoginController.pwd+"'";
		
		Connection con = DataBaseAccess.getConnection();
		PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
		ResultSet resultSet = prepareStatement.executeQuery();
		while(resultSet.next()) {
			if(resultSet.getInt(1)==1)
			{
				
			
			
			Stage primeryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/PageSelectionDeResponsable.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primeryStage.setScene(scene);
			primeryStage.show();
			((Node)e.getSource()).getScene().getWindow().hide();
			
			
		}
		
		}
		
		
		
		
		
	
	}
	public void retour(ActionEvent e) throws Exception 
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



//"INSERT INTO absence (id_etudiant,id_enseignant,id_matiere,numseance) VALUES ('?','?','?','?') ";






