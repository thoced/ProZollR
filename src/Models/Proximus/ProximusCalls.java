package Models.Proximus;

public class ProximusCalls {
    private String type;
    private String calledCallingNr;
    private String date;
    private String time;
    private String duration;
    private String servedPhoneNumber;
    private String servedStartCellID;
    private String servedStartCellLAC;
    private String servedEndCellID;
    private String servedEndCellLAC;
    private String servedIMEI;
    private String servedIMSI;
    private String servedMSRN;
    private String operatorName;
    private String thirdParty;
    private String inOperator;
    private String inCountry;
    private String outOperator;
    private String outCountry;

    // Constructeur
    public ProximusCalls(String type, String calledCallingNr, String date, String time, String duration,
                    String servedPhoneNumber, String servedStartCellID, String servedStartCellLAC,
                    String servedEndCellID, String servedEndCellLAC, String servedIMEI, String servedIMSI,
                    String servedMSRN, String operatorName, String thirdParty, String inOperator,
                    String inCountry, String outOperator, String outCountry) {
        this.type = type;
        this.calledCallingNr = calledCallingNr;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.servedPhoneNumber = servedPhoneNumber;
        this.servedStartCellID = servedStartCellID;
        this.servedStartCellLAC = servedStartCellLAC;
        this.servedEndCellID = servedEndCellID;
        this.servedEndCellLAC = servedEndCellLAC;
        this.servedIMEI = servedIMEI;
        this.servedIMSI = servedIMSI;
        this.servedMSRN = servedMSRN;
        this.operatorName = operatorName;
        this.thirdParty = thirdParty;
        this.inOperator = inOperator;
        this.inCountry = inCountry;
        this.outOperator = outOperator;
        this.outCountry = outCountry;
    }

    // Méthodes getters
    public String getType() {
        return type;
    }

    public String getCalledCallingNr() {
        return calledCallingNr;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDuration() {
        return duration;
    }

    public String getServedPhoneNumber() {
        return servedPhoneNumber;
    }

    public String getServedStartCellID() {
        return servedStartCellID;
    }

    public String getServedStartCellLAC() {
        return servedStartCellLAC;
    }

    public String getServedEndCellID() {
        return servedEndCellID;
    }

    public String getServedEndCellLAC() {
        return servedEndCellLAC;
    }

    public String getServedIMEI() {
        return servedIMEI;
    }

    public String getServedIMSI() {
        return servedIMSI;
    }

    public String getServedMSRN() {
        return servedMSRN;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public String getThirdParty() {
        return thirdParty;
    }

    public String getInOperator() {
        return inOperator;
    }

    public String getInCountry() {
        return inCountry;
    }

    public String getOutOperator() {
        return outOperator;
    }

    public String getOutCountry() {
        return outCountry;
    }
}
