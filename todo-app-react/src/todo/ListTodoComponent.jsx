import React from 'react';

const ListTodoComponent = () =>
{
    const today = new Date();
    const targetDate = new Date(today.getFullYear()+2, today.getMonth(), today.getDate());

    const todos =
        [
            {id: 1, description: "Conquer the neighbouring colonies", done: false, targetDate: targetDate},
            {id: 2, description: "Conquer the neighbouring colonies", done: false, targetDate: targetDate},
            {id: 3, description: "Conquer the neighbouring colonies", done: false, targetDate: targetDate}
        ];

    return (
        <div className="ListTodoComponent">
            <h1>Todos</h1>
            <div>
                <table className="table">
                    <thead>
                    <tr>
                        <td>Id</td>
                        <td>Description</td>
                        <td>Done?</td>
                        <td>Target Date</td>
                    </tr>
                    </thead>
                    <tbody>
                    {todos.map(todo => (
                        <tr key={todo.id}>
                            <td>{todo.id}</td>
                            <td>{todo.description}</td>
                            <td>{todo.done.toString()}</td>
                            <td>{todo.targetDate.toDateString()}</td>
                        </tr>
                    ))}

                    </tbody>
                </table>
            </div>
        </div>
    )
};

export default ListTodoComponent;