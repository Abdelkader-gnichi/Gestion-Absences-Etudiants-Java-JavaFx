package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dao.DataBaseAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import lesclassesduprojet.Etudiant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class ResponsableSuppressionController implements Initializable {
	
	private static String USER_NAME = "selsebiltrabelsi82@gmail.com";
			  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "bilselse"; // GMail password
    
    @FXML
    private TableView<Etudiant> tableAb2;

    @FXML
    private TableColumn<Etudiant,String> nom;

    @FXML
    private TableColumn<Etudiant,String> prenom;

    @FXML
    private TableColumn<Etudiant,String> na;

    @FXML
    private TableColumn<Etudiant,String> mail;
    @FXML
    private Label nomresp2;

    @FXML
    private Label prenomresp2;

    @FXML
    private Label niveauresp2;

    @FXML
    private Label filiereresp2;
	 public static ObservableList<Etudiant> annulationabsenceetudiantandenvoyermail= FXCollections.observableArrayList();
	 public ArrayList<Etudiant> listefinalasupprimer =new  ArrayList<Etudiant>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		    filiereresp2.setText(SelectionResponsableController.selectfiliereRES);
			niveauresp2.setText(SelectionResponsableController.selectniveauRES);
			nomresp2.setText(ResponsableController.nomresponsable);
			prenomresp2.setText(ResponsableController.prenomresponsable);
			
			
		 nom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
		 prenom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
		 na.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nset"));
		 mail.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("mail"));
		
		
		 tableAb2.setItems(annulationabsenceetudiantandenvoyermail);
		
	}
	public void confirmersuppression(ActionEvent e) throws Exception
	{
		for(Etudiant a:listefinalasupprimer)
		{
			
		
		System.out.println(a.getNom()); 
		System.out.println(a.getPrenom());
		System.out.println(a.getMail());
		
		
		    
		String sql ="DELETE absence FROM absence INNER JOIN etudiant ON etudiant.id_etudiant=absence.id_etudiant  WHERE  etudiant.email='"+a.getMail()+"' AND etudiant.prenom='"+a.getPrenom()+"' AND etudiant.nom='"+a.getNom()+"' AND absence.justifiee=1";  
				
		Connection con = DataBaseAccess.getConnection();
		PreparedStatement prepareStatement =(PreparedStatement) con.prepareStatement(sql);
	    prepareStatement.executeUpdate();	
	    
		
	   
		 	
		con.close();
	     
		}
    	annulationabsenceetudiantandenvoyermail.clear();

}
	public void confirmeremail(ActionEvent e) throws Exception
	{
		
         
        ArrayList<String> to = new ArrayList<String>(); // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!";

        
        
		for(Etudiant a:listefinalasupprimer)
		{
			
		to.add(a.getMail());
		System.out.println(a.getNom()); 
		System.out.println(a.getPrenom());
		System.out.println(a.getMail());
		
		
	
		}
		 Properties props = System.getProperties();
	       
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.user",  USER_NAME);
	        props.put("mail.smtp.password", PASSWORD);
	        props.put("mail.smtp.port", "465");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	        props.put("mail.smtp.debug", "true");
	        props.put("mail.smtp.socketFactory.port","465");
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.socketFactory.fallback", "false");
	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress( USER_NAME));
	            InternetAddress[] toAddress = new InternetAddress[to.size()];

	            // To get the array of addresses
	            for( int i = 0; i < to.size(); i++ ) {
	                toAddress[i] = new InternetAddress(to.get(i));
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }

	            message.setSubject(subject);
	            message.setText(body);
	            Transport transport = session.getTransport("smtp");
	            transport.connect("smtp.gmail.com", USER_NAME,PASSWORD);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
		
    	annulationabsenceetudiantandenvoyermail.clear();

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
	  		ResponsableSuppressionController.annulationabsenceetudiantandenvoyermail.clear();

	}
	
	public void addsuppressionfinal()
	{
		listefinalasupprimer.add(tableAb2.getSelectionModel().getSelectedItem());
	}
}
