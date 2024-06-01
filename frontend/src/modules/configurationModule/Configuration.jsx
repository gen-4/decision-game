import React from "react";

import configurationStyle from './configuration.module.css';

import TextInput from "../common/TextInput";



function Configuration() {
    return (
        <div className={ configurationStyle.container }>
            <TextInput placeholder="Player name" />
        </div>
    );
  }
  
  export default Configuration;