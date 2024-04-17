import { apiClient } from "./ApiClientUrl";


export const retrieveTodosApi = (username) =>
{
    return apiClient.get(`/users/${username}/todos`);
    // http://localhost:8080/users/{username}/todos
}

export const retrieveTodoById = (username, id) =>
{
    return apiClient.get(`/users/${username}/todos/${id}`);
}

export const deleteTodoApi = (username, id) =>
{
    return apiClient.delete(`/users/${username}/todos/${id}`);
}

export const updateTodoApi = (username, id, todo) =>
{
    return apiClient.put(`/users/${username}/todos/${id}`, todo);
}

export const createTodoApi = (username, todo) =>
{
    return apiClient.post(`/users/${username}/todos`, todo);
}