package classwork;

/**
 * Created by alisher on 3/10/16.
 */
public class Document {
    private String title;
    private String text;

    public static void print(){
        System.out.println("Asdasdas");
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getTitle(){
        return title;
    }

    public String getText(){
        return text;
    }

    public Document() {
    }

    public Document(Document doc) {
        title = doc.getTitle();
        text = doc.getText();
    }

    public Document copyDocument() {
        return new Document(this);
    }
}
