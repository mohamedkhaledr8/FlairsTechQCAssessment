package driver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CookiesFactory {
    private static final Map<String, String> cookieStore = new HashMap<>();

    private CookiesFactory() {}

    // ✅ Save cookies from the WebDriver session
    public static void saveCookies(WebDriver driver) {
        cookieStore.clear(); // clear previous session cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            cookieStore.put(cookie.getName(), cookie.getValue());
        }
        System.out.println("🍪 Saved cookies: " + cookieStore);
    }

    // ✅ Get cookie value by name (for example: "orangehrm")
    public static String getCookie(String name) {
        return cookieStore.get(name);
    }

    // ✅ Get all cookies as a Map<String, String>
    public static Map<String, String> getAllCookies() {
        return new HashMap<>(cookieStore);
    }

    // ✅ Clear all cookies from memory and browser
    public static void clearCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
        cookieStore.clear();
        System.out.println("🧹 All cookies cleared from browser and memory");
    }
}
