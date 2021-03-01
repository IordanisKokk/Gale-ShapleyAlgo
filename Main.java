import java.util.ArrayList;
import java.util.Iterator;

public class Main{


    public static void main(String[] args){

        Male joey = new Male("Joey");
        Male ross = new Male ("Ross");
        Male chandler = new Male("Chandler");
        Male mike = new Male ("Mike");
        Male gunther = new Male("Gunther");

        Female monica = new Female("Monica");
        Female rachel = new Female("Rachel");
        Female phoebe = new Female("Phoebe");
        Female mona = new Female("Mona");
        Female janice = new Female("Janice");

        joey.setPreferences(rachel, mona, phoebe, monica, janice);
        ross.setPreferences(rachel, mona, phoebe, janice, monica);
        chandler.setPreferences(monica, rachel, phoebe, mona, janice);
        mike.setPreferences(phoebe, mona, rachel, monica, janice);
        gunther.setPreferences(rachel, phoebe, monica, mona, janice);

        monica.setPreferences(chandler, joey, mike, gunther, ross);
        rachel.setPreferences(ross, joey, mike, gunther, chandler);
        phoebe.setPreferences(mike, joey, chandler, ross, gunther);
        mona.setPreferences(ross, joey, mike, chandler, gunther);
        janice.setPreferences(chandler, ross, mike, joey, gunther);

        ArrayList<Male> males = new ArrayList<>();
        males.add(joey);
        males.add(ross);
        males.add(chandler);
        males.add(mike);
        males.add(gunther);

        ArrayList<Female> females = new ArrayList<>();
        females.add(monica);
        females.add(rachel);
        females.add(phoebe);
        females.add(mona);
        females.add(janice);

        galeShapley(males, females);

        System.out.println();

        for (Male male : males) {
            if(male.getMatch() != null){
                System.out.println(male.getName() + " --- " + male.getMatch().getName());
            }
        }

    }

    /**
     * This function returns true if the 'female' prefers 'male1' over 'male2'.
     * 
     * It checks to see which of the two males is first on the females preferences ArrayList.
     */
    public static boolean femalePreffersMale1OverMale2(Female female, Male male1, Male male2){

        ArrayList<Male> femPref = female.getPreferences();

        for (Male male : femPref) {
            if (male.equals(male1)){
                return true;
            }
            if (male.equals(male2)){
                return false;
            }
        }
        return false;
    }

/**
 * This is a function that implements the Gale-Shapley Algorithm, in order to provide stable matchings for the males and females.
 * 
 * While there are free males, it uses one of them to traverse it's preferences ArrayList to propose to the females, from best to worst preference.
 * 
 * If the female on the ArrayList is free (not already matched with another male), then the two of them (male and female) are matched and the freeMaleCount is decremented
 * and the process is run again for another free male.
 * 
 * If the female on the ArrayList is not free (is already matched with another male), then the femalePreffersMale1OverMale2 function is called in order to see if the female
 * prefers the new male or the one that is already matched with her. If it does, then the female and new male are matched and the old match becomes free, otherwise the new male
 * continues traversing the preferences ArrayList looking for a match.
 * 
 * This is done untill every male gets a female match and the freeMaleCount reaches 0.
 * Afterwards, the males and females are all in stable matches.
 */
    public static void galeShapley(ArrayList<Male> males, ArrayList<Female> females){
       
        int freeMaleCount = males.size();

        while(freeMaleCount > 0){

            for (Male male : males) {
                if (male.getMatch() != null){
                    continue;
                }

                ArrayList<Female> malePref = male.getPreferences();

                for (Female female : malePref){

                    if (female.getMatch() == null){
                        male.setMatch(female);
                        female.setMatch(male);
                        freeMaleCount --;
                        break;

                    }
                    else{
                        if (femalePreffersMale1OverMale2(female, male, female.getMatch())){
                            Male oldMatch = female.getMatch();
                            oldMatch.setMatch(null);
                            male.setMatch(female);
                            female.setMatch(male);
                            break;
                        }
                    }
                }
            }

        }

    }

}