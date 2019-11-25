import React, {Component} from 'react';
import {connect} from 'react-redux';
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

class QuizMenuRow extends Component {
    render() {
        return (
            <Container>
                <Row>
                    <Col sm={8}>{this.props.quiz.id}</Col>
                    <Col sm={4}>{this.props.quiz.name}</Col>
                </Row>
            </Container>
        );
    }
}

function mapStateToProps(state) {
    return {};
}

export default connect(
    mapStateToProps,
)(QuizMenuRow);
