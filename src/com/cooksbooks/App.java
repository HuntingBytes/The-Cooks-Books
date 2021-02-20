package com.cooksbooks;

import com.cooksbooks.gui.ScreenManager;
import javafx.application.Application;
import javafx.stage.Stage;

public final class App extends Application {

  private static final ScreenManager screenManager = ScreenManager.getInstancia();

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) {
    screenManager.setStagePrincipal(stage);
    screenManager.iniciarTelas();
  }
}
