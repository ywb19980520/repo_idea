package com.imlty.service;

import com.imlty.domain.Course;
import com.imlty.domain.CourseSection;

import java.util.List;

public interface CourseContentService {

    //根据课程id查询章节信息和课时信息
    List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /**
     * 回显章节信息
     */
    Course findCourseByCourseId(Integer courseId);
    /**
     * 新增章节信息
     */
    void saveSection(CourseSection courseSection);

    void updateSection(CourseSection courseSection);

    /**
     * 修改章节状态
     * @param
     */
    void updateSectionStatus(int status,int id);
}
