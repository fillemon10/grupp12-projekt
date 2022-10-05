package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.Model;

public class HomePageController implements IController {
    private Model model;

    public HomePageController(){
        model = Model.getInstance();
    }
}
