import java.util.ArrayList;

/**
 * This class represents a Male.
 * Each male has a String for a name, a female match (pointer to an object of the Female class), and an ArrayList of Females in their prefered order.
 */
public class Male {
    
    private String name;
    private Female match;
    private ArrayList<Female> preferences; 

    public Male(String name){
        this.name = name;
        match = null;
        preferences = new ArrayList<>();
    }

    public Male(){
        name = null;
        match = null;
        preferences = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public ArrayList getPreferences(){
        return preferences;
    }

    public Female getMatch(){
        return match;
    }

    public void setMatch(Female match){
        this.match = match;
    }

    public void setPreferences(Female f1, Female f2, Female f3, Female f4, Female f5){
        preferences.add(f1);
        preferences.add(f2);
        preferences.add(f3);
        preferences.add(f4);
        preferences.add(f5);
    }

}
