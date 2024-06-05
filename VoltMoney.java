package Volt_Money;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class VoltMoney {

    public static void main(String[] args) {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        // Valid Login
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("username")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Check if login was successful (presence of specific element)
        if (driver.findElement(By.className("product-container")).isDisplayed()) {
            System.out.println("Login successful with valid credentials!");
        } else {
            System.out.println("Login failed!");
        }

        // Invalid Login (wrong password)
        driver.navigate().back();
        driver.findElement(By.id("password")).sendKeys("invalid_password");
        driver.findElement(By.id("login-button")).click();

        // Check if error message is displayed
        if (driver.findElement(By.className("error-message")).isDisplayed()) {
            System.out.println("Login failed as expected with invalid password!");
        } else {
            System.out.println("Login unexpectedly successful with invalid password!");
        }

        driver.quit();
    }
}        // Test case b: “Add to cart” button functionality
        if (isLoggedIn) {
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            boolean isItemAdded = driver.findElements(By.className("shopping_cart_badge")).size() > 0;
            System.out.println("Add to cart functionality: " + (isItemAdded ? "Passed" : "Failed"));
        }

        // Test case c: “Remove” button functionality
        if (isLoggedIn) {
            driver.findElement(By.id("remove-sauce-labs-backpack")).click();
            boolean isItemRemoved = driver.findElements(By.className("shopping_cart_badge")).size() == 0;
            System.out.println("Remove functionality: " + (isItemRemoved ? "Passed" : "Failed"));
        }

        // Test case d: “Checkout Form” functionality
        if (isLoggedIn) {
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            driver.findElement(By.id("checkout")).click();
            
            // Filling the checkout form
            driver.findElement(By.id("first-name")).sendKeys("John");
            driver.findElement(By.id("last-name")).sendKeys("Doe");
            driver.findElement(By.id("postal-code")).sendKeys("12345");
            driver.findElement(By.id("continue")).click();

            // Check if we proceeded to the next checkout step
            boolean isCheckoutFormSubmitted = driver.findElements(By.id("finish")).size() > 0;
            System.out.println("Checkout form functionality: " + (isCheckoutFormSubmitted ? "Passed" : "Failed"));
        }

        // Close the browser
        driver.quit();
    }
}