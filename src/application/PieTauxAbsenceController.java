package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieTauxAbsenceController  implements Initializable {

	 
	 @FXML
	    private PieChart piechart;


	   public static ObservableList<PieChart.Data> piegraphe = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		piechart.setData(piegraphe);
	}
	public void retour(ActionEvent e) throws Exception 
	{
		
		 Stage primeryStage = new Stage();
	  		Parent root = FXMLLoader.load(getClass().getResource("/application/PageResponsable.fxml"));
	  		Scene scene = new Scene(root);
	  		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	  		primeryStage.setScene(scene);
	  		primeryStage.show();
	  		((Node)e.getSource()).getScene().getWindow().hide();
	  		piegraphe.clear();
	}
}
