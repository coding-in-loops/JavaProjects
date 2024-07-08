//Behavioral Design Pattern -> Strategy design pattern, observer design pattern and command design pattern
/*
 * Problem Statement:
 * Develop a text editor application in java that allows user to input text and apply different 
 * formatting style (e.g. uppercase, lowercase). Also there should be system waiting for the text 
 * to be updated. Everytime the text is updated, the text editor should notify the observers.
 * Aslo the text formatting operations should be encapsulated and execute them as the editor's text
 */

 //Strategy design pattern

import java.util.ArrayList;
import java.util.List;

interface TextFormattingStrategy{
    String format(String text);
}
class UpperCaseStrategy implements TextFormattingStrategy{
    @Override
    public String format(String text) {
       return text.toUpperCase();
    }   
}
class LowerCaseStrategy implements TextFormattingStrategy{
    @Override
    public String format(String text) {
       return text.toLowerCase();
    }   
}

interface TextEditorObserver{
    void update (String text);
}
class TextConsoleObserver implements TextEditorObserver{
    @Override
    public void update(String text) {
        System.out.println("Text updated in console: "+text);
    }
}
interface TextEditorSubject{
    //register the observer
    void registerObserver(TextEditorObserver obserser);
    //remove the observer
    void removeObserver(TextEditorObserver obserser);
    //notify the observer
    void notifyObservers();
}
class TextEditor implements TextEditorSubject{
    private List<TextEditorObserver> observerList=new ArrayList<>();
    private String currentText="";
    @Override
    public void registerObserver(TextEditorObserver observer){
        observerList.add(observer);
    }
    @Override
    public void removeObserver(TextEditorObserver observer){
        observerList.remove(observer);
    }
    @Override
    public void notifyObservers(){
        for(TextEditorObserver observer: observerList){
            observer.update(this.currentText);
        }
    }
    public void setCurrentText(String currentText){
        this.currentText=currentText;
    }
}
//Command Design Pattern
interface TextEditorCommand{
    void execute();
}
class FormatTextCommand implements TextEditorCommand{
    private TextFormattingStrategy textFormattingStrategy;
    private TextEditor textEditor;
    private String textToFormat;

    public FormatTextCommand(TextFormattingStrategy textFormattingStrategy,TextEditor textEditor,String textToFormat){
        this.textFormattingStrategy=textFormattingStrategy;
        this.textEditor=textEditor;
        this.textToFormat=textToFormat;
    }

    @Override
    public void execute(){
        System.out.println("Formatting the text: "+textToFormat);
    }
}
public class TextEditorApp {
    public static void main(String[] args) {
        //create text editor
        TextEditor textEditor=new TextEditor();

        //Test editor Observer
        TextEditorObserver observer=new  TextConsoleObserver();

        //register all observer with text editor
        textEditor.registerObserver(observer);
        textEditor.setCurrentText("Hello, World");

        //Formatters
        TextFormattingStrategy uppercaseStrategy=new UpperCaseStrategy();

        //Command to create the text
        TextEditorCommand command=new FormatTextCommand(uppercaseStrategy, textEditor, "Hello, World");
        command.execute();
    }
}
