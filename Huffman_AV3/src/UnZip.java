import java.io.*;

public class UnZip {
    public void unzip(File textZip, File textUnzip) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(textZip));
        StringBuilder sb = new StringBuilder();


        int character;
        while ((character = br.read()) != -1) {
            sb.append((char) character);

        }
        br.close();

        String text = sb.toString();
        int[] i = {0};
        NoP root = Tree.rebuiltTree(text, i);
        String textZipped = text.substring(i[0]);

        String textUnzipped = Tree.decodeMessage(textZipped, root);

        BufferedWriter bw = new BufferedWriter(new FileWriter(textUnzip));
        bw.write(textUnzipped);
        bw.close();

    }
}