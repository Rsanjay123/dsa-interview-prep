package DSAPREP;

import java.util.Scanner;

public class WorldChessChampionship {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while(t-- > 0) {
      int x = scan.nextInt();
      String result = scan.next();
      int carlsen = 0;
      int chef = 0;
      for(char ch : result.toCharArray()) {
        if(ch == 'C') {
          carlsen += 2;
        } else if (ch == 'N') {
          chef += 2;
        } else {
          carlsen += 1;
          chef += 1;
        }
      }
      long total = 100L * x;
      if(carlsen > chef) {
        System.out.println((60 * total) / 100);
      } else if(chef > carlsen) {
        System.out.println((40 * total) / 100);
      } else {
        System.out.println((55 * total) / 100);
      }
    }
  }
}
