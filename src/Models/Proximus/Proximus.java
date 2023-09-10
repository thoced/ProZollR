package Models.Proximus;
import java.util.ArrayList;
import java.util.List;

public class Proximus {
    private List<ProximusCalls> callsCollection;
    private List<ProximusCells> cellsCollection;
    private List<ProximusSubscrivers> subscriversCollection;
    private List<ProximusNPSubscrivers> npSubscriversCollection;

    public Proximus() {
        callsCollection = new ArrayList<ProximusCalls>();
        cellsCollection = new ArrayList<ProximusCells>();
        subscriversCollection = new ArrayList<ProximusSubscrivers>();
        npSubscriversCollection = new ArrayList<ProximusNPSubscrivers>();
    }

    public List<ProximusCalls> getCallsCollection() {
        return callsCollection;
    }

    public List<ProximusCells> getCellsCollection() {
        return cellsCollection;
    }

    public List<ProximusSubscrivers> getSubscribersCollection() {
        return subscriversCollection;
    }

    public List<ProximusNPSubscrivers> getNpSubscribersCollection() {
        return npSubscriversCollection;
    }
}

