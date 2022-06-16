import { ReactElement, useState } from "react";
import BlogButton from "./Button";
import CreateComment, { CreateCommentInterface } from "./CreateComment";
import CreatePost from "./CreatePost";


function CreateCommentContainer (props:CreateCommentInterface) : ReactElement{
    const [showEditor, setShowEditor] = useState(false);
    
    return(
        <div>
            {showEditor?<CreateComment postId={props.postId}/>:null}
            <BlogButton onClick={()=>setShowEditor(!showEditor)} content={showEditor?"Cancel":"Write Comment"}/>
        </div>
    )
}

export default CreateCommentContainer;