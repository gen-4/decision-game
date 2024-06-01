import React from "react";

import headerStyle from './header.module.css';



function Header() {
    return (
        <div className={ headerStyle.container }>
            <h1 className={ headerStyle.logo }>Post Apocalypsis Survival</h1>
        </div>
    );
  }
  
  export default Header;