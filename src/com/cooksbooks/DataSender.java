package com.cooksbooks;

import java.util.HashMap;

// Captura a infomacao a ser passada para a proxima tela
public interface DataSender {
  HashMap<String, Object> getInformation();
}
