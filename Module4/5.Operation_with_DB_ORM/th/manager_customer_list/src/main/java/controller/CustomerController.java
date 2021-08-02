package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import repository.BaseRepository;

@Controller
public class CustomerController {
@Autowired
    BaseRepository baseRepository;

}
