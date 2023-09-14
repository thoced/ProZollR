package Models.Case;

import Dao.IDAO;
import Dao.SingletonDAO;
import Models.UpdateDBException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CaseInfo implements IDAO<CaseInfo> {

    private int id;
    private String caseName;
    private String reference;
    private String remark;

    public CaseInfo() {
    }

    public CaseInfo(String caseName, String reference, String remark) {
        this.caseName = caseName;
        this.reference = reference;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public void Create() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS CASEINFO(\n" +
                "id INTEGER PRIMARY KEY,\n" +
                "caseName TEXT,\n" +
                "reference TEXT,\n" +
                "remark TEXT)";

        SingletonDAO.getInstanceConnection().createStatement().execute(sql);
    }

    @Override
    public void Insert() throws SQLException {
        String sql = "INSERT INTO CASEINFO (caseName, reference, remark)\n" +
                "VALUES (?,?,?)";
        PreparedStatement statement = SingletonDAO.getInstanceConnection().prepareStatement(sql);
        statement.setString(1,caseName);
        statement.setString(2,reference);
        statement.setString(3,remark);
        statement.executeUpdate();
    }

    @Override
    public void Update() throws SQLException, UpdateDBException {

    }

    @Override
    public void Delete() throws SQLException, UpdateDBException {

    }

    @Override
    public List<CaseInfo> Select(String args) throws SQLException {
        return null;
    }
}
