/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengecekankesehatan;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author rismaintanw
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private JFXTextField idNama;
    @FXML
    private JFXTextField idTinggi;
    @FXML
    private JFXTextField idBB;
    @FXML
    private RadioButton idlaki;
    @FXML
    private RadioButton idPerempuan;
    @FXML
    private JFXButton proses;
    @FXML
    private JFXButton reset;
    @FXML
    private TextArea hasil;
    @FXML
    private TextArea saran;
    @FXML
    private TextField tfBB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Proses(ActionEvent event) {
        String tmp="";
       Double tinggi, berat, tinggiideal = null;
       tinggi = Double.valueOf(idTinggi.getText());
       berat = Double.valueOf(idBB.getText());
       String Nama = idNama.getText();
       
        if(!(idlaki.isSelected() || idPerempuan.isSelected())){
            JOptionPane.showMessageDialog(null, "Harap Pilih Paket Layanan");}
       else{
        if(idlaki.isSelected()){
        tinggiideal = (tinggi-110);
        }
        if(idPerempuan.isSelected()){
        tinggiideal = (tinggi-100);
        }
        
        tmp = Double.toString(tinggiideal.intValue());
        if(tinggiideal == berat)
        {
            tfBB.setText(tmp);
            hasil.setText("Nama "+ Nama + "\nBerat Badan Anda Ideal");
            saran.setText("Jaga Pola Makan Anda Setiap Hari");
        }
        else if(tinggiideal > berat)
        {
            tfBB.setText(tmp);
            hasil.setText("Nama "+ Nama + "\nBerat Badan Anda Tidak Ideal");
            saran.setText("Jaga Pola Makan Anda Setiap Hari");
        }
        else if(tinggiideal <berat)
        {
            tfBB.setText(tmp);
            hasil.setText("Nama "+ Nama + "\nBerat Badan Anda Terlalu kurus");
            saran.setText("Jaga Pola Makan Anda Setiap Hari");
        }
                    }   
    }

    @FXML
    private void Reset(ActionEvent event) {
        idNama.setText("");
        idTinggi.setText("");
        idBB.setText("");
        hasil.setText("");
        saran.setText("");
    }
    
}
