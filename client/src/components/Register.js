import React, { Component } from "react";
import { connect } from "react-redux";
import { addArticle } from "../actions/index";

import Form from "react-jsonschema-form";
import {registerRequest} from "../actions";

const schema = {
    title: "Register",
    type: "object",
    required: ["login", "email", "password"],
    properties: {
        login: {type: "string", title: "Login", default: ""},
        password: {type: "string", title: "Password", default: ""},
        email: {type: "string", title: "Email", default: ""},
    }
};

class Register  extends Component{

    render() {
        return (
            <Form schema={schema}
                  onSubmit={({formData}, e) => {
                      this.props.registerRequest(formData);
                      this.props.history.push("/confirm");
                  }}
            />
        )
    }
}

const mapStateToProps = state => {
    return { toasts: state.toasts };
};

export default connect(
    null,
    { registerRequest }
)(Register);