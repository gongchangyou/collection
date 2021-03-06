package com.mouse.collection;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicInteger;



@Slf4j
@SpringBootTest
class CloneableTests {
    public  class School implements Cloneable{
        private String schoolName;   //学校名称
        private int stuNums;         //学校人数
        private Student stu;         //一个学生
        public String getSchoolName() {
            return schoolName;
        }
        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }
        public int getStuNums() {
            return stuNums;
        }
        public void setStuNums(int stuNums) {
            this.stuNums = stuNums;
        }
        public Student getStu() {
            return stu;
        }
        public void setStu(Student stu) {
            this.stu = stu;
        }
        @Override
        protected School clone() throws CloneNotSupportedException {
            // TODO Auto-generated method stub
            return (School)super.clone();
        }
        @Override
        public String toString() {
            return "School [schoolName=" + schoolName + ", stuNums=" + stuNums + ", stu=" + stu + "]";
        }

    }

    class Student {
        private String name;   //姓名
        private int age;       //年龄
        private StringBuffer sex;  //性别
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public StringBuffer getSex() {
            return sex;
        }
        public void setSex(StringBuffer sex) {
            this.sex = sex;
        }
        @Override
        public String toString() {
            return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
        }

    }


    @Test
    void contextLoads() {
        try {
            School s1 = new School();
            s1.setSchoolName("实验小学");
            s1.setStuNums(100);
            Student stu1 = new Student();
            stu1.setAge(20);
            stu1.setName("zhangsan");
            stu1.setSex(new StringBuffer("男"));
            s1.setStu(stu1);
            System.out.println("s1: "+s1+" s1的hashcode:"+s1.hashCode()+"  s1中stu1的hashcode:"+s1.getStu().hashCode());
            School s2 = s1.clone();  //调用重写的clone方法，clone出一个新的school---s2
            s2.getStu().setName("lisi");
            System.out.println("s1: "+s1+" s1的hashcode:"+s1.hashCode()+"  s1中stu1的hashcode:"+s1.getStu().hashCode());
            System.out.println("s2: "+s2+" s2的hashcode:"+s2.hashCode()+" s2中stu1的hashcode:"+s2.getStu().hashCode());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
