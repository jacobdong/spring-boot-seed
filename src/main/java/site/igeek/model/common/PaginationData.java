package site.igeek.model.common;

import java.util.List;


/**
 * Created by jacobdong on 15/7/30.
 */
public class PaginationData<T> {

    private Pagination pagination;
    private List<T> pageData;

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public PaginationData(Pagination pagination, List<T> pageData) {
        this.setPageData(pageData);
        this.setPagination(pagination);
    }
    public PaginationData() {
        
    }
    
}
