
import java.util.ArrayList;
import java.sql.*;
import java.sql.DriverManager;

public class BugDatabase {

    private Statement statement;
    private Connection connection;

    // Default Constructor
    // Only 1 per thread
    BugDatabase() throws SQLException, ClassNotFoundException {
        Initialize();
    }

    // Get all of the bugs entered into the database
    public ArrayList<Bug> getBugs() {
        ArrayList<Bug> bugReport = query("select * from Bugs");
        return bugReport;
    }

    // Get the bug with the specified id
    public Bug getBug(Integer id) {
        ArrayList<Bug> bugReport = query("select * from Bugs where id=" + id);
        return bugReport.get(0);
    }

    // Save the new or updated bug to the database
    // Need to lock the database before writing to it
    public Bug saveBug(Bug bug) {
        if (bug.getId() == 0) {
            bug.setId(getNextId());
            add(bug);
        } else {
            update(bug);
        }
        return bug;
    }

    // Get the bugs with the specified priorities
    public ArrayList<Bug> getBugs(Bug.PriorityType priority) {
        ArrayList<Bug> bugReport
                = query("select * from Bugs where Priority=" + priority.toString());
        return bugReport;
    }

    // Get the bugs with the specified status
    public ArrayList<Bug> getBugs(Bug.StatusType status) {
        ArrayList<Bug> bugReport
                = query("select * from Bugs where Status=" + status.toString());
        return bugReport;
    }

    // Get all of the bugs for the specified application
    public ArrayList<Bug> getBugs(String application) {
        ArrayList<Bug> bugReport
                = query("select * from Bugs where Application=" + application);
        return bugReport;
    }

    // Get all of the bugs assigned to a single person
    public ArrayList<Bug> getAssignedBugs(String assignee) {
        ArrayList<Bug> bugReport
                = query("select * from Bugs where Assignee=" + assignee);
        return bugReport;
    }

    private void Initialize() throws SQLException, ClassNotFoundException {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            // Connect to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost/bugreportteamb", "teamb", "teamb");
            System.out.println("Database connected");

            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Execute a general query
    private ArrayList<Bug> query(String queryString) {
        ArrayList<Bug> bugReport = new ArrayList<Bug>();
        try {
            ResultSet resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                Bug bug = new Bug(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8));
                bugReport.add(bug);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bugReport;
    }

    private Integer getNextId() {
        Integer lastId = 0;
        try {
            ResultSet resultSet = statement.executeQuery("select max(id) from Bugs");
            while (resultSet.next()) {
                lastId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (lastId + 1);
    }

    // Add a new bug to the database
    private void add(Bug bug) {
        String insertString
                = "insert into Bugs values("
                + bug.getId() + ",\""
                + bug.getStatus().toString() + "\",\""
                + bug.getPriority().toString() + "\",\""
                + bug.getApplication() + "\",\""
                + bug.getAssignee() + "\",\""
                + bug.getsummary() + "\",\""
                + bug.getDetailedDesc() + "\",\""
                + bug.getFixDesc() + "\");";
        try {
            statement.executeUpdate(insertString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Execute a general update
    private void update(Bug bug) {

        String updateString
                = "update Bugs "
                + "set Status = \""
                + bug.getStatus().toString() + "\","
                + " Priority = \""
                + bug.getPriority().toString() + "\","
                + " Application = \""
                + bug.getApplication() + "\","
                + " Assignee = \""
                + bug.getAssignee() + "\","
                + " Summary = \""
                + bug.getsummary() + "\","
                + " DetailedDesc = \""
                + bug.getDetailedDesc() + "\","
                + " FixDesc = \""
                + bug.getFixDesc() + "\""
                + " where id=" + bug.getId() + ";";

        try {
            statement.executeUpdate(updateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
