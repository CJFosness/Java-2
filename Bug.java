
import java.lang.Enum;

public class Bug {

    enum StatusType {
        PENDING, // The initial state
        APPROVED, // Once the Bug has been approved
        ASSIGNED, // A person has been assigned to fix the bug.
        COMPLETED, // The fix to the bug has been completed
        CLOSED      // The fix to the bug has been accepted
    };

    enum PriorityType {
        HIGH, MEDIUM, LOW
    };

    private Integer id = 0;
    private StatusType status = StatusType.PENDING;
    private PriorityType priority = PriorityType.LOW;
    private String application = "";
    private String assignee = "";
    private String summary = "";
    private String detailedDesc = "";
    private String fixDesc = "";

    // Default Constructor
    Bug() {
    }

    Bug(Integer id,
            StatusType status,
            PriorityType priority,
            String application,
            String assignee,
            String summary,
            String detailedDesc,
            String fixDesc) {
        setId(id);
        setStatus(status);
        setPriority(priority);
        setApplication(application);
        setAssignee(assignee);
        setSummary(summary);
        setDetailedDesc(detailedDesc);
        setFixDesc(fixDesc);
    }

    Bug(Integer id,
            String status,
            String priority,
            String application,
            String assignee,
            String summary,
            String detailedDesc,
            String fixDesc) {
        setId(id);
        setStatus(status);
        setPriority(priority);
        setApplication(application);
        setAssignee(assignee);
        setSummary(summary);
        setDetailedDesc(detailedDesc);
        setFixDesc(fixDesc);
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

    String getApplication() {
        return this.application;
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

    String getFixDesc() {
        return this.fixDesc;
    }

    // this should only be called by the database utility
    void setId(Integer id) {
        this.id = id;
    }

    void setStatus(StatusType status) {
        this.status = status;
    }

    void setStatus(String status) {
        this.status = StatusType.valueOf(status);
    }

    void setPriority(PriorityType priority) {
        this.priority = priority;
    }

    void setPriority(String priority) {
        this.priority = PriorityType.valueOf(priority);
    }

    void setApplication(String application) {
        this.application = application;
    }

    void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    void setSummary(String summary) {
        this.summary = summary;
    }

    void setDetailedDesc(String detailedDesc) {
        this.detailedDesc = detailedDesc;
    }

    void setFixDesc(String fixDesc) {
        this.fixDesc = fixDesc;
    }

    String toFormattedString() {
        String returnString
                = "ID = " + getId()
                + "\nStatus = " + this.status.toString()
                + "\nPriority = " + this.priority.toString()
                + "\nApplicatin = " + this.application
                + "\nAssignee = " + this.assignee
                + "\nSummary = " + this.summary
                + "\nDetailed Description = " + this.detailedDesc
                + "\nFix Description = " + this.fixDesc;
        return returnString;
    }
}
