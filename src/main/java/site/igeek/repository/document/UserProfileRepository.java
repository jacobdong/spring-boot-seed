package site.igeek.repository.document;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import site.igeek.model.po.document.UserProfile;

/**
 * Created by jacobdong on 16/6/5.
 */
@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, String> {
}
