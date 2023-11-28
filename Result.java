
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
    public class Result implements Comparable<Result> {
        private int m;
        private int n;
        private double p;
        private Doc q;
        private List<Match> e;

        public Result(Doc d, List<Match> matches) {
            this.q = d;
            this.e = matches;
            this.m = matches.size();
            this.n = www();
            this.p = aaa();
        }

        private double aaa() {
            int j = 0;
            int i = 0;
            do {
                if (i >= this.e.size()) break;
                j = j + e.get(i).getFirstIndex();
                ++i;
            } while (true);
            Integer a = e.size();
            return j / Integer.parseInt(String.valueOf(a));
        }

        private int www() {
            int tempTotal = 0;
            for (int i = 0; i < this.e.size(); ++i) {
                tempTotal += e.get(i).getFreq();
            }
            return tempTotal;
        }

        public List<Match> getMatches() {
            return this.e;
        }

        public int getTotalFrequency() {
            return this.n;
        }

        public double getAverageFirstIndex() {
            return this.p;
        }

        public Doc getDoc() {
            return this.q;
        }

        public String htmlHighlight() {
            List<Word> body = new ArrayList<Word>(q.getBody());
            StringBuilder k = new StringBuilder();
            k.append("<h3>");
            Iterator<Word> j = q.getTitle().iterator();
            if (j.hasNext()) {
                do {
                    Word h = j.next();
                    boolean g = false;
                    Iterator<Match> f = e.iterator();
                    if (f.hasNext()) {
                        do {
                            Match d = f.next();
                            Word s = d.getWord();
                            if (h.equals(s)) {
                                k.append(h.getPrefix()).append("<u>").append(h.getText()).append("</u>").append(h.getSuffix()).append(" ");
                                g = true;
                            }
                        } while (f.hasNext());
                    }
                    if (g) {
                    } else {
                        k.append(h).append(" ");
                    }
                } while (j.hasNext());
            }
            k = new StringBuilder(k.toString().trim());
            k.append("</h3>").append("<p>");
            int i = 0;
            if (i < body.size()) {
                do {
                    Word p = body.get(i);
                    boolean o = false;
                    int i1 = 0;
                    if (i1 < e.size()) {
                        do {
                            Match y = e.get(i1);
                            Word t = y.getWord();
                            if (p.equals(t)) {
                                k.append(p.getPrefix()).append("<b>");
                                k.append(p.getText()).append("</b>");
                                k.append(p.getSuffix()).append(" ");
                                o = true;
                            }
                            i1++;
                        } while (i1 < e.size());
                    }
                    if (!o) {
                        k.append(p).append(" ");
                    }
                    i++;
                } while (i < body.size());
            }
            k = new StringBuilder(k.toString().trim());
            k.append("</p>");
            return k.toString();
        }

        public int compareTo(Result o) {
            if (this.m <= o.m) {
                if (this.m == o.m) {
                    if (this.n <= o.n) {
                        if (this.n < o.n)
                            return 1;
                        else {
                            if (this.n != o.n) {
                                return 0;
                            }
                            if (this.p > o.p) {
                                return -1;
                            } else if (this.p < o.p)
                                return 1;
                        }
                    } else {
                        return -1;
                    }
                } else if (this.m < o.m)
                    return 1;
            } else {
                return -1;
            }
            return 0;
        }
    }

