package week10;
import java.util.ArrayList;
import java.util.List;
public class NyrData {
    public interface Listener {
        
        void onChange(NyrData nyrdata);
    }//interface Listener
    private List< Listener> listeners = new ArrayList<>();
    
    private ArrayList<String> unconfirmedResolutions = new ArrayList<>();
    private ArrayList<String> confirmedResolutions = new ArrayList<>();
    private ArrayList<String> history = new ArrayList<>();
    
    public NyrData()  {
        unconfirmedResolutions.add("Start Running!!!");
        unconfirmedResolutions.add("Go to the Gym!!!");
        unconfirmedResolutions.add("8 hours sleep!!!");
        unconfirmedResolutions.add("Eat healthy!!!");
        unconfirmedResolutions.add("Be on time!!!");
    }//NyrData
    
    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    public void notifyObservers() {
        listeners.stream().forEach(ls -> ls.onChange(this));
    }
    
    void confirm() {
        //To take the first unconfirmed and move it to confirmed and update history
        if (!unconfirmedResolutions.isEmpty()) {
        String resolution = unconfirmedResolutions.remove(0);
        confirmedResolutions.add(resolution);
        history.add(resolution);
        notifyObservers();
    }//if statement
    }//confirm
    
    void oops() {
        //take the last confirmed and move it to unconfirmed and update history
        if (!confirmedResolutions.isEmpty()) {
        String resolution = confirmedResolutions.remove(confirmedResolutions.size() - 1);
        unconfirmedResolutions.add(0, resolution);
        history.add(resolution);
        notifyObservers();
    }//if stetement
    }//oops
    
    public void clearHistory() {
        //to literally clear the history
        history.clear();
        notifyObservers();
    } //clearHistory
    
    public ArrayList<String> getUnconfirmedResolutions() {
        return unconfirmedResolutions;
    }//getUnconfirmedResolutions
    
    public ArrayList<String> getConfirmedResolutions() {
        return confirmedResolutions;
    }//getConfirmedResolutions
    
    public ArrayList<String> getHistory() {
        return history;
        
    }//getHistory
    
            
    }//class Nyrdata
