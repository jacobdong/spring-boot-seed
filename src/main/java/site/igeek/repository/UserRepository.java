package site.igeek.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import site.igeek.model.po.User;

/**
 * Created by jacobdong on 16/5/5.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {

}
