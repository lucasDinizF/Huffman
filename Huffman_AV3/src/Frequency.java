import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Frequency {
    public void fileReader(File txt, MyFileP F) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(txt));

        int[] Count = new int[256];
        int character;

        while ((character = br.read()) != -1){
            if (character < 256){
                Count[character]++;
            }
        }
        br.close();

        for (int i = 0; i < Count.length; i++){
            if (Count[i] > 0){
                F.Enqueue((char) i, Count[i]);
            }
        }
    }
}