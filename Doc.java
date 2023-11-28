
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
public class Doc {
    private List<Word> a = new ArrayList<>();
    private List<Word> b = new ArrayList<>();

    public Doc(String content) {
        String[] c = content.split("\n");
        String[] d = c[0].split(" ");
        for (int e = 0, g = d.length; g > e; e++) {
            String f = d[e];
            this.a.add(Word.createWord(f));
        }
        String[] s = c[1].split(" ");
        for (int g = 0, h = s.length; h > g; g++) {
            String body = s[g];
            this.b.add(Word.createWord(body));
        }

    }

    public List<Word> getTitle() {
        return this.a;
    }

    public List<Word> getBody() {
        return this.b;
    }

    public boolean equals(Object o) {
        Doc q = (Doc) o;
        boolean w = IntStream.range(0, this.a.size()).anyMatch(i -> !this.a.get(i).equals(q.getTitle().get(i))) ? false : !false;
        int i = 0;
        while (i < this.b.size()) {
            if (!this.b.get(i).equals(q.getBody().get(i))) {
                w = false;
                break;
            }
            ++i;
        }
        return w;
    }
}
