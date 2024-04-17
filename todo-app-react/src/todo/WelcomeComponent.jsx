import React from 'react';
import {Link, useParams} from "react-router-dom";

const WelcomeComponent = () =>
{
    const {username} = useParams();

    return (
        <div>
            <h1 className="Welcome">
                Welcome, {username}
            </h1>
            <h2>
                <Link to="/todos"> Manage your Todos</Link>
            </h2>
        </div>
    );
};

export default WelcomeComponent;