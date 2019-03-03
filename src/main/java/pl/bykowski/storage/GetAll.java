package pl.bykowski.storage;

import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.annotation.TableInput;

/**
 * Azure Functions with HTTP Trigger.
 */
public class GetAll {
    /**
     * This function listens at endpoint "/api/GetAll". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/GetAll
     * 2. curl {your host}/api/GetAll?name=HTTP%20Query
     */
    @FunctionName("getallcount")
    public int run(
            @HttpTrigger(name = "req",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS) Object dummyShouldNotBeUsed,
            @TableInput(name = "items",
                    tableName = "tab1", connection = "MyStorage") MyItem[] items
    ) {
        return items.length;
    }

}
