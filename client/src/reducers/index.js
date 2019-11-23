import {ADD_ARTICLE, ALERT, ALERT_CLOSE} from "../constants/action-types";
import {alert, alertClose} from "../actions";
import store from "../store/index"
import {SUCCESS} from "../constants/toast-types";

const initialState = {
    articles: [],
    remoteArticles: [],
    toasts: [{message: "Toast 1", id: 1, type: ALERT}, {message: "Toast 2", id: 2, type: SUCCESS}, {message: "Toast 3", id: 4}]
};

function uuidv4() {
    return ([1e7]+-1e3+-4e3+-8e3+-1e11).replace(/[018]/g, c =>
        (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
    );
}

function rootReducer(state = initialState, action) {
    if (action.type === ADD_ARTICLE) {
        return Object.assign({}, state, {
            articles: state.articles.concat(action.payload)
        });
    }

    if (action.type === "DATA_LOADED") {
        return Object.assign({}, state, {
            remoteArticles: state.remoteArticles.concat(action.payload)
        });
    }

    if (action.type === ALERT) {

        var mesageUUID= uuidv4();
       
        setTimeout(() => store.dispatch( { type: ALERT_CLOSE , payload: {message: action.payload.message, id: mesageUUID}}), 10000);

        return {...state, toasts: [...state.toasts, {message: action.payload.message, id: mesageUUID}]}
    }

    if (action.type === ALERT_CLOSE) {
        return Object.assign({}, state, {
            toasts: state.toasts.filter(t => t.id !== action.payload.id)
        });
    }

    return state;
}

export default rootReducer;