/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0071;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Task {

    private int id;
    private String name, type, assignee, reviewr;
    private double time;
    Date date;
    private static int code = 0;

    public Task() {
        setId();
    }

    public Task(String name, String type, Date date, double time, String assignee, String reviewr) {
        setId();
        this.name = name;
        this.type = type;
        this.date = date;
        this.time = time;
        this.assignee = assignee;
        this.reviewr = reviewr;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        code++;
        this.id = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewr() {
        return reviewr;
    }

    public void setReviewr(String reviewr) {
        this.reviewr = reviewr;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return id + "\t" + name + "\t" + type + "\t" + "\t" + dateFormat.format(date) + "\t" + time + "\t" + assignee + "\t" + "\t" + reviewr;
    }

}
