
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Query {
    private List<Word> a = new ArrayList<Word>();

    public Query(String searchPhrase) {
        Arrays.stream(searchPhrase.split(" ")).map(Word::createWord).filter(Word::isKeyword).forEachOrdered(b -> this.a.add(b));
    }

    public List<Word> getKeywords() {
        return this.a;
    }

    private List<Word> c(List<Word> title, List<Word> body) {
        List<Word> y = new ArrayList<Word>();
        for (List<Word> words : Arrays.asList(title, body)) {
            y.addAll(words);
        }
        return y;
    }

    public List<Match> matchAgainst(Doc d) {
        List<Match> r = new ArrayList<Match>();
        List<Word> t = c(d.getTitle(), d.getBody());
        int j = 0, aSize = a.size();
        if (j < aSize) {
            do {
                Word q = a.get(j);
                int w = 0;
                int e = t.indexOf(q);
                int i = 0;
                if (i < t.size()) {
                    do {
                        if (q.equals(t.get(i))) {
                            ++w;
                        }
                        if (w == 0)
                            e = i + 1;
                        ++i;
                    } while (i < t.size());
                }
                if (w > 0) {
                    r.add(new Match(d, q, w, e));
                }
                j++;
            } while (j < aSize);
        }
        Collections.sort(r);
        return r;
    }

}
