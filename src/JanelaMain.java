import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaMain {

    @FXML
    protected void click(ActionEvent e){
        Main.mudaCena("jogo");
    }
}
