import React, {Component} from 'react';
import {connect} from 'react-redux';
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import {Button} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faCog, faArrowAltCircleRight} from "@fortawesome/free-solid-svg-icons";
import {ColoredLine} from "./ColoredLine";
//https://github.com/FortAwesome/react-fontawesome

class QuizMenuRow extends Component {
    render() {
        return (
            <Container>
                <ColoredLine/>
                <Row>
                    <Col sm={12}>{this.props.quiz.name}</Col>
                    <Col sm={12}>{this.props.quiz.description}</Col>
                </Row>
                <Row>
                    <Col sm={12}>
                        <Button><FontAwesomeIcon icon={faCog} size="lg"/></Button>&nbsp;
                        <Button>Начать&nbsp;<FontAwesomeIcon icon={faArrowAltCircleRight} size="lg"/></Button>
                    </Col>
                </Row>
                <ColoredLine/>
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
