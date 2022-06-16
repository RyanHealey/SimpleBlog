import { ReactElement, useState } from "react";
import BlogButton from "./Button";
import CreatePost from "./CreatePost";

function CreatePostContainer () : ReactElement{
    const [showEditor, setShowEditor] = useState(false);
    
    return(
        <div>
            {showEditor?<CreatePost/>:null}
            <BlogButton onClick={()=>setShowEditor(!showEditor)} content={showEditor?"Cancel":"Write Post"}/>
        </div>
    )
}

export default CreatePostContainer;