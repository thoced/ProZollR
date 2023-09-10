package Controls;

import Models.Communication;
import Models.Proximus.Proximus;
import Models.Proximus.ProximusCalls;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;

public class ProximusControl {

    public void importData(Proximus proximus) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        // import des données dans la DB
        ListIterator< ProximusCalls> listCalls = proximus.getCallsCollection().listIterator();
        while(listCalls.hasNext())
        {
            ProximusCalls proximusCalls = listCalls.next();
            Communication communication = new Communication();

            if(proximusCalls.getType().equals("1A"))
            {
                communication.setCaller(proximusCalls.getCalledCallingNr());
                communication.setCalled(proximusCalls.getServedPhoneNumber());
                communication.setRoaming(1);
            }

            if(proximusCalls.getType().equals("01") || proximusCalls.getType().equals("1F"))
            {
                // traffic sortant du numéro observé
                communication.setCaller(proximusCalls.getServedPhoneNumber());
                communication.setCalled(proximusCalls.getCalledCallingNr());
            }
            if(proximusCalls.getType().equals("02") || proximusCalls.getType().equals("1E"))
            {
                // traffic entrant vers le numéro observé
                communication.setCaller(proximusCalls.getCalledCallingNr());
                communication.setCalled(proximusCalls.getServedPhoneNumber());
            }

            double nombreDecimal = Double.parseDouble(proximusCalls.getDuration());
            communication.setDuration(((int)nombreDecimal));

            // type de communication
            if(proximusCalls.getType().equals("01") || proximusCalls.getType().equals("02"))
            {
                communication.setType(Communication.TYPE.VOICE.name());
            }

            if(proximusCalls.getType().equals("1F") || proximusCalls.getType().equals("1E"))
            {
                communication.setType(Communication.TYPE.SMS.name());
            }

            // création de la date en utilisant SimpleDateFormat (dd-MM-yyyy HH:mm:ss)
            communication.setTimeStart(dateFormat.parse(proximusCalls.getDate() + " " + proximusCalls.getTime()));
            // création de la date de fin grace à la duration (utilisation de Calendar)
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(communication.getTimeStart());
            calendar.add(Calendar.SECOND,communication.getDuration());
            communication.setTimeEnd(calendar.getTime());

            // ajout dans la DB
            try {
                communication.Insert();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
