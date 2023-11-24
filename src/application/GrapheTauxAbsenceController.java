package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.DataBaseAccess;
import javafx.fxml.Initializable;
import lesclassesduprojet.Absence;
import lesclassesduprojet.Etudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class GrapheTauxAbsenceController implements Initializable {
	 @FXML
	    private AnchorPane root;

	    @FXML
	    private CategoryAxis x;

	    @FXML
	    private NumberAxis y;
	    @FXML
	    private BarChart<?,?> barchartabsencestart;
	    
	   
	    

	   public static XYChart.Series set1 = new XYChart.Series();

	   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		barchartabsencestart.getData().add(set1);
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
	  		
 			set1.getData().clear();

	}
	
	
}

