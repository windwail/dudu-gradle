import React, {Component} from 'react';
import {connect} from 'react-redux';
import {Button} from "react-bootstrap";
import {alert, loadQuizList} from "../actions";
import QuizMenuRow from "./QuizMenuRow";

class Home extends Component {

    componentDidMount() {
        this.props.loadQuizList();
    }

    render() {
        return (
            <div>
                <h2> Доступные тесты: </h2>
                <br/>
                { this.props.quizList &&
                    this.props.quizList.map( (q) => <QuizMenuRow quiz={q}/>)
                }
            </div>

        );
    }
}

function mapStateToProps(state) {
    return {
        quizList: state.quizList
    };
}

export default connect(
    mapStateToProps,
    { alert, loadQuizList }
)(Home);
