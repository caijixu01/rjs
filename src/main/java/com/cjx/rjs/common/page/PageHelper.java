package com.cjx.rjs.common.page;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;

import com.cjx.rjs.util.SystemConfig;

/**
 * 通用分页拦截器
 * @author caijx
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Intercepts(@Signature(type = Executor.class, method = "query", args = {
		MappedStatement.class, Object.class, RowBounds.class,
		ResultHandler.class }))
public class PageHelper implements Interceptor {
	/**
	 * sql工具类
	 */
	private static SqlUtil SQLUTIL = null;

	/**
	 * Mybatis拦截器方法
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		final Object[] args = invocation.getArgs();

		if (((MappedStatement) args[0]).getId().matches(".*Page$")) {
			Integer pageNum = (Integer) BeanUtils.getPropertyDescriptor(args[1].getClass(), "pageNum").getReadMethod().invoke(args[1], new Object[0]);
			Integer pageSize = (Integer) BeanUtils.getPropertyDescriptor(args[1].getClass(), "pageSize").getReadMethod().invoke(args[1], new Object[0]);
			
            if (pageSize == null) {
                pageSize = 10;
            }

            if (pageNum == null) {
                pageNum = 1;
            }
			
			Page<?> page = null;
			page = new Page();
			page.setPageNum(pageNum);
			page.setPageSize(pageSize);
			page.setStartRow(pageNum > 0 ? (pageNum - 1) * pageSize : 0);
			page.setEndRow(pageNum * pageSize);

			// 忽略RowBounds-否则会进行Mybatis自带的内存分页
			args[2] = RowBounds.DEFAULT;
			// 获取原始的ms
			MappedStatement ms = (MappedStatement) args[0];
			
			SqlSource sqlSource = ms.getSqlSource();
			// 将参数中的MappedStatement替换为新的qs
			SQLUTIL.processCountMappedStatement(ms, sqlSource, args);
			// 查询总数
			Object totalResult = invocation.proceed();
			// 设置总数
			long totalRowCounts = ((Integer) ((List) totalResult).get(0)).longValue();
			page.setTotalRowCounts(totalRowCounts);
			long totalPageCounts = totalRowCounts / page.getPageSize() + ((totalRowCounts % page.getPageSize() == 0) ? 0 : 1);  
            page.setTotalPageCounts(totalPageCounts);  
			// 将参数中的MappedStatement替换为新的qs
			SQLUTIL.processPageMappedStatement(ms, sqlSource, page,
					args);
			// 执行分页查询
			Object list = invocation.proceed();
			// 得到处理结果
			page.setList((List) list);
			
			//--------------------------
			PageList pageList = new PageList();
			pageList.setPageNum(page.getPageNum());
			pageList.setPageSize(page.getPageSize());
			pageList.setStartRow(page.getStartRow());
			pageList.setEndRow(page.getEndRow());
			pageList.setTotalPageCounts(page.getTotalPageCounts());
			pageList.setTotalRowCounts(page.getTotalRowCounts());
			if (page.getList() != null) {
				pageList.addAll(page.getList());
			}
			
			return pageList;
		}
		
		// 返回结果
		return invocation.proceed();
	}

	/**
	 * 只拦截Executor
	 */
	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	/**
	 * 设置属性值
	 */
	public void setProperties(Properties p) {
		String dialect = SystemConfig.getValue("jdbc.dbtype");
		if (dialect == null) {
			dialect = "oracle"; // 默认oracle数据库
		}
		SQLUTIL = new SqlUtil(dialect);
	}
}
