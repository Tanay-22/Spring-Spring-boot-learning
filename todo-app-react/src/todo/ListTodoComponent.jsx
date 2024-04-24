import React, {useEffect, useState} from 'react';
import {deleteTodoApi, retrieveTodosApi, updateTodoApi} from "./api/TodoApiService";
import {retrieveTodoById} from "./api/TodoApiService";
import {useAuthContext} from "./security/AuthContext";
import {useNavigate} from "react-router-dom";

const ListTodoComponent = () =>
{
    const today = new Date();
    const targetDate = new Date(today.getFullYear()+2, today.getMonth(), today.getDate());

    const auth = useAuthContext();
    const username = auth.username;
    const navigate = useNavigate();

    const [todos, setTodos] = useState([]);

    const [message, setMessage] = useState(null);

    const [updating, setUpdating] = useState(false);

    function refreshTodos()
    {
        retrieveTodosApi(username)
            .then((response) => setTodos(response.data))
            .catch((error) => console.log(error))
            .finally(() => console.log("cleanup"));

    }

    function deleteTodo(id)
    {
        deleteTodoApi(username, id)
            .then(
                () =>
                {
                    setMessage(`Deletion of todo ${id} is successful`);
                    refreshTodos();
                }
            )
            .catch((error) => console.log(error))
    }

    function updateTodo(id)
    {
        navigate(`/todo/${id}`);
    }

    function goToNewTodo()
    {
        navigate(`/todo/-1`);
    }

    useEffect(() => refreshTodos(), []);

    return (
        <div className="ListTodoComponent">
            <h1>Todos</h1>
            {message && <h3 className="alert alert-info">{message}</h3>}
            <div>
                <table className="table">
                    <thead>
                    <tr>
                        <td>Id</td>
                        <td>Description</td>
                        <td>Done?</td>
                        <td>Target Date</td>
                        <td>Update</td>
                        <td>Delete</td>
                    </tr>
                    </thead>
                    <tbody>
                    {todos.map(todo => (
                        <tr key={todo.id}>
                            <td>{todo.id}</td>
                            <td>{todo.description}</td>
                            <td>{todo.done.toString()}</td>
                            <td>{todo.targetDate}</td>
                            <td>
                                <button className="btn btn-warning"
                                        onClick={(id) => updateTodo(todo.id)}>
                                    Update
                                </button>
                            </td>
                            <td>
                                {!updating &&<button className="btn btn-danger"
                                         onClick={(id) => deleteTodo(todo.id)}>
                                    Delete
                                </button>}
                            </td>
                            <td>{todo.targetDate.toDateString()}</td>
                        </tr>
                    ))}

                    </tbody>
                </table>
                <div className="btn btn-success m-5" onClick={goToNewTodo}>Add New Todo</div>
            </div>
        </div>
    )
};

export default ListTodoComponent;