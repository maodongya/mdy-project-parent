package com.mdy.web.service.inter;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mdy.web.persistence.entity.ChannelCompanyPayMethodEntity;
import com.mdy.web.uitl.PageUtils;

import java.util.Map;

/**
 * 渠道-公司支付方式表配置
 *
 * @author maodongya
 * @email maodongya@163.com
 * @date 2021-07-16 15:51:32
 */
public interface ChannelCompanyPayMethodService extends IService<ChannelCompanyPayMethodEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

