package com.cjx.rjs.common.page;

import java.util.ArrayList;

public class PageUtil {
    public static <T> Page<T> toPage(PageList<T> pageList) {
        Page<T> page = new Page<T>();
        
        page.setPageNum(pageList.getPageNum());
        page.setPageSize(pageList.getPageSize());
        page.setStartRow(pageList.getStartRow());
        page.setEndRow(pageList.getEndRow());
        page.setTotalPageCounts(pageList.getTotalPageCounts());
        page.setTotalRowCounts(pageList.getTotalRowCounts());
        page.setList(new ArrayList<T>(pageList));
        
        return page;
    }
}
