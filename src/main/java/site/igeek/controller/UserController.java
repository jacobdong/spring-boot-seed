package site.igeek.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.igeek.model.common.JsonResponse;
import site.igeek.model.common.PaginationData;
import site.igeek.model.po.entity.User;
import site.igeek.service.UserService;

import java.util.Arrays;

/**
 * Created by jacobdong on 16/5/5.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    JsonResponse<PaginationData<User>> getAllUser(@RequestParam(required = false, defaultValue = "1") int pageIndex,
                                                  @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                  @RequestParam(required = false, defaultValue = "account") String orderBy,
                                                  @RequestParam(required = false, defaultValue = "false") boolean asc) {
        Sort sort = null;

        String[] sortProps = new String[]{"account", "createTime"};
        if (StringUtils.isNotBlank(orderBy) && Arrays.asList(sortProps).contains(orderBy)) {
            if (asc) {
                sort = new Sort(Sort.Direction.ASC, orderBy);
            } else {
                sort = new Sort(Sort.Direction.DESC, orderBy);
            }
        }

        return new JsonResponse<>(userService.getUsers(pageIndex, pageSize, sort));
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    JsonResponse<User> getUser(@PathVariable String userId) {
        return new JsonResponse<>(userService.getUser(userId));
    }

    @RequestMapping(value = "/{userId}/customers", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    JsonResponse<String> getxxx(@PathVariable String userId) {
        return new JsonResponse<>("abc123123123");
    }
}
