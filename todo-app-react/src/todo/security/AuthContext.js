import {createContext, useContext, useState} from "react";
import {executeBasicAuthenticationService} from "../api/AuthenticationApiService";
import {executeJwtAuthenticationService} from "../api/AuthenticationApiService";

import {apiClient} from "../api/ApiClientUrl";

export const AuthContext = createContext();

export const useAuthContext = () => useContext(AuthContext);

export default function AuthProvider({ children })
{

    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [username, setUsername] = useState(null);
    const [token, setToken] = useState(null);

    /*function login(username, password)
    {
        if(username === "DogRaj" && password === "Mr. India")
        {
            setIsAuthenticated(true);
            setUsername(username);
            return true;
        }
        else
        {
            setUsername(null);
            setIsAuthenticated(false);
            return false;
        }
    }*/

    /*async function login(username, password)
    {
        const basicAuthToken = "Basic " + window.btoa(username + ":" + password);

        try
        {
            const response = await executeBasicAuthenticationService(basicAuthToken);

            if (response.status == 200)
            {
                setIsAuthenticated(true);
                setUsername(username);
                setToken(basicAuthToken);

                apiClient.interceptors.request.use( config =>
                {
                    console.log("Intercepting and adding a token");
                    config.headers.Authorization = basicAuthToken;
                    return config;
                });
                return true;
            } else
            {
                logout();
                return false;
            }
        }
        catch(e)
        {
            logout();
            return false;
        }

    }*/

    async function login(username, password)
    {
        try
        {
            const response = await executeJwtAuthenticationService(username, password);

            if (response.status == 200)
            {
                const jwtToken = "Bearer " + response.data.token;
                setIsAuthenticated(true);
                setUsername(username);
                setToken(jwtToken);

                apiClient.interceptors.request.use( config =>
                {
                    console.log("Intercepting and adding a token");
                    config.headers.Authorization = jwtToken;
                    return config;
                });
                return true;
            } else
            {
                logout();
                return false;
            }
        }
        catch(e)
        {
            logout();
            return false;
        }

    }

    function logout()
    {
        setToken(null);
        setIsAuthenticated(false);
        setUsername(null);
    }

    return (
      <AuthContext.Provider value={{ isAuthenticated, login, logout, username }}>
          { children }
      </AuthContext.Provider>
    );
}