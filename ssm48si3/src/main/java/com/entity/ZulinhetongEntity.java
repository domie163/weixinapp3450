package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 租赁合同
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-04-09 22:16:50
 */
@TableName("zulinhetong")
public class ZulinhetongEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZulinhetongEntity() {
		
	}
	
	public ZulinhetongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 房屋编号
	 */
					
	private String fangwubianhao;
	
	/**
	 * 房屋名称
	 */
					
	private String fangwumingcheng;
	
	/**
	 * 状态
	 */
					
	private String zhuangtai;
	
	/**
	 * 租金
	 */
					
	private String zujin;
	
	/**
	 * 详细地址
	 */
					
	private String xiangxidizhi;
	
	/**
	 * 用户名
	 */
					
	private String yonghuming;
	
	/**
	 * 租客姓名
	 */
					
	private String zukexingming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 身份证
	 */
					
	private String shenfenzheng;
	
	/**
	 * 房东账号
	 */
					
	private String fangdongzhanghao;
	
	/**
	 * 房东姓名
	 */
					
	private String fangdongxingming;
	
	/**
	 * 联系手机
	 */
					
	private String lianxishouji;
	
	/**
	 * 租房状态
	 */
					
	private String zufangzhuangtai;
	
	/**
	 * 租赁日期
	 */
					
	private String zulinriqi;
	
	/**
	 * 签订时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date qiandingshijian;
	
	/**
	 * 租赁凭证
	 */
					
	private String zulinpingzheng;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：房屋编号
	 */
	public void setFangwubianhao(String fangwubianhao) {
		this.fangwubianhao = fangwubianhao;
	}
	/**
	 * 获取：房屋编号
	 */
	public String getFangwubianhao() {
		return fangwubianhao;
	}
	/**
	 * 设置：房屋名称
	 */
	public void setFangwumingcheng(String fangwumingcheng) {
		this.fangwumingcheng = fangwumingcheng;
	}
	/**
	 * 获取：房屋名称
	 */
	public String getFangwumingcheng() {
		return fangwumingcheng;
	}
	/**
	 * 设置：状态
	 */
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
	/**
	 * 设置：租金
	 */
	public void setZujin(String zujin) {
		this.zujin = zujin;
	}
	/**
	 * 获取：租金
	 */
	public String getZujin() {
		return zujin;
	}
	/**
	 * 设置：详细地址
	 */
	public void setXiangxidizhi(String xiangxidizhi) {
		this.xiangxidizhi = xiangxidizhi;
	}
	/**
	 * 获取：详细地址
	 */
	public String getXiangxidizhi() {
		return xiangxidizhi;
	}
	/**
	 * 设置：用户名
	 */
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
	/**
	 * 设置：租客姓名
	 */
	public void setZukexingming(String zukexingming) {
		this.zukexingming = zukexingming;
	}
	/**
	 * 获取：租客姓名
	 */
	public String getZukexingming() {
		return zukexingming;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：身份证
	 */
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	/**
	 * 设置：房东账号
	 */
	public void setFangdongzhanghao(String fangdongzhanghao) {
		this.fangdongzhanghao = fangdongzhanghao;
	}
	/**
	 * 获取：房东账号
	 */
	public String getFangdongzhanghao() {
		return fangdongzhanghao;
	}
	/**
	 * 设置：房东姓名
	 */
	public void setFangdongxingming(String fangdongxingming) {
		this.fangdongxingming = fangdongxingming;
	}
	/**
	 * 获取：房东姓名
	 */
	public String getFangdongxingming() {
		return fangdongxingming;
	}
	/**
	 * 设置：联系手机
	 */
	public void setLianxishouji(String lianxishouji) {
		this.lianxishouji = lianxishouji;
	}
	/**
	 * 获取：联系手机
	 */
	public String getLianxishouji() {
		return lianxishouji;
	}
	/**
	 * 设置：租房状态
	 */
	public void setZufangzhuangtai(String zufangzhuangtai) {
		this.zufangzhuangtai = zufangzhuangtai;
	}
	/**
	 * 获取：租房状态
	 */
	public String getZufangzhuangtai() {
		return zufangzhuangtai;
	}
	/**
	 * 设置：租赁日期
	 */
	public void setZulinriqi(String zulinriqi) {
		this.zulinriqi = zulinriqi;
	}
	/**
	 * 获取：租赁日期
	 */
	public String getZulinriqi() {
		return zulinriqi;
	}
	/**
	 * 设置：签订时间
	 */
	public void setQiandingshijian(Date qiandingshijian) {
		this.qiandingshijian = qiandingshijian;
	}
	/**
	 * 获取：签订时间
	 */
	public Date getQiandingshijian() {
		return qiandingshijian;
	}
	/**
	 * 设置：租赁凭证
	 */
	public void setZulinpingzheng(String zulinpingzheng) {
		this.zulinpingzheng = zulinpingzheng;
	}
	/**
	 * 获取：租赁凭证
	 */
	public String getZulinpingzheng() {
		return zulinpingzheng;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
