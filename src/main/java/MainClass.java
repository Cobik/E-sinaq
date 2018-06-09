import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainClass {

    public static void main(String[] args) throws IOException {

        PdfManager pdfManager = new PdfManager();
        pdfManager.setFilePath("C:\\Users\\javidan.hajizada\\Desktop\\test.pdf");

      //  System.out.println(pdfManager.ToText());


        Writer writer = null;

//        try {
//            writer = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream("filename.txt"), "utf-8"));
//
//
//            writer.write(pdfManager.ToText());
//        } catch (IOException ex) {
//            // report
//        } finally {
//            try {writer.close();} catch (Exception ex) {/*ignore*/}
//        }


        String filepath = "/Users/cobik99/Desktop/filename.txt";
        File file = new File(filepath);

        Scanner scanner  = new Scanner(file);
        while (scanner.hasNextLine()){

           // Pattern pattern =  Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
            Pattern pattern =  Pattern.compile("^\\d+\\S");
            Pattern pattern1 = Pattern.compile("^\\S+");


            Pattern pattern2 = Pattern.compile("^\\w");


            Matcher matcher = pattern.matcher(scanner.nextLine());

//            if(scanner.nextLine().matches("[-]?[0-9]+(.[0-9]+)?")){
//                System.out.println(scanner.nextLine());
//            }
//



            if (matcher.find()){ //esli naxodit cislo v stroke to videlayet tekst iz stroki otdelno
                System.out.println(matcher.group());//cisla
                System.out.println(matcher.replaceAll(""));//tekst(vopros)

            }
            //System.out.println(matcher1.group());

        }
            scanner.close();//zakrivayu scanner



//        //parse olunmush faylin oxunmasi
//        try(FileReader reader = new FileReader("filename.txt"))
//        {
//            // читаем посимвольно
//            int c;
//            while((c=reader.read())!=-1){
//
//                System.out.print((char)c);
//            }
//        }
//        catch(IOException ex){
//
//            System.out.println(ex.getMessage());
//        }
//
//
//        //teze fayla yazilmasi suallarin
//        try {
//            writer = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream("done.txt"), "utf-8"));
//
//            writer.write("done.txt");
//        }catch (IIOException ex){
//
//        }

    }


}
