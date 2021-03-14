import java.util.LinkedList;

public class SList {
    private LinkedList<Term> terms = new LinkedList<>();

    public int contains(String key) {
        if(terms.get(0).equals(key)) return 0;
        int l = 0, r = terms.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            System.out.println(terms.get(m));
            if(terms.get(m).toString().equals(key)) return m;

            if (terms.get(m).toString().compareTo(key) < 0) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    public Term get(int i){
        return terms.get(i);
    }


    public void insert(String str){
        if(terms.size() == 0){
            terms.add(new Term(str));
            return;
        }
        if(terms.get(0).compareTo(str) > 0) {
            terms.addFirst(new Term(str));
            return;
        }
        int i = 0;
        for(Term s : terms){
            if(i != 0 && s.compareTo(str) > 0){
                terms.add(i-1, new Term(str));
                return;
            }
            i++;
        }
        terms.addLast(new Term(str));
    }

    public int size(){
        return terms.size();
    }





}
