package edu.xidian.boot.controller;

import java.util.List;

import edu.xidian.boot.common.BaseResponse;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.xidian.boot.model.Student;
import edu.xidian.boot.service.StudentService;

@RestController
@RequestMapping("/stus")
@Slf4j
@Api(value = "学生管理接口", tags = "学生管理API")
public class StudentController {

    @Autowired
    private StudentService stuService;

    @ApiOperation(value = "获取学生详情", notes = "获取学生详情")
    @GetMapping("/{stuId}")
    public BaseResponse<Student> getStu(@ApiParam(name = "stuId", value = "学生Id") @PathVariable Integer stuId) {
        Student student = stuService.getStu(stuId);
        BaseResponse<Student> response = new BaseResponse<>();
        response.setData(student);
        return response;

    }

    @ApiOperation(value = "获取学生列表", notes = "获取学生列表")
    @GetMapping("/")
    public BaseResponse<List<Student>> getStuAll() {
        List<Student> list = stuService.getPerAll();
        BaseResponse<List<Student>> response = new BaseResponse<>();
        response.setData(list);
        return response;
    }

    @ApiOperation(value = "修改学生信息", notes = "修改学生信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "stuId", value = "学生id", required = true),
            @ApiImplicitParam(name = "Student", value = "学生信息", required = true)})
    @PutMapping("/{stuId}")
    public BaseResponse updatePerById(@PathVariable Integer stuId, @RequestBody Student student) {
//        Student student = new Student();
        student.setId(stuId);
        log.debug("stu is {}", student);
        stuService.updatePerById(student);
        return new BaseResponse().success();
    }

    @ApiOperation(value = "新增学生", notes = "新增学生")
    @PostMapping("/add")
    public BaseResponse<Student> insert(@ApiParam(name = "student", value = "新增学生") @RequestBody Student student) {
//        Student student = new Student(3, "王五", 22, null, "郑州", false, Marital.ENGAGED);
        student.setId(null);
        stuService.insert(student);
        return new BaseResponse().success(student);
    }


    @ApiOperation(value = "删除学生", notes = "删除学生")
    @DeleteMapping("/{stuId}")
    public BaseResponse delete(@ApiParam(name = "stuId", value = "学生id") @PathVariable Integer stuId){
        stuService.delete(stuId);
        return new BaseResponse().success();
    }

}
