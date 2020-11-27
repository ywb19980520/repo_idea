package com.imlty.service;

import com.imlty.domain.Course;
import com.imlty.vo.CourseTeacherVO;
import com.imlty.vo.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {

    /**
     * 多条件查询
     */
    List<Course> findCourseByCondition(CourseVO courseVo);

    /**
     * 添加课程和讲师信息
     */
     void saveCourseOrTeacher(CourseTeacherVO courseTeacherVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 根据id查询课程信息
     */
    CourseTeacherVO findCourseById(Integer id);
    /**
     * 更新课程以及讲师信息
     */
    void updateCourseOrTeacher(CourseTeacherVO courseTeacherVo) throws InvocationTargetException, IllegalAccessException;
    /**
     * 更新课程状态值
     */
    void updateCourseStatus(int id,int status);
}
