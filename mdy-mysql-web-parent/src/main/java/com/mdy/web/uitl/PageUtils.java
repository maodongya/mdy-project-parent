package com.mdy.web.uitl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月4日 下午12:59:00
 */
public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	//总记录数
	private int totalCount;
	//每页记录数
	private int pageSize;
	//总页数
	private int totalPage;
	//当前页数
	private int currPage;
	//列表数据
	private List<?> list;
	public PageUtils(IPage iPage) {
		this.list = iPage.getRecords();
		this.totalCount = (int)iPage.getTotal();
		this.pageSize = (int)iPage.getSize();
		this.currPage = (int)iPage.getCurrent();
		this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
	}
	/**
	 * 分页
	 * @param list        列表数据
	 * @param totalCount  总记录数
	 * @param pageSize    每页记录数
	 * @param currPage    当前页数
	 */
	public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
		this.list = list;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	/**
	 * 获得唯一的对象
	 * @param <T>
	 * @return
	 */
	public <T> T getSingleEntity(){
		MdyAssert.check(list!=null && list.size()==1,"result is null or not single");
		return (T)list.get(0);
	}
	/**
	 * 获得第一个的对象
	 * @param <T>
	 * @return
	 */
	public <T> T getFirstEntity(){
		MdyAssert.check(list!=null && list.size()==1,"result is null");
		return (T)list.get(0);
	}
	public <R> R convertSingleBean(Class<R> clz){
		Object t=getSingleEntity();
		if(clz.isAssignableFrom(t.getClass())){
			return (R)t;
		}
		R r= null;
		try {
			r = clz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		BeanUtils.copyProperties(getSingleEntity(),r);
		return r;
	}
	public <R> R converFirstEntity(Class<R> clz){
		Object t=getFirstEntity();
		if(clz.isAssignableFrom(t.getClass())){
			return (R)t;
		}
		R r= null;
		try {
			r = clz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		BeanUtils.copyProperties(getSingleEntity(),r);
		return r;
	}

	public static void main(String args[]){
		System.out.println(String.class.isAssignableFrom(Object.class));
		System.out.println(String.class.isAssignableFrom(String.class));
		System.out.println(Object.class.isAssignableFrom(String.class));
		System.out.println(Object.class.isAssignableFrom(Object.class));

	}


    /**
     * 查询参数
     *
     * @author maodongya
     * @email mdy2010life@163.com
     */
    @Data
    public static class Query<T> extends LinkedHashMap<String, Object> {
        private static final long serialVersionUID = 1L;
        private static int DEFAULT_PAGE=1;
        private static int DEFAULT_LIMIT=100;
        /**
         * 当前offset
         */
        private int offset;
        /**
         * 当前页码
         */
        private int page;
        /**
         * 每页条数
         */
        private int limit;


        public Query() {
            super();
            this.init(DEFAULT_PAGE,DEFAULT_LIMIT);
        }

        /**
         * args 数组。key1，value1；key2，value2；
         * @param args
         */
        public Query(Object... args) {
            super();
            MdyAssert.check(args!=null && args.length%2==0,"非法的参数 args");
            this.init(DEFAULT_PAGE,DEFAULT_LIMIT);
            for(int i=0;i<args.length/2;i++){
                put(args[i*2].toString(),args[i*2+1]);
            }
        }

        @Override
        public Object get(Object key) {
            return super.get(key!=null?key.toString():key);
        }

        /**
         *
         * @param page
         * @param limit
         */
        public Query( int page, int limit) {
            super();
            if(page<1){
                throw new IllegalArgumentException("Illegal initial page: " +
                        page);
            }
            if(limit<1){
                throw new IllegalArgumentException("Illegal initial limit: " +
                        limit);
            }
            this.init(page,limit);
        }

        public Query(Map<? extends String, ?> m) {
            super(m);
            this.init(DEFAULT_PAGE,DEFAULT_LIMIT);
        }

        private Query init(int page, int limit){
            //分页参数
            this.page = page;
            this.limit = limit;
            this.offset=(page - 1) * limit;
            return this;
        }


        public void setPage(int page) {
            this.page = page;
            this.put("page",page);
        }

        public PageDTO toPageDTO(){
            return new PageDTO(page,limit);
        }


        public QueryWrapper<T> toQueryWrapper(Class<T> clz){
            T entity= JSON.parseObject(JSON.toJSONString(this),clz);
            return new QueryWrapper(entity);
        }

    }

}
