import React from "react";

import inputStyle from './text-input.module.css';


function TextInput( { value, onChangeFunction, fillSpace, placeholder, onInsertFunction } ) {
    return (
        <input type="text" 
            value={ value }
            onChange={ e => onChangeFunction(e.target.value) }
            placeholder={ placeholder } 
            className={`${inputStyle.wrapper} body-font ${fillSpace ? inputStyle.fillspace : ""}`} 
            onKeyDown={ e => { if (e.key === 'Enter') onInsertFunction(value) } }
        />
    );
  }
  
  export default TextInput;
