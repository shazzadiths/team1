package com.example.produktapi.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features =  "src/test/resources", glue = "com.example.produktapi")
public class RunCucumberTest {

}
