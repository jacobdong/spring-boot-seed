package site.igeek.convert;

import org.springframework.data.domain.Page;
import site.igeek.model.common.Pagination;
import site.igeek.model.common.PaginationData;

import java.util.ArrayList;

/**
 * Created by jacobdong on 16/5/5.
 */
public class PaginationDataConvert {

    public static PaginationData convertJpaPage2PaginationData(Page jpaPage, int pageSize) {

        PaginationData paginationData = new PaginationData();

        Pagination pagination = new Pagination();


        if (jpaPage.getSize() == 0) {
            pagination.setPageIndex(1);
            pagination.setPageSize(pageSize);
            pagination.setTotalPage(1);
            pagination.setResultSize(0);

            paginationData.setPagination(pagination);
            paginationData.setPageData(new ArrayList<>());
        } else {

            pagination.setPageIndex(jpaPage.getNumber() + 1);
            pagination.setPageSize(jpaPage.getSize());
            pagination.setTotalPage(jpaPage.getTotalPages());
            pagination.setResultSize(jpaPage.getTotalElements());

            paginationData.setPagination(pagination);
            paginationData.setPageData(jpaPage.getContent());
        }

        return paginationData;

    }
}
