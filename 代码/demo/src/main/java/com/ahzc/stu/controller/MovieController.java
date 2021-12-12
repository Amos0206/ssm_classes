package com.ahzc.stu.controller;

import com.ahzc.stu.entity.Movie;
import com.ahzc.stu.entity.MovieType;
import com.ahzc.stu.service.IMovieService;
import com.ahzc.stu.service.IMovieTypeService;
import com.ahzc.stu.utils.StringUtil;
import com.ahzc.stu.vo.ResultBean;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/6 21:16
 * @desc
 */
@Controller
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private IMovieService iMovieService;

    @Autowired
    private IMovieTypeService movieTypeService;

    @Resource
    private FastFileStorageClient client;

    @Value("${imgBaseServer}")
    private String imgServer;

    /**
     * 电影视图
     * @param model
     * @param movie
     * @return
     */
    @GetMapping("list")
    public String movieList(Model model, Movie movie){
//        System.out.println(movie);
        model.addAttribute("types",movieTypeService.queryAll(null));
        model.addAttribute("movies",iMovieService.queryAll(movie));
        model.addAttribute("imgServer",imgServer);
        return "movie/movie-list";
    }

    /**
     * 类别
     * @param model 视图
     * @param movieType 类别
     * @return 类别展示视图
     */
    @GetMapping("type")
    public String movieType(Model model, MovieType movieType){
        List<MovieType> movieTypes = movieTypeService.queryAll(movieType);
        model.addAttribute("types",movieTypes);
        return "movie/movie-type";
    }

    @GetMapping("del/{id}")
    @ResponseBody
    public ResultBean del(@PathVariable("id") Integer id){
        return iMovieService.del(id);
    }

    @GetMapping("addHtml")
    public String addHtml(Model model){
        model.addAttribute("types",movieTypeService.queryAll(null));
        return "movie/movie-add";
    }

    @GetMapping("add")
    @ResponseBody
    public ResultBean add(Movie movie){
        return iMovieService.add(movie);
    }

    @GetMapping("delmany")
    @ResponseBody
    public ResultBean delmany(String ids){
        return iMovieService.delmany(ids);
    }

    @GetMapping("editHtml")
    public String editHtml(Model model,Integer id){
        Movie movie = iMovieService.queryById(id);
        model.addAttribute("types",movieTypeService.queryAll(null));
        model.addAttribute("list",movie);
        return "movie/movie-edit";
    }

    @GetMapping("edit")
    @ResponseBody
    public ResultBean edit(Movie movie){
        return iMovieService.edit(movie);
    }

    @GetMapping("type/del/{id}")
    @ResponseBody
    public ResultBean delType(@PathVariable("id") Integer id){
        return movieTypeService.del(id);
    }

    @GetMapping("type/delMany")
    @ResponseBody
    public ResultBean typeDelMany(String ids){
        return movieTypeService.delMany(ids);
    }

    @GetMapping("/type/addHtml")
    public String addTypeHtml(Model model){
        return "type/movie-type-add";
    }

    @GetMapping("/type/add")
    @ResponseBody
    public ResultBean typeAdd(MovieType movie){
        return movieTypeService.add(movie);
    }

    @GetMapping("type/editHtml")
    public String editTypeHtml(Model model,Integer id){
        MovieType type = movieTypeService.queryById(id);
        model.addAttribute("list",type);
        return "type/movie-type-edit";
    }

    @GetMapping("/type/edit")
    @ResponseBody
    public ResultBean editType(MovieType movie){
        return movieTypeService.edit(movie);
    }


    @RequestMapping("uploadImg")
    @ResponseBody()
    public ResultBean toUploadFile(MultipartFile dropzFile){
        //1、获取上传为文件名称
        String originalFilename = dropzFile.getOriginalFilename();
//        System.out.println(originalFilename);

        //2、获取文件后缀名
        String extName = StringUtil.getExtName(originalFilename);

        String fullPath = " ";
        try {
            //3、获取文件输入流
            InputStream is = dropzFile.getInputStream();

            StorePath storePath = client.uploadFile(is, dropzFile.getSize(), extName, null);

            fullPath = storePath.getFullPath();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultBean.success("success",fullPath);

    }
}
