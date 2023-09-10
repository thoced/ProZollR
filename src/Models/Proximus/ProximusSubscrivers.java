package Models.Proximus;

public class ProximusSubscrivers {
    private String calledCallingNr;
    private String imsi;
    private String simCardNumber;
    private String identifierType;
    private String name;
    private String address;
    private String postCode;
    private String city;
    private String startDate;
    private String endDate;
    private String operator;

    public ProximusSubscrivers(String calledCallingNr, String imsi, String simCardNumber, String identifierType,
                           String name, String address, String postCode, String city,
                           String startDate, String endDate, String operator) {
        this.calledCallingNr = calledCallingNr;
        this.imsi = imsi;
        this.simCardNumber = simCardNumber;
        this.identifierType = identifierType;
        this.name = name;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.operator = operator;
    }

    public String getCalledCallingNr() {
        return calledCallingNr;
    }

    public String getImsi() {
        return imsi;
    }

    public String getSimCardNumber() {
        return simCardNumber;
    }

    public String getIdentifierType() {
        return identifierType;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getOperator() {
        return operator;
    }
}

