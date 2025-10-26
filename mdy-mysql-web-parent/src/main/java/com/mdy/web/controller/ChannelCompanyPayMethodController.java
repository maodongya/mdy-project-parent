package com.mdy.web.controller;

import com.mdy.web.persistence.entity.ChannelCompanyPayMethodEntity;
import com.mdy.web.service.inter.ChannelCompanyPayMethodService;
import com.mdy.web.uitl.PageUtils;
import com.mdy.web.uitl.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 渠道-公司支付方式表配置
 *
 * @author maodongya
 * @email maodongya@163.com
 * @date 2021-07-16 15:51:32
 */
@RestController
@RequestMapping("channel/channelcompanypaymethod")
public class ChannelCompanyPayMethodController {
    @Autowired
    private ChannelCompanyPayMethodService channelCompanyPayMethodService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = channelCompanyPayMethodService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		ChannelCompanyPayMethodEntity channelCompanyPayMethod = channelCompanyPayMethodService.getById(id);

        return R.ok().put("channelCompanyPayMethod", channelCompanyPayMethod);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChannelCompanyPayMethodEntity channelCompanyPayMethod){
		channelCompanyPayMethodService.save(channelCompanyPayMethod);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChannelCompanyPayMethodEntity channelCompanyPayMethod){
		channelCompanyPayMethodService.updateById(channelCompanyPayMethod);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		channelCompanyPayMethodService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
