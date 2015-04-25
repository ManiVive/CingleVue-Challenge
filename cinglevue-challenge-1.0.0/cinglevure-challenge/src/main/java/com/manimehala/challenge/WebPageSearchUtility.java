package com.manimehala.challenge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageSearchUtility {

    /**
     * This method searches 'http://www.cinglevue.com' website for the term
     * given as arguments and verifies whether the No. of hits is more than the
     * provided minimum value.
     * 
     * @param searchTerm - Term to search on the Webpage.
     * @param minimumHits - Minimum No. of hits.
     */
    public void assertNumberOfHits(String searchTerm, final int minimumHits) {
        // Create a new instance of the Firefox driver to invoke the Web page
        // URL.
        final WebDriver driver = new FirefoxDriver();

        // Do a HTTP GET to 'http://www.cinglevue.com'
        driver.get("http://www.cinglevue.com");

        // Get the Search text input element.
        final WebElement element = driver.findElement(By.name("search_block_form"));

        // Enter the 'searchTerm'
        element.sendKeys(searchTerm);

        // Submit the form.
        element.submit();

        // Create a Waiter
        final WebDriverWait waitDriver = new WebDriverWait(driver, 15);
        waitDriver.withMessage("Searching for " + searchTerm + "...");

        // Ignore all exceptions (return on exceptions)
        waitDriver.ignoring(Exception.class);

        final ExpectedCondition<String> condition = new ExpectedCondition<String>() {
            @Test
            public String apply(WebDriver resultsPageDriver) {
                final String xpathToExtractResults = "//div[@class='col-xs-12']/p";
                final WebElement element = resultsPageDriver.findElement(By.xpath(xpathToExtractResults));

                final String elementText = element.getText();
                final String[] parts = elementText.split(" ");
                // Add the No. of pages and documents returned for the search.
                int noOfHits = Integer.parseInt(parts[2]) + Integer.parseInt(parts[5]);
                System.out.println("No. of Hits: " + noOfHits);

                // Assert it against the given minimum value.
                Assert.assertTrue("", noOfHits > minimumHits);

                // Quit the browser
                driver.quit();
                return elementText;
            }
        };

        waitDriver.until(condition);
    }

}