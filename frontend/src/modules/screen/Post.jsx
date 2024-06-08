import { React } from "react";

import postStyle from './post.module.css';



function Post({ sender, message }) {
    return (
        <div className={`${postStyle.message} ${ sender === 'system' ? postStyle.systemmsg : postStyle.usermsg}`} >
            <span>{ '> ' }</span><span>{ message }</span>
        </div>
    );
  }
  
  export default Post;