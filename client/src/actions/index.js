import {
    ADD_ARTICLE,
    ALERT,
    ALERT_CLOSE,
    USER_LOGIN,
    USER_LOGOUT,
    USER_REGISTER,
    USER_REGISTERED,
    QUIZ_LIST_LOADED
} from "../constants/action-types";

export function addArticle(payload) {
    return { type: ADD_ARTICLE, payload }
};

export function login(payload) {
    return { type: USER_LOGIN, payload }
};

export function logout(payload) {
    return { type: USER_LOGOUT, payload }
};

export function register(payload) {
    return { type: USER_REGISTER, payload }
};

export function alert(payload) {
    return { type: ALERT, payload }
};

export function alertClose(payload) {
    return { type: ALERT_CLOSE, payload }
};



export function loadQuizList() {
    return function(dispatch) {
        return fetch("http://localhost:8080/quiz/list")
            .then(response => response.json())
            .then(json => {
                dispatch({ type: QUIZ_LIST_LOADED, payload: json });
            });
    };
}

export function loginRequest(user, password) {
    return function(dispatch) {
        return fetch(`http://localhost:8080/login?login={user}&password={password}`)
            .then(response => response.json())
            .then(json => {
                dispatch({ type: USER_LOGIN, payload: json });
            });
    };
}

export function registerRequest(data) {
    return function(dispatch) {
        return fetch(`http://localhost:8080/register`, {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            mode: 'cors', // no-cors, cors, *same-origin
            cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
            credentials: 'same-origin', // include, *same-origin, omit
            headers: {
                'Content-Type': 'application/json',
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            redirect: 'follow', // manual, *follow, error
            referrer: 'no-referrer', // no-referrer, *client
            body: JSON.stringify(data), // тип данных в body должен соответвовать значению заголовка "Content-Type"
        })
            .then(response => dispatch({ type: USER_REGISTERED, payload: response.json() })); // парсит JSON ответ в Javascript объект
    };
}


/*
postData('http://example.com/answer', {answer: 42})
    .then(data => console.log(JSON.stringify(data))) // JSON-строка полученная после вызова `response.json()`
    .catch(error => console.error(error));

function postData(url = '', data = {}) {
    // Значения по умолчанию обозначены знаком *
    return fetch(url, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, cors, *same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            'Content-Type': 'application/json',
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrer: 'no-referrer', // no-referrer, *client
        body: JSON.stringify(data), // тип данных в body должен соответвовать значению заголовка "Content-Type"
    })
        .then(response => response.json()); // парсит JSON ответ в Javascript объект
}
*/
// "http://localhost:8080/login?login=user&password=user"