package com.example.pages;

import com.example.context.Context;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BasePage {

       public BasePage() {
            PageFactory.initElements(Context.getDriver(), this);
       }

}
