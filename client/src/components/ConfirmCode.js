import React, { Component } from "react";
import { connect } from "react-redux";
import { addArticle } from "../actions/index";

import Form from "react-jsonschema-form";
import {registerRequest} from "../actions";

const schema = {
    title: "Confirm registration code. It's is send to your email.",
    type: "object",
    required: ["code"],
    properties: {
        code: {type: "string", title: "Confirmation code", default: ""},
    }
};

class ConfirmCode  extends Component{

    render() {
        return (
            <Form schema={schema}
                  onSubmit={({formData}, e) => {
                      //this.props.registerRequest(formData);
                      //this.props.history.push("/register");
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
)(ConfirmCode);