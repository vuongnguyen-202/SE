
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Engine {
    private List<Doc> a = new ArrayList<Doc>();

    public int loadDocs(String dirname) {
        File dir = new File(dirname);
        File[] loadedDocs = dir.listFiles();

        for (File file : loadedDocs) {
            String text = "";

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null) {
                    text += line + "\n";
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Doc doc = new Doc(text);
            a.add(doc);
        }
        return loadedDocs.length;
    }

    public Doc[] getDocs() {
        return this.a.toArray(new Doc[this.a.size()]);
    }

    public List<Result> search(Query q) {

        List<Result> a;
        a = new ArrayList<Result>();
        Doc[] b;
        b = getDocs();

        Arrays.stream(b).forEachOrdered(d -> {
            List<Match> c;
            c = q.matchAgainst(d);
            if (c.size() <= 0) {
                return;
            }
            a.add(new Result(d, c));
        });
        Collections.sort(a);
        return a;
    }

    public String htmlResult(List<Result> results) {
        StringBuilder a = new StringBuilder();
        for (Result result : results) {
            String b = result.htmlHighlight();
            a.append(b);
        }
        return String.valueOf(a);
    }
}
