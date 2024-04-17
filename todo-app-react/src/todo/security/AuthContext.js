import {createContext, useContext, useState} from "react";

export const AuthContext = createContext();

export const useAuthContext = () => useContext(AuthContext);

export default function AuthProvider({ children })
{

    const [isAuthenticated, setIsAuthenticated] = useState(false);

    function login(username, password)
    {
        if(username === "DogRaj" && password === "Mr. India")
        {
            setIsAuthenticated(true);
            return true;
        }
        else
        {
            setIsAuthenticated(false);
            return false;
        }
    }

    function logout()
    {
        setIsAuthenticated(false);
    }

    return (
      <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
          { children }
      </AuthContext.Provider>
    );
}