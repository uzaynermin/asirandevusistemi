package asirandevuu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class AsiRandevuu {
    public void parseFile(String fileName,String searchStr) throws FileNotFoundException{
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNext()){
            String line = scan.nextLine().toString();
            if(line.contains(searchStr)){
                System.out.print("Adı ve Soyadı: " +line + "\n");
            }
        }}
   
    public static void main(String[] args) throws IOException {
        int cikis = 1;
        String str;
        while(cikis == 1){
            System.out.println("   MENÜ    ");
            System.out.println("____________");
            System.out.println("");
            System.out.println("Yeni Kayıt İçin              1:");
            System.out.println("Randevu Almak İçin           2:");
            System.out.println("Randevuları Listelemek İçin  3:");
            System.out.println("Çıkış                        0:");


            Scanner scan = new Scanner(System.in); //Kullanıcıdan string değer alabilmek için Scanner sınıfını kullandık
            System.out.print("LÜTFEN SEÇİMİNİZİ GİRİNİZ    : ");
            int islem = scan.nextInt();


            switch(islem){
                case 1:  //yeni kayıt oluşturmak
                    System.out.print("Öğrenci No : ");
                    int ogrno = scan.nextInt();
                    System.out.print("Adı ve Soyadı  : ");
                    Scanner scan1 = new Scanner(System.in);
                    String adsoyad = scan1.nextLine();
                    System.out.println("   AŞI TERCİHİ    ");
                    System.out.println("___________________");
                    System.out.println("Biontech    : 1");
                    System.out.println("Sinovac     : 2");
                    System.out.println("Sputnik     : 3");
                    System.out.print("LÜTFEN SEÇİMİNİZİ GİRİNİZ    : ");
                    int asi1 = scan.nextInt();		
                    System.out.print("Lütfen Aşı Tarihini Giriniz  : ");
                    Scanner scan3 = new Scanner(System.in);
                    String tarih = scan3.nextLine();
                    System.out.println("");
                    if(asi1== 1){
                        File f = new File("C:\\Users\\User\\Desktop\\Python\\java\\AsiRandevuu/asilistesi.txt");//burası dosya konumuna göre değiştirilmeli
                        FileWriter fileWriter = new FileWriter(f,true);                   
                        fileWriter.write("\n " + ogrno +"  "+ adsoyad+" "+ "Biontech"+ " "+ tarih);
                        fileWriter.close();
                        System.out.println("");   
                        System.out.println("Kaydınız Başarılı Bir Şekilde Oluşturulmuştur......");
                    }
                    else if(asi1== 2){
                        File f = new File("C:\\Users\\User\\Desktop\\Python\\java\\AsiRandevuu/asilistesi.txt");//burası dosya konumuna göre değiştirilmeli
                        FileWriter fileWriter = new FileWriter(f,true);                   
                        fileWriter.write("\n " + ogrno +"  "+ adsoyad+" "+ "Sinovac"+ " "+ tarih);
                        fileWriter.close();
                        System.out.println("");   
                        System.out.println("Kaydınız Başarılı Bir Şekilde Oluşturulmuştur......");
                    }
                    else {
                        File f = new File("C:\\Users\\User\\Desktop\\Python\\java\\AsiRandevuu/asilistesi.txt");//burası dosya konumuna göre değiştirilmeli
                        FileWriter fileWriter = new FileWriter(f,true);                   
                        fileWriter.write("\n " + ogrno +"  "+ adsoyad+" "+ "Sputnik"+ " "+ tarih);
                        fileWriter.close();
                        System.out.println("");   
                        System.out.println("Kaydınız Başarılı Bir Şekilde Oluşturulmuştur......");
                    }
                    
                    break;    
                case 2 :   //randevu almak  
                    
                    System.out.print("Öğrenci No : ");
                    Scanner scan4 = new Scanner(System.in);
                    String ogrno4 = scan4.nextLine();
                    AsiRandevuu fileSearch = new AsiRandevuu();
                    fileSearch.parseFile("C:\\Users\\User\\Desktop\\Python\\java\\AsiRandevuu/asilistesi.txt", ogrno4);//burası dosya konumuna göre değiştirilmeli
                    System.out.println("   AŞI TERCİHİ    ");
                    System.out.println("___________________");
                    System.out.println("Biontech       ");
                    System.out.println("Sinovac        ");
                    System.out.println("Sputnik        ");
                    System.out.print("LÜTFEN SEÇİMİNİZİ GİRİNİZ    : ");
                    Scanner scan6 = new Scanner(System.in);
                    String asi = scan6.nextLine();	// burada aşının adı girilmeli	
                    System.out.print("Lütfen Aşı Tarihini Giriniz  : ");
                    Scanner scan2 = new Scanner(System.in);
                    String tarih1 = scan2.nextLine();
                    System.out.println("");
                    Scanner scan5 = new Scanner(new File("C:\\Users\\User\\Desktop\\Python\\java\\AsiRandevuu/asilistesi.txt"));//burası dosya konumuna göre değiştirilmeli
                        while(scan5.hasNext()){
                        String line = scan5.nextLine().toString();
                        if(line.contains(ogrno4)){
                            File f = new File("C:\\Users\\User\\Desktop\\Python\\java\\AsiRandevuu/asilistesi.txt");//burası dosya konumuna göre değiştirilmeli
                            FileWriter fileWriter = new FileWriter(f,true);                   
                            fileWriter.write("\n "+line +" "+ asi+ " "+ tarih1);
                            fileWriter.close();

                        }
                        }
                    
                    break; 
                case 3:  //randevu listele
                    System.out.println("Öğr No      Adı Soyadı      Aşı Firması     Tarih");
                    System.out.println("_________________________");
                    FileInputStream fStream = new FileInputStream("C:\\Users\\User\\Desktop\\Python\\java\\AsiRandevuu/asilistesi.txt"); //burası dosya konumuna göre değiştirilmeli
                    DataInputStream dStream = new DataInputStream(fStream);
                    BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
                    List<String> lines = bReader.lines().collect(Collectors.toList());
                        for (int i = 155; i < lines.size();i++) 
                    { 		      
                        System.out.println(lines.get(i)); 		
                    }

                    break;
                case 0:  // çıkış
                    cikis = 0;
                    System.out.println("Çıkış Yapıldı....");
                    break;
            }

    }
        
        
        
        
        
        
        
        
    }
    
}
