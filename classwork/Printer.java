package classwork;

/**
 * Created by alisher on 3/4/16.
 */
public class Printer {
    public String name;
    public int version;

    public int getVersion(){
        return version;
    }

    public String getName(){
        return name;
    }

    public void print(String text){
        System.out.println(name);
        System.out.println(version);
        System.out.println(text);
    }

    public void print(Document document){
        System.out.println(name);
        System.out.println(version);
        System.out.println("Document");
        System.out.println("Title: "+document.getTitle());
        System.out.println();
        System.out.println(document.getText());
    }
}
