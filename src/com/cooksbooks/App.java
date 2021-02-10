package com.cooksbooks;

import com.cooksbooks.gui.ScreenManager;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

public final class App extends Application {

  private static ScreenManager screenManager;

  static {
    try {
      screenManager = ScreenManager.getInstancia();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) throws Exception {
    screenManager.setStagePrincipal(stage);
    screenManager.abrirLogin();
  }

}
