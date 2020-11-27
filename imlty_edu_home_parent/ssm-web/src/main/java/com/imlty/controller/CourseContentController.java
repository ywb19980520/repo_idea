package com.imlty.controller;

import com.imlty.domain.Course;
import com.imlty.domain.CourseSection;
import com.imlty.domain.ResponseResult;
import com.imlty.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    /**
     *
     * @param courseId
     * @return
     */
    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(Integer courseId){
        List<CourseSection> courseSectionList = courseContentService.findSectionAndLessonByCourseId(courseId);
         return new ResponseResult(true,200,"查询成功",courseSectionList);
    }

    /**
     * 回显章节信息
     */
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer courseId){
        Course course = courseContentService.findCourseByCourseId(courseId);
        return new ResponseResult(true,200,"查询课程信息成功",course);
    }

    /**
     * 新增或者更新章节信息
     */
    @PostMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){

        ResponseResult result = new ResponseResult(true, 200, "新增成功", null);
        //判断
        if (courseSection.getId() != null){
            //更新
            courseContentService.updateSection(courseSection);
            result.setMessage("更新成功");
        }else {
            //新增
            courseContentService.saveSection(courseSection);
        }
        return result;
    }

    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(int id,int status){
        courseContentService.updateSectionStatus(status,id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("status",status);
        return new ResponseResult(true,200,"修改状态成功",map);
    }
}
