import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JanelaMain {
    

    @FXML
    protected void click(ActionEvent e){
        Main.mudaCena(Main.JANELAPREJOGO, (aClass)-> new JanelaPreJogo());

    }
}
