package site.igeek.service;

import org.springframework.stereotype.Service;
import site.igeek.monitor.Execute;

/**
 * Created by jacobdong on 16/6/13.
 */
@Service
public class InvokeService {

    @Execute(name = "调用添加方法")
    public void add() {

    }
}
