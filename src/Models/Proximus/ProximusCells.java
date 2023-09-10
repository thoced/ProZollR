package Models.Proximus;

public class ProximusCells {
    private String cellID;
    private String cellAddress;
    private String locationAreaCode;

    public ProximusCells(String cellID, String cellAddress, String locationAreaCode) {
        this.cellID = cellID;
        this.cellAddress = cellAddress;
        this.locationAreaCode = locationAreaCode;
    }

    public String getCellID() {
        return cellID;
    }

    public String getCellAddress() {
        return cellAddress;
    }

    public String getLocationAreaCode() {
        return locationAreaCode;
    }
}

