import React, {Component} from 'react';
import {connect} from 'react-redux';
import {Toast} from "react-bootstrap";
import {BrowserRouter as Router} from "react-router-dom";
import {alertClose} from '../actions/index'
import {ALERT, SUCCESS} from "../constants/toast-types";

function getToastColor(type) {

    switch(type) {
        case SUCCESS:
            return "#009900";
        case ALERT:
            return "#ff0000";
        default:
            return "";
    }

}

class Toasts extends Component {
    render() {
        return (
            <div
                aria-live="polite"
                aria-atomic="true"
                style={{
                    position: "absolute",
                    top: "80px",
                    right: "40px",
                    zIndex: 9999
                }}
            >

                {this.props.toasts.map(t =>
                    <Toast onClick={() => this.props.alertClose({message: t.message, id: t.id, type: t.type})}
                           style={{cursor: "pointer"}} key={t.id}>
                        <Toast.Body style={{backgroundColor: getToastColor(t.type)}}>{t.message}</Toast.Body>
                    </Toast>
                )}
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {toasts: state.toasts};
}

export default connect(
    mapStateToProps,
    {alertClose}
)(Toasts);