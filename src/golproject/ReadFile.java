package golproject;

import java.io.*;
import java.util.*;

public class ReadFile {

    public static void main(String[] args) throws FileNotFoundException,IOException{

        File filetoread = new File(args[0]);

        FileReader fis = new FileReader(filetoread);
        BufferedReader br = new BufferedReader(fis);

        int[] gridsize = new int[2];
        int[] start = new int[2];
        int Gen = 0;
        Boolean startpos = false;
        int astrixcountcheck = 0;
        int astrixcount = 0;
        int[][] position;
        int c = 0;
        position = new int[4][4];

        while(true){
            String line = br.readLine();
            if(null == line){
                break;
            }

            if (line.contains("#")){
                continue;
            }
            if (line.contains("GRID")){
                String a = line.replaceAll("[a-zA-Z]", "");
                String[] values = a.split(" ");
                int[] value = new int[2];
                value[0] = Integer.parseInt(values[1]);
                value[1] = Integer.parseInt(values[2]);

                gridsize[0] = value[0];
                gridsize[1] = value[1];
                
            }
            if (line.contains("START")){
                String b = line.replaceAll("[a-zA-Z]", "");
                String[] values = b.split(" ");
                int[] value = new int[2];
                value[0] = Integer.parseInt(values[1]);
                value[1] = Integer.parseInt(values[2]);
                start[0] = value[0];
                start[1] = value[1];
            }

            if (line.contains("*")){
                int count1 = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '*') {
                        count1++;
                    }
                }
                //check if the start position is involved
                if (line.length() < count1){
                    startpos = false;
                }
                if (line.length() == count1){
                    startpos = true;
                }
                int[] subsequentlines = new int[line.length()];

                if (line.charAt(0)== '*'){
                    subsequentlines[0] = 1;
                }
                for (int i = 1;i<line.length();i++){
                    if(line.charAt(i) == '*'){
                        subsequentlines[i] = 1;
                    }
                }
                for (int h=0; h < subsequentlines.length;h++){
                    position[c][h] = subsequentlines[h];
                }
                c++;


                // System.out.println(count1);
                // System.out.println(startpos);
                // System.out.println(line.length());
                // System.out.println(subsequentlines.length);
                //System.out.println(Arrays.toString(subsequentlines));
            
            }}
        BoardCreation test = new BoardCreation();
        Gol game = new Gol();
        game.Gol(test.BoardCreation(gridsize,start,position),5,gridsize);
        }
}
