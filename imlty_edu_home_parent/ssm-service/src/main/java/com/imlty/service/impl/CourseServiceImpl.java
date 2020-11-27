package com.imlty.service.impl;

import com.imlty.domain.Course;
import com.imlty.vo.CourseTeacherVO;
import com.imlty.vo.CourseVO;
import com.imlty.domain.Teacher;
import com.imlty.dao.CourseMapper;
import com.imlty.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByCondition(CourseVO courseVo) {
        return courseMapper.findCourseByCondition(courseVo);
    }

    /**
     * 新增课程信息和讲师信息
     * @param courseTeacherVo
     */
    @Override
    public void saveCourseOrTeacher(CourseTeacherVO courseTeacherVo) throws InvocationTargetException, IllegalAccessException {
        //1.封装课程信息
        Course course = new Course();

        //使用BeanUtils拷贝信息
        BeanUtils.copyProperties(course,courseTeacherVo);


        Date date = new Date();
        //补全课程信息
        course.setCreateTime(date);
        course.setUpdateTime(date);
        //保存课程
        courseMapper.saveCourse(course);

        //在xml中获取了新插入的数据的id值
        int courseId = course.getId();
        //2.封装讲师信息

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseTeacherVo);

        //补全信息
        teacher.setCourseId(courseId);
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setIsDel(0);//默认为零,表示逻辑不删除

        //插入讲师信息
        courseMapper.saveTeacher(teacher);

    }

    @Override
    public CourseTeacherVO findCourseById(Integer id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseTeacherVO courseTeacherVo) throws InvocationTargetException, IllegalAccessException {

        //封装课程信息
        Course course = new Course();
        BeanUtils.copyProperties(course,courseTeacherVo);

        Date date = new Date();
        //信息补全以及更新
        course.setUpdateTime(date);
        courseMapper.updateCourse(course);

        //封装讲师表
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseTeacherVo);

        //补全信息并更新
        //!!!一定要补全 教师表的课程id
        teacher.setCourseId(courseTeacherVo.getId());
        teacher.setUpdateTime(date);
        courseMapper.updateTeacher(teacher);
    }

    /**
     * 跟新课程状态值
     * @param
     */
    @Override
    public void updateCourseStatus(int id,int status) {

        //封装数据
        Course course = new Course();
        course.setId(id);
        course.setStatus(status);
        course.setUpdateTime(new Date());

        //调用dao层
        courseMapper.updateCourseStatus(course);
    }
}
