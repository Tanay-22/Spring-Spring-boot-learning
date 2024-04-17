import React, {useState} from 'react';
import {useNavigate} from "react-router-dom";
import {useAuthContext} from "./security/AuthContext";

const LoginComponent = () =>
{
    const [username, setUsername] = useState("DogRaj");
    const [password, setPassword] = useState("");

    const [successAuthenticationMessage, setSuccessAuthenticationMessage] = useState(false);
    const [errorAuthenticationMessage, setErrorAuthenticationMessage] = useState(false);

    const navigate = useNavigate();

    const authContext = useAuthContext();

    async function handleSubmit()
    {
        if(await authContext.login(username, password))
        {
            setErrorAuthenticationMessage(false);
            setSuccessAuthenticationMessage(true);
            navigate(`/welcome/${username}`);
        }
        else
        {
            setErrorAuthenticationMessage(true);
            setSuccessAuthenticationMessage(false);
        }
    }


    return (
        <div className="Login">

            { successAuthenticationMessage && <div className="successMessage">
                Authentication successfully!
            </div> }

            { errorAuthenticationMessage && <div className="errorMessage">
                Authentication Failed!. Please check your credentials.
            </div> }

            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="userName" value={username}
                           onChange={(e) => setUsername(e.target.value)}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password}
                           onChange={(e) => setPassword(e.target.value)}/>
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>Submit</button>
                </div>
            </div>
        </div>
    );
};

export default LoginComponent;