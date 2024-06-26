import React from 'react';
import './TodoApp.css';
import {BrowserRouter, Navigate, Route, Routes} from "react-router-dom";
import HeaderComponent from "./HeaderComponent";
import FooterComponent from "./FooterComponent";
import LoginComponent from "./LoginComponent";
import ListTodoComponent from "./ListTodoComponent";
import WelcomeComponent from "./WelcomeComponent";
import LogoutComponent from "./LogoutComponent";
import ErrorComponent from "./ErrorComponent";
import AuthProvider, {useAuthContext} from "./security/AuthContext";
import TodoComponent from "./TodoComponent";


function AuthenticatedRoute({ children })
{
    const authContext = useAuthContext();

    if(authContext.isAuthenticated)
        return children;

    return <Navigate to="/" />;
}

const TodoApp = () =>
{
    return (
        <div className="TodoApp">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent/>
                    <Routes>

                        
                        <Route path="/" element={<LoginComponent />} />

                        <Route path="/login" element={<LoginComponent />} />

                        <Route path="/welcome/:username" element=
                        {
                            <AuthenticatedRoute>
                                <WelcomeComponent />
                            </AuthenticatedRoute>
                        } />

                        <Route path="/todos" element=
                        {
                            <AuthenticatedRoute>
                                <ListTodoComponent />
                            </AuthenticatedRoute>
                        } />

                        <Route path="/logout" element=
                        {
                            <AuthenticatedRoute>
                                <LogoutComponent />
                            </AuthenticatedRoute>
                        } />

                        <Route path="/todo/:id" element=
                        {
                            <AuthenticatedRoute>
                                <TodoComponent />
                            </AuthenticatedRoute>
                        } />


                        <Route path="*" element={<ErrorComponent />} />

                    </Routes>
                    <FooterComponent />
                </BrowserRouter>
            </AuthProvider>
        </div>
    );
};

export default TodoApp;