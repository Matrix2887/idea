package com.pinyougou.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.coutent.service.ContentService;
import com.pinyougou.pojo.TbContent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/content")
public class ContentController {

    @Reference
    private ContentService contentService;

    @RequestMapping("/findByCategoryId")
    public List<TbContent> findByCategoryId(Long categoryId){
        List<TbContent> tbContents = contentService.findByCategoryId(categoryId);
        return tbContents;
    }

}
