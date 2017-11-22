package hafizdwp.app.androidmvpexample.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 11/21/2017.
 */

public class ApiGithubErrorPojo {

    @SerializedName("message")
    @Expose
    String message;

    @SerializedName("documentation_url")
    @Expose
    String documentationUrl;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocumentationUrl() {
        return documentationUrl;
    }

    public void setDocumentationUrl(String documentationUrl) {
        this.documentationUrl = documentationUrl;
    }
}
