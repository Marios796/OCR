
package ocr;

import java.io.PrintWriter;


public class OCR {
public static void main(String[] args) {
 String input="C:\\Users\\mkon9\\Documents\\NetBeansProjects\\OCR\\src\\ocr\\f4c.jpg";  //καταχωρω τα directories των input(εικονες) και output(txt) αρχειων σε μεταβλητες
 String output="C:\\Users\\mkon9\\Documents\\NetBeansProjects\\OCR\\src\\ocr\\f4c";
 String tesseractDir="C:\\Program Files\\Tesseract-OCR\\tesseract";
 String[] command =
    {
        "cmd",  
    };
    Process p;
 try {
 p = Runtime.getRuntime().exec(command);  //ανοιγω το command prompt
        new Thread(new Reader(p.getErrorStream(), System.err)).start();  //thread που εμφανιζει τυχον errors και warnings κατα την εκτελεση του process
        new Thread(new Reader(p.getInputStream(), System.out)).start();  //thread που ελεγχει αν εχει οκοκληρωθει το process
        PrintWriter stdin = new PrintWriter(p.getOutputStream());
        stdin.println("\""+tesseractDir+"\" \""+input+"\" \""+output+"\" -l eng");  //εντολή που τρεχει το command prompt με βαση το documentation του tesseract 
        stdin.close();
        p.waitFor();  //περιμενω μεχρι να ολοκληρωθει το process
        System.out.println();
        System.out.println("==========================================================");
        System.out.println();
        System.out.println(ReadFile.read_a_file(output+".txt")); //εμφανιζω στο netbeans το περιεχομενο του txt  
        System.out.println();
        System.out.println("==========================================================");

    } catch (Exception e) {
 e.printStackTrace();
    }
  }
}