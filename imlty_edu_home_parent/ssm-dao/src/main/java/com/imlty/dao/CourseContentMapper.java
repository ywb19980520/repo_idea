package com.imlty.dao;

import com.imlty.domain.Course;
import com.imlty.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {

    /**
     * 根据课程id查询关联的章节信息,以及章节关联的 课时信息
     */
    List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);
    /**
     * 回显课程id对应的章节信息
     */
    Course findCourseById(Integer courseId);
    /**
     * 新增章节信息
     */
    void saveSection(CourseSection courseSection);

    void updateSection(CourseSection courseSection);

    /**
     * 修改章节状态
     */
    void updateSectionStatus(CourseSection courseSection);
}
