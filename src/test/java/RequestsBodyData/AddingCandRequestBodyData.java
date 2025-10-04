package RequestsBodyData;

import RequestsBody.AddingCandRequestBody;
import com.github.javafaker.Faker;
import utils.Utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddingCandRequestBodyData {


    public AddingCandRequestBody FillAllCandRequiredData()
    {
        var faker = new Faker();
        var utils = new Utility();
        String[] prefixes = {"010", "011", "012", "015"};

        String prefix = prefixes[faker.number().numberBetween(0, prefixes.length)];
        String number = prefix + faker.number().digits(8);
        return  new AddingCandRequestBody(faker.name().firstName(),faker.name().nameWithMiddle(),faker.name().lastName(),faker.internet().emailAddress(),number,null,null,utils.getCurrentDate("yyyy-MM-dd"),false,5);
    }
}
