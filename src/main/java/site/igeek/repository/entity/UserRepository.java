package site.igeek.repository.entity;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import site.igeek.model.po.entity.User;

/**
 * Created by jacobdong on 16/5/5.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {

}
