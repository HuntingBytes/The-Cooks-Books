package com.cooksbooks;

import java.util.Collection;
import java.util.HashMap;

public interface DataReceiver {
  void setInformation(HashMap<String, Object> information);
  Collection<String> requiredKeys();
}
