/* package com.example.serverapp.config;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ClientCredentialValidation {

    private static final Map<String, String> CLIENTS = Map.of(
    		 "client-app-1", "Pass@12345A",
             "client-app-2", "Pass@12345B"
    );

    public boolean isValid(String clientId, String password) {
        return CLIENTS.containsKey(clientId)
                && CLIENTS.get(clientId).equals(password);
    }
}

*/

package com.example.serverapp.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ClientCredentialValidation {

    private static final Map<String, String> CLIENTS;

    static {
        Map<String, String> temp = new HashMap<>();
        temp.put("client-app-1", "Pass@12345A");
        temp.put("client-app-2", "Pass@12345B");
        CLIENTS = Collections.unmodifiableMap(temp);
    }

    public boolean isValid(String clientId, String password) {
        if (clientId == null || password == null) {
            return false;
        }
        return password.equals(CLIENTS.get(clientId));
    }
}
