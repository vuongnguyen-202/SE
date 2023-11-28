
public class Match implements Comparable<Match> {
    private Doc a;
    private Word b;
    private int c;
    private int d;

    public Match(Doc d, Word w, int freq, int firstIndex) {
        this.a = d;
        this.b = w;
        this.c = freq;
        this.d = firstIndex;
    }

    public Word getWord() {
        return this.b;
    }

    public int getFreq() {
        return this.c;
    }

    public void setFreq(int newFreq) {
        this.c = newFreq;
    }

    public int getFirstIndex() {
        return this.d;
    }

    public int compareTo(Match o) {
        if (this.getFirstIndex() <= o.getFirstIndex()) {
            if (o.getFirstIndex() > this.getFirstIndex()) {
                return -1;
            }
            return 0;
        }
        return 1;
    }
}
