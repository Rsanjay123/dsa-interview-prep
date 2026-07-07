package DSAPREP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SecretMessage {

  public static void decodeSecretMessage(String docUrl) throws Exception {
    URL url = new URL(docUrl);
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(url.openStream())
    );
    Map<String, Character> grid = new HashMap<>();
    int maxX = 0;
    int maxY = 0;
    String line;
    while((line = reader.readLine()) != null){
      line = line.trim();
      if(line.isEmpty() || line.startsWith("Character") || line.startsWith("-")){
        if(!line.isEmpty()){
          continue;
        }
      }
      String[] parts = line.split("\\s+");
      if(parts.length >= 3){
        try {
          char ch = parts[0].charAt(0);
          int x = Integer.parseInt(parts[1]);
          int y = Integer.parseInt(parts[2]);
          grid.put(x + "," + y, ch);
          if (x > maxX) maxX = x;
          if (y > maxY) maxY = y;
        }catch (NumberFormatException e){
        }
      }
    }
    reader.close();
    for(int row = 0; row <= maxY; row++){
      StringBuilder sb = new StringBuilder();
      for(int col = 0; col <= maxX; col++){
        char ch = grid.getOrDefault(col + "," + row, ' ');
        sb.append(ch);
      }
      System.out.println(sb);
    }
  }

  public static void main(String[] args) throws Exception {
    String docUrl = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub";
    decodeSecretMessage(docUrl);
  }
}