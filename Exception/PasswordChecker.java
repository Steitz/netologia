public class PasswordChecker {
    private int minLength;
    private int maxRepeat;
    private String password;
    boolean result;
    //public PasswordChecker () {
    //}
    public boolean setMinLength (int minLength) {
        if (minLength<0) {
            throw new IllegalArgumentException("Ошибка: "+ minLength+" число отрицательное " );
        }
        this.minLength = minLength;
        return true;
    }
    public boolean setMaxRepeats (int maxRepeats) {
        if (maxRepeats<=0) {
            throw new IllegalArgumentException("Ошибка: "+ maxRepeats+" число должно быть положительное " );
        }
        this.maxRepeat = maxRepeats;
        return true;
    }
}
