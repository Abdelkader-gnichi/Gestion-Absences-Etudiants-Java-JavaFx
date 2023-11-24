package application;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import dao.DataBaseAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lesclassesduprojet.Absence;
import lesclassesduprojet.Classe;
import lesclassesduprojet.Enseignant;
import lesclassesduprojet.Etudiant;
import lesclassesduprojet.Matiere;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;

	
	  
	

public class ResponsableController implements Initializable {

	 @FXML
	    private RadioButton filiere;

	    @FXML
	    private ToggleGroup selectiongraphe;

	    @FXML
	    private RadioButton classe;

	    @FXML
	    private RadioButton niveau;
	    
	   
//*****************************************
    @FXML
    private TableView<Absence> tableAb;


    @FXML
    private TableColumn<Absence, String> c1;

    @FXML
    private TableColumn<Absence,String> c2;

    @FXML
    private TableColumn<Absence, String> c3;

    @FXML
    private TableColumn<Absence,String> c4;

    @FXML
    private TableColumn<Absence, String> c5;

    @FXML
    private TableColumn<Absence, String> c6;
    
    @FXML
    private Label nomresp;

    @FXML
    private Label prenomresp;

    @FXML
    private Label niveauresp;

    @FXML
    private Label filiereresp;

    public static String nomresponsable;
    public static String prenomresponsable;
    public 	Boolean checkverifetudiant=true;

    public ObservableList<Absence> data = FXCollections.observableArrayList();
    public  ArrayList <Absence> etudiantselected =new  ArrayList<Absence>();
    public 	 ArrayList<Integer> etudiantjustif = new  ArrayList<Integer>();
    

