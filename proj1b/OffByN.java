public class OffByN  implements CharacterComparator {
    //declare variables
    private int N;

    public OffByN(int N) {
        this.N = N;
    }

    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        if (diff == N) {
            return true;
        } else {
            return false;
        }
    }
}
