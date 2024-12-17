import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class TextSource {
    private Vector<String> v = new Vector<String>();

    public TextSource()  {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader( new FileReader("korea.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String str;
        while (true) {
            try {
                if ((str = reader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            v.add(str);
        }

    }

    public String get(){
        int index= (int)(Math.random()*v.size());
        return v.get(index);
    }

    public void add(String word){
        v.add(word);
    }
}
