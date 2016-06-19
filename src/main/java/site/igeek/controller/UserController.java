package site.igeek.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import site.igeek.model.common.JsonResponse;
import site.igeek.model.common.PaginationData;
import site.igeek.model.po.entity.User;
import site.igeek.monitor.Execute;
import site.igeek.service.UserService;

import java.util.Arrays;

/**
 * Created by jacobdong on 16/5/5.
 */
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 获取用户列表
     *
     * @param pageIndex 当前页
     * @param pageSize  每页显示的条数
     * @param orderBy   排序的字段
     * @param asc       是否正序排列
     * @return
     */
    @ApiOperation(value = "获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "访问的目标页", required = false, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示的数量", required = false, dataType = "int"),
            @ApiImplicitParam(name = "orderBy", value = "排序字段", required = false, dataType = "String"),
            @ApiImplicitParam(name = "asc", value = "是否正序", required = false, dataType = "boolean")
    })
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @Execute(name = "获取用户列表")
    public JsonResponse<PaginationData<User>> getAllUser(@RequestParam(required = false, defaultValue = "1") int pageIndex,
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


    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    @ApiOperation(value = "根据用户ID获取用户信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "boolean")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    @Execute(name = "根据用户ID获取用户信息")
    public JsonResponse<User> getUser(@PathVariable String userId) {
        return new JsonResponse<>(userService.getUser(userId));
    }

}
