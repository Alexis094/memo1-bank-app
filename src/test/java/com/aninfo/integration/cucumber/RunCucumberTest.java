package com.aninfo.integration.cucumber;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        tags = "@CommonAccount and @PromoAccount"
        )
public class RunCucumberTest {}
