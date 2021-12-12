package com.ahzc.stu;

import com.ahzc.stu.entity.Admin;
import com.ahzc.stu.entity.Movie;
import com.ahzc.stu.entity.MovieType;
import com.ahzc.stu.entity.News;
import com.ahzc.stu.service.IAdminService;
import com.ahzc.stu.service.IMovieService;
import com.ahzc.stu.service.IMovieTypeService;
import com.ahzc.stu.service.INewsService;
import com.ahzc.stu.vo.ResultBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StuApplicationTests {
    @Autowired
    private IAdminService adminService;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private IMovieTypeService movieTypeService;

    @Autowired
    private INewsService newsService;

    @Test
    void contextLoads() {

    }

    @Test
    public void admin(){
//        System.out.println(adminService.loginVerify("admin", "123456"));
        Admin admin = new Admin();
        admin.setUsername("root");
        admin.setPassword("12341234");
        System.out.println(adminService.updatePwd(admin));
    }

    @Test
    public void movie(){
        Movie movie = new Movie();
        System.out.println(movieService.queryAll(movie));
    }

    @Test
    public void movieType(){
//        MovieType type = new MovieType();
//        System.out.println(movieTypeService.queryAll(type));
        System.out.println(movieTypeService.delMany("11,14"));
    }

    @Test
    public void news(){
        News news = new News();
        System.out.println(newsService.queryAll(news));
    }
}
