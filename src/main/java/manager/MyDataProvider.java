package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginValidData(){

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Tomy123456@mail.com","Qq123666$45"});
        list.add(new Object[]{"Tomy123456@mail.com","Qq123666$45"});
        list.add(new Object[]{"elizabet123456@mail.com","El098765$"});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> ContactValidData(){
        List<Object[]>list = new ArrayList<>();
        list.add(new Object[]{"Mat","Ti","1234567898","may@gmail.com","Haifa","Friend"});
        list.add(new Object[]{"Mat","Ti","1234567898","may@gmail.com","Haifa","Friend"});
        list.add(new Object[]{"Mat","Ti","1234567898","may@gmail.com","Haifa","Friend"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginValidDataModel(){

        List<Object[]> list = new ArrayList<>();
       list.add(new Object[]{new User().withEmail("Tomy123456@mail.com").withPassword("Qq123666$45")});
       list.add(new Object[]{new User().withEmail("Tomy123456@mail.com").withPassword("Qq123666$45")});
       list.add(new Object[]{new User().withEmail("Tomy123456@mail.com").withPassword("Qq123666$45")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addContactValidDataModel(){

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder().name("Jams").lastName("Norrington").phone("4546484949").email("jaimi@gmail.com").address("Karibi").description("Friend")});
        list.add(new Object[]{Contact.builder().name("Jams").lastName("Norrington").phone("4546484946").email("jaimi1@gmail.com").address("Karibi").description("Friend")});
        list.add(new Object[]{Contact.builder().name("Jams").lastName("Norrington").phone("4546484940").email("jaimi2@gmail.com").address("Karibi").description("Friend")});


        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> addContactValidDataIsFile() throws IOException {

        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();//чтение построчно
//Elizabet,Swon,5464748454,eliz2@gmail.com,Tortuga,Friend
        while (line!=null){
            String []split = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2])
                    .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()});
            line = reader.readLine();
        }

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginValidDataCSV() throws IOException {

        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/login.csv"));
        String line = reader.readLine();

        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{split[0],split[1]});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
