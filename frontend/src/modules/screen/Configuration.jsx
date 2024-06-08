import React from "react";

import configurationStyle from './configuration.module.css';

import TextInput from "../common/TextInput";



function Configuration({ value, onChangeFunction, onInsertFunction }) {
    return (
        <div className={ configurationStyle.container }>
            <TextInput 
                placeholder="Player name" 
                value={ value }
                onChangeFunction={ onChangeFunction }
                onInsertFunction={ onInsertFunction }
            />
        </div>
    );
  }
  
  export default Configuration;