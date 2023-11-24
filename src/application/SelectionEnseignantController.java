package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class SelectionEnseignantController {
   //  **************************declaration*********************************
	@FXML
    private RadioButton Java;

    @FXML
    private ToggleGroup matiere;

    @FXML
    private RadioButton Base_de_donnees;

    @FXML
    private RadioButton Uml;

    @FXML
    private RadioButton PhP;

    @FXML
    private RadioButton Licence_fondamentale_en_informatique;

    @FXML
    private ToggleGroup filiere;

    @FXML
    private RadioButton Licence_fondamentale_en_physique;

    @FXML
    private RadioButton Licence_fondamentale_en_EEE;
    


    @FXML
    private RadioButton LFI1;

    @FXML
    private ToggleGroup niveau;

    @FXML
    private RadioButton LFI2;

    @FXML
    private RadioButton LFI3;

    
    
    public static String selectfiliere;
    public static String selectniveau;
    public static String selectmatiere;
    
    
    
    //*********************************code*************************************
    
    
    public void entrer(ActionEvent e) throws Exception
    {
       
    	if(filiere.getSelectedToggle().equals(Licence_fondamentale_en_informatique)|| (filiere.getSelectedToggle().equals(Licence_fondamentale_en_physique)) || (filiere.getSelectedToggle().equals(Licence_fondamentale_en_EEE)));
    	{
    		if(niveau.getSelectedToggle().equals(LFI1) || niveau.getSelectedToggle().equals(LFI2) || niveau.getSelectedToggle().equals(LFI3))
    		{
    			if(matiere.getSelectedToggle().equals(Java) || matiere.getSelectedToggle().equals(Base_de_donnees) || matiere.getSelectedToggle().equals(Uml) || matiere.getSelectedToggle().equals(PhP) )
    			{
    				
    				
    				selectfiliere=(((Node) filiere.getSelectedToggle()).getId());
    
    				selectniveau=(((Node) niveau.getSelectedToggle()).getId());
    				selectmatiere=(((Node) matiere.getSelectedToggle()).getId());
    				
    				
    				
    				Stage primeryStage = new Stage();
    	    		Parent root = FXMLLoader.load(getClass().getResource("/application/PageEnseignant.fxml"));
    	    		Scene scene = new Scene(root);
    	    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	    		primeryStage.setScene(scene);
    	    		primeryStage.show();
    	    		((Node)e.getSource()).getScene().getWindow().hide();
    			}
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   

