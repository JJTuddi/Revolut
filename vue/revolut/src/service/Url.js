
const baseUrl = "http://localhost:8080/api";

const getAuthUrl = () => {
    return baseUrl + "/auth";
}

const getDetailsUrl = () => {
    return baseUrl + "/users/my/details";
}

const getMyCardsUrl = () => {
    return baseUrl + "/cards/my_cards";
}

const getCardReportsUrl = (type) => {
    return baseUrl + "/reports/my_cards/" + type;
}

export default {
    getAuthUrl,
    getDetailsUrl,
    getMyCardsUrl,
    getCardReportsUrl
}