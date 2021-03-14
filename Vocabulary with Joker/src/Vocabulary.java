public class Vocabulary {
    private SList terms = new SList();


    public static void main(String[] args){
        Vocabulary v = new Vocabulary();
        v.terms.insert("lolkeke");
        v.terms.insert("lolkedsk");
        v.terms.insert("lolkek");



        System.out.println(v.terms.contains("lolkek"));

    }







}
