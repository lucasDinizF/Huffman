public class vetor {
    private char[] Char;
    private String[] codes;
    private int capacity;

    public vetor() {
        this.capacity = 256;
        this.Char = new char[this.capacity];
        this.codes = new String[this.capacity];

    }

    public void add(char c, String code) {
        int position = c % this.capacity;

        Char[position] = c;
        codes[position] = code;

    }

    public String get(char c) {
        int position = c % this.capacity;

        return codes[position];

    }

}