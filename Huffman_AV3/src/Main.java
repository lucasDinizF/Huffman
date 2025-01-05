import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        boolean parada = true;

        System.out.println("Escolha uma das opções:");
        System.out.println("Opção 1: Apenas compressão");
        System.out.println("Opção 2: Apenas descompressão");
        System.out.println("Opção 3: Todos juntos");
        System.out.println("Opção 4: Sair do programa");


        while (parada) {
            int n = sc.nextInt();
            if (n == 1){
                File text = new File("C:\\Users\\lucas\\IdeaProjects\\Huffman_AV3\\Texto.txt");
                File Ziped = new File("C:\\Users\\lucas\\IdeaProjects\\Huffman_AV3\\Zip.txt");

                MyFileP FileP = new MyFileP();
                Frequency frequency = new Frequency();
                frequency.fileReader(text, FileP);

                Tree tree = new Tree(FileP);

                Zip zip = new Zip();

                zip.zip(text, Ziped, tree);

                System.out.println("Compressão feita com sucesso!");

            }else if (n == 2){
                UnZip Unzip = new UnZip();
                File UnZiped = new File("C:\\Users\\lucas\\IdeaProjects\\Huffman_AV3\\Unzip.txt");
                File Ziped = new File("C:\\Users\\lucas\\IdeaProjects\\Huffman_AV3\\Zip.txt");

                Unzip.unzip(Ziped, UnZiped);

                System.out.println("Descompressão feita com sucesso!");

            }else if (n == 3){
                File text = new File("C:\\Users\\lucas\\IdeaProjects\\Huffman_AV3\\Texto.txt");
                File Ziped = new File("C:\\Users\\lucas\\IdeaProjects\\Huffman_AV3\\Zip.txt");
                File UnZiped = new File("C:\\Users\\lucas\\IdeaProjects\\Huffman_AV3\\Unzip.txt");

                MyFileP FileP = new MyFileP();
                Frequency frequency = new Frequency();
                frequency.fileReader(text, FileP);

                Tree tree = new Tree(FileP);

                Zip zip = new Zip();

                zip.zip(text, Ziped, tree);

                UnZip Unzip = new UnZip();

                Unzip.unzip(Ziped, UnZiped);

                System.out.println("Compressão e descompressão feita com sucesso!");

            }else {
                System.out.println("Obrigado pela atenção! Muito obrigado pelo semestre Gilson!!");


                parada = false;
            }
        }
    }
}