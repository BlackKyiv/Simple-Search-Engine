import java.util.LinkedList;

public class Term implements Comparable<String> {
    private String word;
    private LinkedList<String> indexes= new LinkedList<>();

    public Term(String word){
        this.word = word.toLowerCase();

        String temp = word+"$";
        insert(temp);
        for(int i = 0; i<word.length(); i++){
            char firstChar = temp.charAt(0);
            temp = temp.substring(1) + firstChar;
            insert(temp);
        }
    }

    public boolean contains(String key) {
        int l = 0, r = indexes.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            String s = indexes.get(m);
            int length = Math.min(s.length(), key.length());
            for(int i = 0; i<length; i++){
                if(key.charAt(i) == '*') return true;
                else if(key.charAt(i) != s.charAt(i)) break;
            }

            if (indexes.get(m).compareTo(key) < 0) l = m + 1;
            else r = m - 1;
        }
        return false;
    }

    private void insert(String str){
        if(indexes.size()==0){
            indexes.add(str);
            return;
        }
        if(indexes.get(0).compareTo(str) >0) {
            indexes.addFirst(str);
            return;
        }
        int i = 0;
        for(String s : indexes){
            if(i != 0 && s.compareTo(str) > 0){
                indexes.add(i-1, str);
                return;
            }
            i++;
        }
        indexes.addLast(str);
    }

    public static void main(String[] args){
        Term t = new Term("man");
        //m*n
        System.out.println(t.contains("n$m*"));

    }



    @Override
    public int compareTo(String o) {
        return this.word.compareTo(o);
    }

    public boolean equals(Object o){
        if(o == this) return true;
        else if(o instanceof Term){
            Term t = (Term) o;
            if(t.word.equals(this.word)) return true;
        }
        else if(o instanceof String){
            String t = (String) o;
            if(t.equals(this.word)) return true;
        }
        return false;

    }

    public int hashCode(){
        return this.word.hashCode();
    }

    @Override
    public String toString() {
        return this.word;
    }
}


