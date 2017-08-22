
import java.sql.SQLException;
import java.util.ArrayList;

public class TestDB {

    public static void main(String[] args) {
        try {
            BugDatabase DB = new BugDatabase();
            ArrayList<Bug> bugReport = DB.getBugs();
            System.out.println(bugReport.size() + " records found\n");

            Bug bug100 = DB.getBug(100);

            System.out.println(bug100.toFormattedString());
            Bug newBug = new Bug();
            newBug = DB.saveBug(newBug);

            newBug.setPriority(Bug.PriorityType.HIGH);
            newBug.setStatus(Bug.StatusType.COMPLETED);
            newBug = DB.saveBug(newBug);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
