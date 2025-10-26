package com.mdy.web.persistence.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mdy.web.persistence.entity.ChannelCompanyPayMethodEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 渠道-公司支付方式表配置
 * 
 * @author maodongya
 * @email maodongya@163.com
 * @date 2021-07-16 15:51:32
 */
@Mapper
public interface ChannelCompanyPayMethodDao extends BaseMapper<ChannelCompanyPayMethodEntity> {
	
}
