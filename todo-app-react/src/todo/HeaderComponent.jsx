import React from 'react';
import {Link} from "react-router-dom";
import {useAuthContext} from "./security/AuthContext";

const HeaderComponent = () =>
{
    const authContext = useAuthContext();

    return (
        <header className="border-bottom border-light border-5 mb-5 p-2">
            <div className="container">
                <div className="row">
                    <nav className="navbar navbar-expand-lg">
                        <a className="navbar-brand ms-2 fs-2 fw-bold text-black"
                           href="#">DR</a>
                        <div className="collapse navbar-collapse">
                            <ul className="navbar-nav">
                                <li className="nav-item">
                                    <a className="nav-link" href="https://youtu.be/dQw4w9WgXcQ?si=fvchdvZy4_zVr9KI">
                                        Click For Surprise
                                    </a>
                                </li>

                                <li className="nav-item">
                                    {authContext.isAuthenticated &&
                                        <Link className="nav-link" to="/welcome/DogRaj">Home</Link>
                                    }
                                </li>
                            </ul>
                        </div>

                        <ul className="navbar-nav">

                            <li className="nav-item">
                                {authContext.isAuthenticated &&
                                    <Link className="nav-link" to="/todos">Todos</Link>
                                }
                            </li>

                            <li className="nav-item">
                                {!authContext.isAuthenticated &&
                                    <Link className="nav-link" to="/login">Login</Link>
                                }
                            </li>
                            <li className="nav-item">
                                {authContext.isAuthenticated &&
                                    <Link className="nav-link" to="/logout" onClick={() => authContext.logout() }>Logout</Link>
                                }
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
    );
};

export default HeaderComponent;