
import java.util.ArrayList;

public class BugDatabase {
   
    // Default Constructor
    // Only 1 per thread
    BugDatabase(){
        // Get database connection
    }
    
    // Get all of the bugs entered into the database
    public ArrayList<Bug> getBugs(){
        ArrayList<Bug> bugReport = new ArrayList<Bug>();
        return bugReport;
    }
    
    // Get the bug with the specified id
    public Bug getBug(Integer id){
        Bug bug = new Bug();
        return bug;
    }
     
    // Save the updated bug to the database
    public void saveBug(Bug bug){
    }
    
    // Create the id for the new bug and save it to the database
    public Bug newBug(Bug bug){
        // generate the unique id
        saveBug(bug);
        return bug;
    }
    
    // Get the bugs with the specified priorities
    public ArrayList<Bug> getBugs(Bug.PriorityType priority){
        ArrayList<Bug> bugReport = new ArrayList<Bug>();
        return bugReport;
    } 
    
    // Get all of the bugs for the specified application
    public ArrayList<Bug> getBugs(String application){
        ArrayList<Bug> bugReport = new ArrayList<Bug>();
        return bugReport;
    }   
    
    // Get all of the bugs assigned to a single person
    public ArrayList<Bug> getAssignedBugs(String assignee){
        ArrayList<Bug> bugReport = new ArrayList<Bug>();
        return bugReport;  
    }
 }

