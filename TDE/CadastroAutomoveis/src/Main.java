package TDE.CadastroAutomoveis.src;
import java.io.IOException;
import TDE.CadastroAutomoveis.src.controller.AutomovelController;
import TDE.CadastroAutomoveis.src.view.AutomovelView;

public class Main {
    public static void main(String[] args) {
        AutomovelController controller = new AutomovelController();
        AutomovelView view = new AutomovelView(controller);
        
        // Load data from file
        controller.loadData("dados.txt");
        
        // Start the user interaction loop
        view.showMenu();
        
        // Save data to file on exit
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                controller.saveData("dados.txt");
            } catch (IOException e) {
                System.err.println("Error saving data: " + e.getMessage());
            }
        }));
    }
}