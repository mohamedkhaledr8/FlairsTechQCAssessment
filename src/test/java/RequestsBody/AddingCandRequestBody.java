package RequestsBody;

public class AddingCandRequestBody {
    public String firstName;
    public String middleName;
    public String lastName;
    public String email;
    public String contactNumber;
    public Object keywords;
    public Object comment;
    public String dateOfApplication;
    public boolean consentToKeepData;
    public int vacancyId;

    public AddingCandRequestBody(String firstName, String middleName, String lastName, String email, String contactNumber, Object keywords, Object comment, String dateOfApplication, boolean consentToKeepData, int vacancyId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.keywords = keywords;
        this.comment = comment;
        this.dateOfApplication = dateOfApplication;
        this.consentToKeepData = consentToKeepData;
        this.vacancyId = vacancyId;
    }
}
