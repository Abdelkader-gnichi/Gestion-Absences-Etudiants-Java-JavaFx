package application;

import java.util.*;

import dao.Members;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import lesclassesduprojet.Enseignant;
import lesclassesduprojet.Etudiant;
import lesclassesduprojet.Responsable;

public class LoginController {
	
	@FXML
    private RadioButton m1;

    @FXML
    private ToggleGroup membres;

    @FXML
    private RadioButton m2;

    @FXML
    private RadioButton m3;


    @FXML
    private TextField username;

    @FXML
    private PasswordField password;
    public static String login;
    public static String pwd;
	
/*public void statusDB(ActionEvent e) throws Exception{ //check sur la base 
	if(!AdminsDB.getConnection().isClosed()) {
		DBConLB.setText("Connected");
	}else {
		DBConLB.setText("Not Connected");
	}
}*/
	public void login(ActionEvent e) throws Exception{ //permet de login dans la base avec le principe de map 
		
		//etudiant
		List<Etudiant> list = Members.getEtudiant();
		Map<String ,String> map = new HashMap<String ,String>();
		
		//enseignant
		List<Enseignant> listens = Members.getEnseignant();
		Map<String ,String> mapens = new HashMap<String ,String>();
		
		//responsable
     	List<Responsable> listresp = Members.getResponsable();
    	Map<String ,String> mapresp = new HashMap<String ,String>();
		
		// ****if de l'etudiant *****
		if(membres.getSelectedToggle().equals(m1))
				{
	    for(Etudiant a:list) {
	    	map.put(a.getLogin(), a.getPassword());
	    }
	    if(map.containsKey(username.getText())) {
	    	
	    	String val1=map.get(username.getText());
	    	
	    	if(val1.equals(password.getText())) {
	    		
	    		//check.setText("Success");
	    		
	    		//AdminsDB.getConnection();
	    		
                login=username.getText();
                pwd=password.getText();
	    		Stage primeryStage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/application/PageEtudiant.fxml"));
	    		Scene scene = new Scene(root);
	    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    		primeryStage.setScene(scene);
	    		primeryStage.show();
	    		((Node)e.getSource()).getScene().getWindow().hide();
	    	}else {
	    		System.out.println("Faild try again wrong password");
		    	//check.setText("Faild try again");
		    }
	    }else {
	    	System.out.println("Faild try again wrong username ");
	    	//check.setText("Faild try again");
	    }
}
		// ****if de l'enseignant *****
		
		if(membres.getSelectedToggle().equals(m2))
		{
for(Enseignant a:listens) {
	mapens.put(a.getLogin(), a.getPassword());
}
if(mapens.containsKey(username.getText())) {
	
	String val2=mapens.get(username.getText());
	
	if(val2.equals(password.getText())) {
		
		//check.setText("Success");
		
		//AdminsDB.getConnection();
		
		 login=username.getText();
         pwd=password.getText();
		Stage primeryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/PageSelectionEnseignant.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primeryStage.setScene(scene);
		primeryStage.show();
		((Node)e.getSource()).getScene().getWindow().hide();
		
	}else {
		System.out.println("Faild try again wrong password");
    	//check.setText("Faild try again");
    }
}else {
	System.out.println("Faild try again wrong username ");
	//check.setText("Faild try again");
}
}
		// ****if de responsable *****
		if(membres.getSelectedToggle().equals(m3))
		{
for(Responsable a:listresp) {
	mapresp.put(a.getLogin(), a.getPassword());
}
if(mapresp.containsKey(username.getText())) {
	
	String val3=mapresp.get(username.getText());
	
	if(val3.equals(password.getText())) {
		
		//check.setText("Success");
		
		//AdminsDB.getConnection();
		
		 login=username.getText();
         pwd=password.getText();
		Stage primeryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/PageSelectionDeResponsable.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primeryStage.setScene(scene);
		primeryStage.show();
		((Node)e.getSource()).getScene().getWindow().hide();
	}else {
		System.out.println("Faild try again wrong password");
    	//check.setText("Faild try again");
    }
}else {
	System.out.println("Faild try again wrong username ");
	//check.setText("Faild try again");
}
}

	
	}
	

}
