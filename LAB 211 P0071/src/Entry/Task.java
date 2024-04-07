package Entry;

import java.text.SimpleDateFormat;

public class Task {
    private int id;
    private static int code = 1;
    String taskTypeId;
    String requirementName;
    String date;
    String planFrom;
    String planTo;
    String assign;
    String reviewer;
    private double time;
    
    public Task() {
        setId();
    }


    public Task(String requirementName, String taskTypeId, String date, String planFrom, String planTo, String assign, String reviewer) {
        setId();
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = code++;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
        @Override
    public String toString() {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return id + "\t" + requirementName + "\t" + taskTypeId + "\t" + "\t" + date + "\t" + time + "\t"+ assign + "\t" + "\t" + reviewer;
    }
    
}
