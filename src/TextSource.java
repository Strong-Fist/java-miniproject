import java.util.Vector;

public class TextSource {
    private Vector<String> v = new Vector<String>();

    public TextSource(){
        v.add("장민권");
        v.add("김경순");
        v.add("장양일");
        v.add("이예원");
        v.add("박소영");
        v.add("이우천");
    }

    public String get(){
        int index= (int)(Math.random()*v.size());
        return v.get(index);
    }

    public void add(String word){
        v.add(word);
    }
}
