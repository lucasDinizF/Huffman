import java.io.*;

public class Zip {
    public void zip(File archive, File target, Tree tree) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archive));
        StringBuilder text = new StringBuilder();
        int Char;

        while ((Char = br.read()) != -1) {
            text.append((char) Char);

        }
        br.close();

        StringBuilder textZip = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            textZip.append(tree.getVetor(c));

        }

        String treeZip = tree.treeCode(tree.getRoot());
        String Zipedtext = treeZip + textZip.toString();

        BufferedWriter bw = new BufferedWriter(new FileWriter(target));
        bw.write(Zipedtext);
        bw.close();

    }
}