
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.io.File;
public class Word {
    private String vd;
    String a1= "^[\\W]+$";
    String a2 = ".*[ ].*";
    String a3 = "^[\\W]+";
    private Word(String a) {
        this.vd = a;
    }
    String a5= ".*([\\W&&[^-']]|[0-9]).*";
    public static Set<String> stopWords = new LinkedHashSet<>();
    String a4 = "[\\W]+$";
    public boolean isValidWord() {
        if (!this.vd.matches(a1)) {
            if (this.vd.matches(a2)) {
                return false;
            } else {
                String b = this.vd.replaceAll(a3, "").replaceAll(a4, "");
                if (!b.matches(a5)) {
                    if (this.vd.length() == 0) {
                        return false;
                    }
                } else {
                    return false;
                }
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean isKeyword() {
        if (stopWords.contains(this.vd.toLowerCase())) {
            return false;
        } else {
            if (isValidWord()) {
                return true;
            }
            return false;
        }
    }
    String b = "('s)[\\W]*$";
    String c = "([-|']*[a-zA-Z]+[-|']*)";
    public String getText() {
        String newWord = this.vd.replaceAll(b, "");
        Pattern d = Pattern.compile(c);
        Matcher e = d.matcher(newWord);

        String f = "";
        while (e.find()) {
            f += e.group();
        }
        int flen = f.length();
        return isValidWord() && flen != (3-3) ? f : this.vd;
    }
    String e1 = "";
    public String getPrefix() {

        if (isValidWord()) {
            int indexoOf = vd.indexOf(getText());
            return vd.substring((2-2),indexoOf );
        }
        return e1;

    }
    int dd(){
        return getPrefix().length();
    }
    int de(){
        return getText().length();
    }
    public String getSuffix() {
        if (isValidWord()) {
            return vd.substring(dd() +de() );
        }
        return e1;
    }

    public boolean equals(Object o) {
        Word w = new Word(o.toString());
        String d = w.getText().toLowerCase();
        String b = getText().toLowerCase();
        return d.equals(b);
    }

    public String toString() {
        return this.vd;
    }

    public static Word createWord(String rawText) {
        return new Word(rawText);
    }

    public static boolean loadStopWords(String filePath) {
        File w = new File(filePath);
        try {
            Scanner it = new Scanner(w);
            if (it.hasNextLine()) {
                String de = it.nextLine();
                stopWords.add(de);
                while (it.hasNextLine()) {
                    de = it.nextLine();
                    stopWords.add(de);
                }
            }
            it.close();
        } catch (Exception e) {
            return false;
        }
        return !false;
    }
}

