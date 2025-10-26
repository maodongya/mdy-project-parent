package com.mdy.web.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 渠道-公司支付方式表配置
 * 
 * @author maodongya
 * @email maodongya@163.com
 * @date 2021-07-16 15:51:32
 */
@Data
@TableName("mdy_channel_company_pay_method")
public class ChannelCompanyPayMethodEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 子支付公司支付方式id
	 */
	@TableId
	private Integer id;
	/**
	 * 公司编码
	 */
	private String companyNo;
	/**
	 * 子公司编码
	 */
	private String subCompanyNo;
	/**
	 * 支付方式编码
	 */
	private String payMethodNo;
	/**
	 * 支持银行卡类型
	 */
	private String cardType;
	/**
	 * 单笔接口：single，还是批量接口：batch
	 */
	private String singleOrBatch;
	/**
	 * 同步接口：synchronise，异步接口：asynchronous
	 */
	private String synchroniseOrAsynchronous;
	/**
	 * 签名证书编码
	 */
	private String certificateNo;
	/**
	 * 支持的银行列表：银行列表简写，用逗号分割
	 */
	private String bankConfig;
	/**
	 * 费率配置
	 */
	private String feeConfig;
	/**
	 * 币种配置
	 */
	private String currencyConfig;
	/**
	 * 支付要素配置
	 */
	private String payElementsConfig;
	/**
	 * 支付限额
	 */
	private String paymentLimitConfig;
	/**
	 * 创建时间
	 */
	private Date createdAt;
	/**
	 * 更新时间
	 */
	private Date updatedAt;
	/**
	 * 删除时间
	 */
	private Integer deleteAt;
	/**
	 * 创建人员
	 */
	private String creator;
	/**
	 * 更新人员
	 */
	private String updater;

}
