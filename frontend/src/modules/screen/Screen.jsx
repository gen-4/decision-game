import { React, useState, useRef, useEffect } from "react";

import screenStyle from './screen.module.css';

import Post from './Post';
import Configuration from './Configuration';

import { doGetHelp, doGetStatus, doGetItems, doGetOrCreatePlayer } from '../../backend/GameEndpoints';



function Screen() {
    const [player, setPlayer] = useState({});
    const [playerName, setPlayerName] = useState("");
    const [message, setMessage] = useState("");
    const [messages, setMessages] = useState([]);
    const [inputDisabled, setInputDisabled] = useState(true);

    const containerRef = useRef(null);

    const addMessages = (msgList) => {
        setMessages([...messages, ...msgList]);

        if (containerRef && containerRef.current) {
            const element = containerRef.current;
            element.scroll({
                top: element.scrollHeight,
                left: 0,
                behavior: "smooth"
            })
        }
    };

    const formatMessage = (sender, msg) => {
        return { sender, msg: msg };
    }

    const executeCommand = (data, onSuccess, onError, onEnd) => {
        let callFun = doGetHelp;

        switch (data.command.toLowerCase()) {
            case 'status':
                callFun = doGetStatus;
                break;

            case 'items':
                callFun = doGetItems;
                break;
        }

        callFun(data, onSuccess, onError, onEnd);
    }

    const addUserMessage = (msg) => {
        const formattedUserMessage = formatMessage('user', msg);
        setInputDisabled(true);
        setMessage("");
        executeCommand(
            {
                command: msg,
                playerId: player.id
            }, // Maybe do this with a mutex
            (data) => addMessages([formattedUserMessage, formatMessage('system', data.response)]),
            () => addMessages([formattedUserMessage]),
            () => setInputDisabled(false)
        );
    }

    const addSystemMessages = (msgs) => {
        addMessages(msgs.map(msg => formatMessage('system', msg)));
    }

    const onInsertPlayerName = (name) => {
        doGetOrCreatePlayer(
            { name },
            (data) => {
                addSystemMessages([data.response, data.description]);
                delete data.response;
                setPlayer(data);
                setInputDisabled(false);
            },
            () => addSystemMessages(["Unable to get or create player: " + name]),
            () => { }
        );
    }

    return (
        <div className={screenStyle.container}>
            <Configuration
                value={playerName}
                onChangeFunction={name => setPlayerName(name)}
                onInsertFunction={name => onInsertPlayerName(name)}
            />

            <div ref={containerRef} className={screenStyle.screen}>
                {
                    messages.map(({ sender, msg }) => (
                        <Post sender={sender} message={msg} />
                    ))
                }
            </div>

            <input type="text"
                disabled={inputDisabled}
                value={message}
                onChange={e => setMessage(e.target.value)}
                className={`${screenStyle.writer} body-font ${screenStyle.fillspace}`}
                onKeyDown={e => { if (e.key === 'Enter') addUserMessage(message) }}
            />
        </div>
    );
}

export default Screen;
