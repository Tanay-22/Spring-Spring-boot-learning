import React, {useEffect, useState} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import {createTodoApi, retrieveTodoById, updateTodoApi} from "./api/TodoApiService";
import {useAuthContext} from "./security/AuthContext";
import {ErrorMessage, Field, Form, Formik} from "formik";
import moment from "moment";

const TodoComponent = () =>
{
    const { id } = useParams();
    const auth = useAuthContext();
    const username = auth.username;

    const navigate = useNavigate();

    const [description, setDescription] = useState(null);
    const [targetDate, setTargetDate] = useState(null);

    useEffect(() => retrieveTodos(), [id]);

    function retrieveTodos()
    {
        if(id !== -1)
        {
            retrieveTodoById(username, id)
                .then(response =>
                {
                    setDescription(response.data.description);
                    setTargetDate(response.data.targetDate);
                })
                .catch((error) => console.log(error))
        }
    }

    function onSubmit(values)
    {
        console.log(values);
        const todo =
        {
            id: id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        }
        if(id === -1)
        {
            createTodoApi(username, todo)
            .then(response => navigate("/todos"))
            .catch(error => console.log(error));
        }
        else
        {
            updateTodoApi(username, id, todo)
                .then(response => navigate("/todos"))
                .catch(error => console.log(error));
        }

    }

    function validate(values)
    {
        let errors = {};

        if(values.description.length < 5)
            errors.description = "Description should be at least 5 characters !";
        if(values.targetDate === null || values.targetDate == "" || !moment(values.targetDate).isValid())
            errors.targetDate = "Target Date should be not be EMPTY !";
        return errors;
    }

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <Formik initialValues= {{ description: description, targetDate: targetDate }}
                enableReinitialize={true}
                onSubmit={onSubmit}
                validate={validate}
                validateOnChange={false}
                validateOnBlur={false}

            >
            {
                (props) => (
                    <div>
                        <Form>
                            <ErrorMessage
                                name="description"
                                component="div"
                                className="alert alert-warning"
                            />

                            <ErrorMessage
                                name="targetDate"
                                component="div"
                                className="alert alert-warning"
                            />

                            <fieldset className="form-group">
                                <label>Description:</label>
                                <Field type="text" className="form-control" name="description"/>
                            </fieldset>

                            <fieldset className="form-group">
                                <label>Target Date:</label>
                                <Field type="date" className="form-control" name="targetDate"/>
                            </fieldset>

                            <div>
                                <button className="btn btn-success m-5" type="submit">Save</button>
                            </div>
                        </Form>
                    </div>
                )
            }
            </Formik>
        </div>
    );
};

export default TodoComponent;