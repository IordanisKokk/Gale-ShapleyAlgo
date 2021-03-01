import java.util.ArrayList;

/**
 * This class represents a Female.
 * Each female has a String for a name, a male match (pointer to an object of the Male class), and an ArrayList of Males in their prefered order.
 */
public class Female {
    
    String name;
    private Male match;
    ArrayList<Male> preferences; 

    public Female(String name){
        this.name = name;
        match = null;
        preferences = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public ArrayList getPreferences(){
        return preferences;
    }

    public Male getMatch(){
        return match;
    }

    public void setMatch(Male match){
        this.match = match;
    }

    public void setPreferences(Male m1, Male m2, Male m3, Male m4, Male m5){
        preferences.add(m1);
        preferences.add(m2);
        preferences.add(m3);
        preferences.add(m4);
        preferences.add(m5);
    }

}
