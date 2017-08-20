
import java.lang.Enum;

public class Bug {

    enum StatusType {
        Pending,    // The initial state
        Approved,   // Once the Bug has been approved
        Assigned,   // A person has been assigned to fix the bug.
        Completed,  // The fix to the bug has been completed
        Closed      // The fix to the bug has been accepted
    };

    enum PriorityType {
        High, Medium, Low
    };
    
    private Integer id = 0;
    private StatusType status = StatusType.Pending;
    private PriorityType priority = PriorityType.Low;
    private String application = "";
    private String assignee = "";
    private String summary = "";
    private String detailedDesc = "";
    private String fixDesc = "";
    
    // Default Constructor
    Bug() {
    }
    
    Integer getId() {
        return this.id;
    }

    StatusType getStatus() {
        return this.status;
    }

    PriorityType getPriority() {
        return this.priority;
    }

    String getAssignee() {
        return this.assignee;
    }

    String getsummary() {
        return this.summary;
    }

    String getDetailedDesc() {
        return this.detailedDesc;
    }

    String getFixDescr() {
        return this.fixDesc;
    }

    void setId(Integer id) {
        this.id = id;
    }

    void setStatus(StatusType status) {
        this.status = status;
    }

    void setPriority(PriorityType priority) {
        this.priority = priority;
    }

    void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    void setsummary(String summary) {
        this.summary = summary;
    }

    void setDetailedDesc(String detailedDesc) {
        this.detailedDesc = detailedDesc;
    }

    void setFixDesc(String fixDesc) {
        this.fixDesc = fixDesc;
    }
}
