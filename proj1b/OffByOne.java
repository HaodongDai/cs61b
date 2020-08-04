public class OffByOne implements CharacterComparator {
    //* compare two characters and return true if they differ by 1 */
    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        if (diff == 1) {
            return true;
        } else {
            return false;
        }
    }
}
