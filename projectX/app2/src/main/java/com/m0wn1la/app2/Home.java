package com.m0wn1la.app2;

import com.m0wn1la.app2.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/home")
public class Home {


    @RequestMapping(method = RequestMethod.GET)
    public String Test() {
        User user=new User();
        return "hi";
    }


}
