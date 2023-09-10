package Test;

import Dao.SingletonDAO;
import Models.Communication;
import Models.Proximus.*;
import Parsers.Proximus.ProximusParser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        Proximus proximus;
        ProximusParser parser = new ProximusParser();
        try {
            proximus = parser.parseFile("C:\\Users\\thono\\Desktop\\Proximus.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // affichage
        ListIterator<ProximusNPSubscrivers> list = proximus.getNpSubscribersCollection().listIterator();
        while (list.hasNext()) {
            ProximusNPSubscrivers call = list.next();
            System.out.println(call.getCalledCallingNr());
        }

        Communication communication = new Communication();
        try {
            communication.Create();

            List<Communication> coms = communication.Select("Caller = '32494386461'");
            ListIterator<Communication> listIte = coms.listIterator();
            while(listIte.hasNext())
            {
                Communication com = listIte.next();
                System.out.println(com.getCalled());
            }





        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

