package Models;

import Dao.IDAO;
import Dao.SingletonDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Communication implements IDAO<Communication> {

    private int id;
    private String caller;
    private String called;
    private Date timeStart;
    private Date timeEnd;
    private int duration; // en secondes
    private String type;

    // Constructeur


    public Communication() {
        this.timeStart = new Date();
        this.timeEnd = new Date();
    }

    public Communication(int id,String caller, String called, Date timeStart, Date timeEnd, int duration, String type) {
        this.id = id;
        this.caller = caller;
        this.called = called;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.duration = duration;
        this.type = type;
    }

    // Getters et Setters

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getCalled() {
        return called;
    }

    public void setCalled(String called) {
        this.called = called;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void Create() throws SQLException {
        // creation de la table Communication, si elle n'existe pas
        String sql = "CREATE TABLE IF NOT EXISTS COMMUNICATION (\n" +
                "    id INTEGER PRIMARY KEY,\n" +
                "    caller TEXT,\n" +
                "    called TEXT,\n" +
                "    timeStart DATETIME,\n" +
                "    timeEnd DATETIME,\n" +
                "    duration INTEGER,\n" +
                "    type TEXT\n" +
                ");\n";

        SingletonDAO.getInstanceConnection().createStatement().execute(sql);
    }

    @Override
    public void Insert() throws SQLException {
        String sql = "INSERT INTO COMMUNICATION (caller, called, timeStart, timeEnd, duration, type)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);\n";

        PreparedStatement statement  = SingletonDAO.getInstanceConnection().prepareStatement(sql);
        statement.setString(1, caller);
        statement.setString(2, called);
        statement.setTimestamp(3, new java.sql.Timestamp(timeStart.getTime()));
        statement.setTimestamp(4, new java.sql.Timestamp(timeEnd.getTime()));
        statement.setInt(5, duration);
        statement.setString(6, type);

        statement.executeUpdate();
    }

    @Override
    public void Update() throws SQLException, UpdateDBException {
        String sql = "UPDATE COMMUNICATION \n" +
                "SET caller = ?, called = ?, timeStart = ?, timeEnd = ?, duration = ?, type = ?\n" +
                "WHERE id = ?;\n";

        try (PreparedStatement preparedStatement = SingletonDAO.getInstanceConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, caller);
            preparedStatement.setString(2, called);
            preparedStatement.setTimestamp(3, new java.sql.Timestamp(timeStart.getTime()));
            preparedStatement.setTimestamp(4, new java.sql.Timestamp(timeEnd.getTime()));
            preparedStatement.setInt(5, duration);
            preparedStatement.setString(6, type);
            preparedStatement.setInt(7, id);

            int rowCount = preparedStatement.executeUpdate();
            if(rowCount == 0){
                throw new UpdateDBException();
            }
        }
    }

    @Override
    public void Delete() throws SQLException, UpdateDBException {
        String sql = "DELETE FROM COMMUNICATION WHERE id = ?;\n";

        PreparedStatement preparedStatement = SingletonDAO.getInstanceConnection().prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int rowCount = preparedStatement.executeUpdate();
        if(rowCount == 0){
            throw new UpdateDBException();
        }

    }

    @Override
    public List<Communication> Select(String args) throws SQLException {

        if(args == null || args.isEmpty() || args.isBlank())
        {
            return null;
        }

        List<Communication> communications = new ArrayList<Communication>();

        String sql = "SELECT * FROM COMMUNICATION WHERE " + args;
        Statement statement = SingletonDAO.getInstanceConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next())
        {

            int id = resultSet.getInt("id");
            String caller = resultSet.getString("caller");
            String called = resultSet.getString("called");
            Date timeStart = resultSet.getTimestamp("timeStart");
            Date timeEnd = resultSet.getTimestamp("timeEnd");
            int duration = resultSet.getInt("duration");
            String type = resultSet.getString("type");

            Communication communication = new Communication(id,caller,called,timeStart,timeEnd,duration,type);

            communications.add(communication);
        }

        return communications;

    }
}
