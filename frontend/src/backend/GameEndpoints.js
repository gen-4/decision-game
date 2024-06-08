let backendHost = process.env.API_HOST
if (!backendHost)
    backendHost = "localhost";

const backendPort = 8080;
const endpointPrefix = "api/v0.0.1/";

const endpoints = {
    execute_command: endpointPrefix + "command",
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

function doExecuteCommand(data, onSuccess, onError, onEnd) {
    doPost(endpoints.execute_command, data, onSuccess, onError, onEnd);
}

function doGetOrCreatePlayer(data, onSuccess, onError, onEnd) {
    doPost(endpoints.get_or_create_player, data, onSuccess, onError, onEnd);
}

export {
    doExecuteCommand,
    doGetOrCreatePlayer
};
