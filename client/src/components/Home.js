import React, {Component} from 'react';
import {connect} from 'react-redux';
import {Button} from "react-bootstrap";
import {alert} from "../actions";

class Home extends Component {
    render() {
        return (
            <div>
                <Button onClick={ () => this.props.alert({message: "toast123"})}>123</Button>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {};
}

export default connect(
    mapStateToProps,
    { alert }
)(Home);
