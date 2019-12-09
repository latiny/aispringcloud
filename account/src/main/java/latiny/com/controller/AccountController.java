package latiny.com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Latiny
 * @version 1.0
 * @description: AccountController
 * @date 2019/12/9 16:47
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/index")
    public String index() {
        return port;
    }
}