    @Override
    public void initialize(URL location,ResourceBundle resources) {
    	
    	try {
    		       
    				
    		String sql ="SELECT * FROM absence INNER JOIN etudiant ON etudiant.id_etudiant =absence.id_etudiant INNER JOIN enseignant ON enseignant.id_enseignant =absence.id_enseignant INNER JOIN matiere ON matiere.id_matiere=absence.id_matiere INNER JOIN classe ON etudiant.id_classe=classe.id_classe  WHERE  classe.filiere='"+SelectionResponsableController.selectfiliereRES+"' AND classe.libelle='"+SelectionResponsableController.selectniveauRES+"' ";
			
    		String sql2="SELECT * FROM responsable WHERE  responsable.login='"+LoginController.login+"' AND responsable.pwd='"+LoginController.pwd+"'";
    		String sql3="SELECT * FROM enseignant Where enseignant.login='"+LoginController.login+"' AND enseignant.pwd='"+LoginController.pwd+"'";
			Connection con = DataBaseAccess.getConnection();
			PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();
			PreparedStatement prepareStatement1 =(PreparedStatement) con.prepareStatement(sql2);
			ResultSet resultSet1 = prepareStatement1.executeQuery();
			PreparedStatement prepareStatement2 =(PreparedStatement) con.prepareStatement(sql3);
			ResultSet resultSet2 = prepareStatement2.executeQuery();
			while(resultSet2.next()) {
				prenomresp.setText(resultSet2.getString(2));
			    nomresp.setText(resultSet2.getString(3));
			    
			    nomresponsable=resultSet2.getString(3);
			    prenomresponsable=resultSet2.getString(2);
			}
			
		
			while(resultSet1.next()) {
				prenomresp.setText(resultSet1.getString(2));
			    nomresp.setText(resultSet1.getString(3));
			    
			    nomresponsable=resultSet1.getString(3);
			    prenomresponsable=resultSet1.getString(2);
			}
			while(resultSet.next()) {
				Classe classe=new Classe(resultSet.getInt(25),resultSet.getString(26),resultSet.getInt(27),resultSet.getString(28));
				Etudiant etudiant=new Etudiant(resultSet.getInt(8),resultSet.getString(9), resultSet.getString(10),resultSet.getString(11),resultSet.getString(12), resultSet.getString(13),classe);
				Enseignant enseignant=new Enseignant(resultSet.getInt(16),resultSet.getString(17),resultSet.getString(18),resultSet.getString(19),resultSet.getString(20),resultSet.getInt(21));
				Matiere matiere=new Matiere(resultSet.getInt(23), resultSet.getString(24));
			       data.add(new Absence(etudiant, enseignant, matiere, resultSet.getInt(4), resultSet.getString(5),1,resultSet.getInt(6)));			  
			       filiereresp.setText(resultSet.getString(28));
			       niveauresp.setText(resultSet.getString(26));
    	}
    	}

     catch(Exception e) {
		e.printStackTrace();
	                    }
    	c1.setCellValueFactory(new PropertyValueFactory<Absence,String>("date"));
    	c2.setCellValueFactory(new PropertyValueFactory<Absence,String>("nometud"));
		c3.setCellValueFactory(new PropertyValueFactory<Absence,String>("prenometud"));
		c4.setCellValueFactory(new PropertyValueFactory<Absence,String>("matiereet"));
		c5.setCellValueFactory(new PropertyValueFactory<Absence,String>("nomprof"));
		c6.setCellValueFactory(new PropertyValueFactory<Absence,String>("justifiee"));
		
		
		Comparator<Absence> comparator = Comparator.comparingInt(Absence::getJustifiee); 
		
	    comparator = comparator.reversed();
		
		FXCollections.sort(data, comparator);

		
		tableAb.setItems(data);
		
    
    	}
    
    
    
   
public void imprimeListeAbsents(Event e) 
{
	PrinterJob pJ = PrinterJob.createPrinterJob();

	if (pJ != null) {
		 
	   
	    boolean success = pJ.showPrintDialog(((Node)(e.getSource())).getScene().getWindow());// this is the important line
	    if (success) {
	    	 // Imprime la zone texte
	        boolean printed = pJ.printPage(tableAb);

	        if (printed) {
	        	pJ.endJob();
	        }
	    }
	}
	
}
public void supprimer(ActionEvent e) throws Exception
{   
	
	for(Absence a: etudiantselected)
	{
		System.out.println(a.getPrenometud()); 	
	    System.out.println(a.getNometud()); 
	
	String sql ="SELECT  etudiant.prenom,etudiant.nom,etudiant.email,absence.justifiee,absence.date,classe.filiere,classe.libelle, COUNT(*) FROM absence INNER JOIN enseignant ON enseignant.id_enseignant =absence.id_enseignant INNER JOIN matiere ON matiere.id_matiere=absence.id_matiere INNER JOIN etudiant ON etudiant.id_etudiant=absence.id_etudiant INNER JOIN classe ON classe.id_classe=etudiant.id_classe WHERE etudiant.prenom='"+a.getPrenometud()+"' AND etudiant.nom='"+a.getNometud()+"' AND absence.justifiee=1 GROUP BY etudiant.prenom";  
			
	Connection con = DataBaseAccess.getConnection();
	PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
	ResultSet resultSet = prepareStatement.executeQuery();		
	
	 		while(resultSet.next()) {
	 			etudiantjustif.add((Integer)resultSet.getInt(4));
				Etudiant etudiant=new Etudiant(0,resultSet.getString(2), resultSet.getString(1),resultSet.getString(8),"", resultSet.getString(3),null);
				ResponsableSuppressionController.annulationabsenceetudiantandenvoyermail.add(new Etudiant(0,etudiant.getNom(),etudiant.getPrenom(),etudiant.getNset(), "",etudiant.getMail(),null));	
			    
		
	}   
	 	
	con.close();
	}
	for(Integer i :etudiantjustif)
	{
		
	  if((int) i==0)
	  {
		  checkverifetudiant=false;
		  break;
	  }
}
	if(checkverifetudiant) {
	Stage primeryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/PageResponsableSuppressionEnvoieMail.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primeryStage.setScene(scene);
		primeryStage.show();
		((Node)e.getSource()).getScene().getWindow().hide();
	}
     
	  
		 

}
public void envoyermail(ActionEvent e) throws Exception
{  
	
	
	for(Absence a: etudiantselected)
	{
		System.out.println(a.getPrenometud()); 	
	    System.out.println(a.getNometud()); 
	    
	
	
	String sql ="SELECT  etudiant.prenom,etudiant.nom,etudiant.email,absence.justifiee,absence.date,classe.filiere,classe.libelle, COUNT(*) FROM absence INNER JOIN enseignant ON enseignant.id_enseignant =absence.id_enseignant INNER JOIN matiere ON matiere.id_matiere=absence.id_matiere INNER JOIN etudiant ON etudiant.id_etudiant=absence.id_etudiant INNER JOIN classe ON classe.id_classe=etudiant.id_classe WHERE etudiant.prenom='"+a.getPrenometud()+"' AND etudiant.nom='"+a.getNometud()+"' AND absence.justifiee=0 GROUP BY etudiant.prenom";  
			
	Connection con = DataBaseAccess.getConnection();
	PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
	ResultSet resultSet = prepareStatement.executeQuery();		
	
	 		while(resultSet.next()) {
	 			
	 			etudiantjustif.add((Integer) resultSet.getInt(4));
				Etudiant etudiant=new Etudiant(0,resultSet.getString(2), resultSet.getString(1),resultSet.getString(8),"", resultSet.getString(3),null);
				ResponsableSuppressionController.annulationabsenceetudiantandenvoyermail.add(new Etudiant(0,etudiant.getNom(),etudiant.getPrenom(),etudiant.getNset(), "",etudiant.getMail(),null));	
			    
		
	}   
		
	con.close();
	}
	 
	for(Integer i :etudiantjustif)
	{
		
	  if((int) i==1)
	  {
		  checkverifetudiant=false;
		  break;
	  }
}
	if(checkverifetudiant) {
	Stage primeryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/PageResponsableSuppressionEnvoieMail.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primeryStage.setScene(scene);
		primeryStage.show();
		((Node)e.getSource()).getScene().getWindow().hide();
	}
}
public void tableemailclick()
{
	etudiantselected.add(tableAb.getSelectionModel().getSelectedItem());

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
public void graphe (ActionEvent e) throws Exception
{
	String sql = "";
	
	if(selectiongraphe.getSelectedToggle().equals(filiere))
	{
	
	sql ="SELECT classe.filiere,classe.libelle,classe.niveau,COUNT(*) FROM absence INNER JOIN etudiant ON etudiant.id_etudiant=absence.id_etudiant INNER JOIN classe ON classe.id_classe=etudiant.id_classe GROUP BY classe.filiere"; 
	Connection con = DataBaseAccess.getConnection();
	PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
	ResultSet resultSet = prepareStatement.executeQuery();		
	
	 		while(resultSet.next()) {
	 			
	 			GrapheTauxAbsenceController.set1.getData().add(new XYChart.Data(resultSet.getString(1),resultSet.getInt(4)));
	 			
	}   
		 	con.close();
	}
	
	
	
	
	
	
	if(selectiongraphe.getSelectedToggle().equals(classe))
	{
	sql ="SELECT classe.filiere,classe.libelle,classe.niveau,COUNT(*) FROM absence INNER JOIN etudiant ON etudiant.id_etudiant=absence.id_etudiant INNER JOIN classe ON classe.id_classe=etudiant.id_classe GROUP BY classe.libelle"; 
	     Connection con = DataBaseAccess.getConnection();
			PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();		
			
			 		while(resultSet.next()) {
			 			GrapheTauxAbsenceController.set1.getData().add(new XYChart.Data(resultSet.getString(2),resultSet.getInt(4)));
					 	

			 		}   
			 		con.close();
	}
	
	
	
	
	
	if(selectiongraphe.getSelectedToggle().equals(niveau))
	{
     sql ="SELECT classe.filiere,classe.libelle,classe.niveau,COUNT(*) FROM absence INNER JOIN etudiant ON etudiant.id_etudiant=absence.id_etudiant INNER JOIN classe ON classe.id_classe=etudiant.id_classe GROUP BY classe.niveau"; 
	     Connection con = DataBaseAccess.getConnection();
			PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();		
			
			 		while(resultSet.next()) {
			 			GrapheTauxAbsenceController.set1.getData().add(new XYChart.Data(resultSet.getString(3),resultSet.getInt(4)));
			
			 		}   
				 	con.close();

	}
	
	 Stage primeryStage = new Stage();
  		Parent root = FXMLLoader.load(getClass().getResource("/application/PageGraphique.fxml"));
  		Scene scene = new Scene(root);
  		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
  		primeryStage.setScene(scene);
  		primeryStage.show();
  		((Node)e.getSource()).getScene().getWindow().hide();
}
//*****************************************************************************************************//

        public void pie(ActionEvent e) throws Exception
        {
        	String sql = "";
        	
        	if(selectiongraphe.getSelectedToggle().equals(filiere))
        	{
        	
        	sql ="SELECT classe.filiere,classe.libelle,classe.niveau,COUNT(*) FROM absence INNER JOIN etudiant ON etudiant.id_etudiant=absence.id_etudiant INNER JOIN classe ON classe.id_classe=etudiant.id_classe GROUP BY classe.filiere"; 
        	Connection con = DataBaseAccess.getConnection();
        	PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
        	ResultSet resultSet = prepareStatement.executeQuery();		
        	
        	 		while(resultSet.next()) {
        	 			
        	 			PieTauxAbsenceController.piegraphe.add(new PieChart.Data(resultSet.getString(1),resultSet.getInt(4)));
        	 			
        	 			
        	}   
        		 	con.close();
        	}
        	
        	
        	
        	
        	
        	
        	if(selectiongraphe.getSelectedToggle().equals(classe))
        	{
        		
        	sql ="SELECT classe.filiere,classe.libelle,classe.niveau,COUNT(*) FROM absence INNER JOIN etudiant ON etudiant.id_etudiant=absence.id_etudiant INNER JOIN classe ON classe.id_classe=etudiant.id_classe GROUP BY classe.libelle"; 
        	     Connection con = DataBaseAccess.getConnection();
        			PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
        			ResultSet resultSet = prepareStatement.executeQuery();		
        			
        			 		while(resultSet.next()) {
        			 			PieTauxAbsenceController.piegraphe.add(new PieChart.Data(resultSet.getString(2),resultSet.getInt(4)));
        					 	

        			 		}   
        			 		con.close();
        	}
        	
        	
        	
        	
        	
        	if(selectiongraphe.getSelectedToggle().equals(niveau))
        	{
             sql ="SELECT classe.filiere,classe.libelle,classe.niveau,COUNT(*) FROM absence INNER JOIN etudiant ON etudiant.id_etudiant=absence.id_etudiant INNER JOIN classe ON classe.id_classe=etudiant.id_classe GROUP BY classe.niveau"; 
        	     Connection con = DataBaseAccess.getConnection();
        			PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
        			ResultSet resultSet = prepareStatement.executeQuery();		
        			
        			 		while(resultSet.next()) {
        			 			PieTauxAbsenceController.piegraphe.add(new PieChart.Data(resultSet.getString(3),resultSet.getInt(4)));
        			
        			 		}   
        				 	con.close();

        	}
        	
        	 Stage primeryStage = new Stage();
          		Parent root = FXMLLoader.load(getClass().getResource("/application/PieGraphe.fxml"));
          		Scene scene = new Scene(root);
          		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
          		primeryStage.setScene(scene);
          		primeryStage.show();
          		((Node)e.getSource()).getScene().getWindow().hide();
          		
        }

}





		
		
	


	