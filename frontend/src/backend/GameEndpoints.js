let backendHost = process.env.API_HOST
if (!backendHost)
    backendHost = "localhost";

const backendPort = 8080;
const endpointPrefix = "api/v0.0.1/";

const endpoints = {
    get_help: endpointPrefix + "help",
    get_status: endpointPrefix + "status",
    get_items: endpointPrefix + "items",
    get_or_create_player: endpointPrefix + "get-create-player"
}

function doRequest(url, options, onSuccess, onError, onEnd) {
    fetch(`http://${backendHost}:${backendPort}/${url}`, options)
        .then((response) => response.json().then((data) => onSuccess(data)))
        .catch((data) => {
            console.error(`Error while accessing: ${options.method} ${url}\nResponse: ${data}`);
            onError(data);
        })
        .finally(onEnd());
}

function doPost(url, data, onSuccess, onError, onEnd) {
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    };
    doRequest(url, options, onSuccess, onError, onEnd);
}


function doGet(url, data, onSuccess, onError, onEnd) {
    const options = {
        method: "GET",
    };
    doRequest(url, options, onSuccess, onError, onEnd);
}

function doGetHelp(data, onSuccess, onError, onEnd) {
    doPost(endpoints.get_help, data, onSuccess, onError, onEnd);
}


function doGetStatus(data, onSuccess, onError, onEnd) {
    doPost(endpoints.get_status, data, onSuccess, onError, onEnd);
}


function doGetItems(data, onSuccess, onError, onEnd) {
    doPost(endpoints.get_items, data, onSuccess, onError, onEnd);
}

function doGetOrCreatePlayer(data, onSuccess, onError, onEnd) {
    doPost(endpoints.get_or_create_player, data, onSuccess, onError, onEnd);
}

export {
    doGetHelp,
    doGetStatus,
    doGetItems,
    doGetOrCreatePlayer
};
