public class Tree {
    private NoP root;
    private vetor Vetor;

    public Tree(MyFileP Priority) {

        this.Vetor = new vetor();

        while (Priority.count > 1) {
            NoP left = Priority.Dequeue();
            NoP right = Priority.Dequeue();
            NoP Conc = new NoP(right.getPrioridade() + left.getPrioridade(), right, left);
            Priority.Enqueue(Conc);

        }

        root = Priority.Dequeue();
        codeGenerator(this.root, "");
    }

    public void codeGenerator(NoP node, String code) {
        if (node != null) {
            if(node.leaf()){
                Vetor.add(node.getElemento(), code);

            } else{
                codeGenerator(node.getEsquerda(), code + "0");
                codeGenerator(node.getDireita(), code + "1");
            }
        }
    }

    public String toBinary(char Char) {
        return String.format("%8s", Integer.toBinaryString(Char)).replace(' ', '0');
    }

    public String treeCode(NoP root) {
        if (root == null) {
            return "";
        } if (root.leaf()) {
            return "1" + toBinary(root.getElemento());

        } else {
            return "0" + treeCode(root.getEsquerda()) + treeCode(root.getDireita());
        }
    }

    public static NoP rebuiltTree(String Text, int[] i) {
        if (Text.charAt(i[0]) == '1'){
            i[0]++;
            String newText = Text.substring(i[0], i[0] + 8);
            i[0] += 8;
            char letter = (char)Integer.parseInt(newText, 2);
            return new NoP(letter, 0);
        } else{
            i[0]++;
            NoP left = rebuiltTree(Text, i);
            NoP right = rebuiltTree(Text, i);
            return new NoP(0, right, left);
        }
    }

    public static String decodeMessage(String Text, NoP root) {
        StringBuilder sb = new StringBuilder();
        NoP current = root;
        for (int i = 0; i < Text.length(); i++) {
            current = Text.charAt(i) == '0' ? current.getEsquerda() : current.getDireita();

            if (current.leaf()) {
                sb.append(current.getElemento());
                current = root;

            }
        }
        return sb.toString();
    }

    public NoP getRoot() {
        return root;
    }

    public String getVetor(char c) {
        return Vetor.get(c);
    }

}