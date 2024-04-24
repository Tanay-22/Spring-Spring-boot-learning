import React, {useState} from 'react';
import {Link, useParams} from "react-router-dom";
import {retrieveHelloWorldBean, retrieveHelloWorldPathVariable} from "./api/HelloWorldApiService";
import {useAuthContext} from "./security/AuthContext";


import React from 'react';
import {Link, useParams} from "react-router-dom";

const WelcomeComponent = () =>
{
    const {username} = useParams();

    const [message, setMessage] = useState(null);

    const authContext = useAuthContext();

    function successfulResponse(response)
    {
        console.log("successful response");
        setMessage(response.data.message);
        // console.log(response.data);
    }

    function erroredResponse(error)
    {
        console.log("error response");
    }

    function callHelloWorldRestApi()
    {

        // retrieveHelloWorldBean()
        //     .then((response) => successfulResponse(response))
        //     .catch((error) => erroredResponse(error))
        //     .finally(() => console.log("cleanup"));

        retrieveHelloWorldPathVariable("DogRaj", authContext.token)
            .then((response) => successfulResponse(response))
            .catch((error) => erroredResponse(error))
            .finally(() => console.log("cleanup"));
    }


    return (
        <div>
            <h1 className="Welcome">
                Welcome, {username}
            </h1>
            <h2>
                <Link to="/todos"> Manage your Todos</Link>
            </h2>
            <div>
                <button className="btn btn-success m-5" onClick={callHelloWorldRestApi}>
                    Hemlo World REST API
                </button>
            </div>
            <div>
                <button className="btn btn-success m-5" onClick={callHelloWorldRestApi}>
                    Hemlo World Path Variable REST API
                </button>
            </div>
            <h3 className="text-info">{message}</h3>
        </div>
    );
};

export default WelcomeComponent;