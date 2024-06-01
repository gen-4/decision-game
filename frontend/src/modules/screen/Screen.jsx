import { React, useState } from "react";

import screenStyle from './screen.module.css';

import Post from "./Post";



function Screen() {
    const [ message, setMessage ] = useState("");
    const [ messages, setMessages ] = useState([]);
    const [ inputDisabled, setInputDisabled ] = useState(false);

    const addMessage = ( sender, msg ) => {
        setMessages([...messages, { sender, msg: "> " + msg }]);
    };

    const addUserMessage = ( msg ) => {
        addMessage('user', msg);
        setInputDisabled(true);
        setMessage("");
        // TODO: call bacend and onSuccess addSystemMessage finally setInputDisabled(false)
    }

    const addSystemMessage = ( msg ) => {
        addMessage('system', msg);
    }

    return (
        <div className={ screenStyle.container }>
            <div className={ screenStyle.screen }>
                {
                    messages.map(({ sender, msg }) => (
                        <Post sender={ sender } message={ msg } />
                    ))
                }
            </div>

            <input type="text" 
                disabled={ inputDisabled }
                value={ message }
                onChange={ e => setMessage(e.target.value) }
                className={`${screenStyle.writer} body-font ${screenStyle.fillspace}`} 
                onKeyDown={ e => { if (e.key === 'Enter') addUserMessage(message) } }
            />
        </div>
    );
  }
  
  export default Screen;