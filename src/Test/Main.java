package Test;

import Dao.SingletonDAO;
import Models.Proximus.*;
import Parsers.Proximus.ProximusParser;

import java.io.IOException;
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

        SingletonDAO.getInstanceConnection();
    }
}

