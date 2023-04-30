import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaLogin extends Application {

    private TextField tfUsuario;
    private PasswordField pfSenha;
    private Button btEntrar;

    @Override
    public void start(Stage primaryStage) {

        // Cria os componentes da tela
        Label lbUsuario = new Label("Usuário:");
        Label lbSenha = new Label("Senha:");
        tfUsuario = new TextField();
        pfSenha = new PasswordField();
        btEntrar = new Button("Entrar");

        // Adiciona os componentes ao painel
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.add(lbUsuario, 0, 1);
        gridPane.add(tfUsuario, 1, 1);
        gridPane.add(lbSenha, 0, 2);
        gridPane.add(pfSenha, 1, 2);
        gridPane.add(btEntrar, 1, 3);

        // Configura o ouvinte de eventos para o botão
        btEntrar.setOnAction(e -> fazerLogin());

        // Cria a cena e exibe a janela
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void fazerLogin() {
        String usuario = tfUsuario.getText();
        String senha = pfSenha.getText();

        if (usuario.equals("admin") && senha.equals("admin")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bem-vindo");
            alert.setHeaderText("Login realizado com sucesso");
            alert.setContentText("Bem-vindo, " + usuario + "!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de login");
            alert.setHeaderText("Usuário ou senha inválidos");
            alert.setContentText("Por favor, verifique suas credenciais e tente novamente.");
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}