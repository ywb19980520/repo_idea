package com.imlty.vo;

/**
 * VO类:表现层对象 根据需求将分析 判断并接受前台转过来的数据
 */
public class CourseVO {

    private String courseName;
    private Integer status;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
