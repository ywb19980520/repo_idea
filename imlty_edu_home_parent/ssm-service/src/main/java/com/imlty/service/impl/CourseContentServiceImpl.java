package com.imlty.service.impl;

import com.imlty.domain.Course;
import com.imlty.domain.CourseSection;
import com.imlty.dao.CourseContentMapper;
import com.imlty.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId) {
        return courseContentMapper.findSectionAndLessonByCourseId(courseId);
    }

    @Override
    public Course findCourseByCourseId(Integer courseId) {
        return courseContentMapper.findCourseById(courseId);
    }

    @Override
    public void saveSection(CourseSection courseSection) {
        //补全信息
        Date date = new Date();
        courseSection.setUpdateTime(date);
        courseSection.setCreateTime(date);

        //插入
        courseContentMapper.saveSection(courseSection);
    }

    @Override
    public void updateSection(CourseSection courseSection) {
        //补全信息
        courseSection.setUpdateTime(new Date());

        //更新
        courseContentMapper.updateSection(courseSection);
    }

    @Override
    public void updateSectionStatus(int status,int id) {
        CourseSection courseSection = new CourseSection();
        courseSection.setUpdateTime(new Date());
        courseSection.setId(id);
        courseSection.setStatus(status);
        courseContentMapper.updateSectionStatus(courseSection);
    }
}
