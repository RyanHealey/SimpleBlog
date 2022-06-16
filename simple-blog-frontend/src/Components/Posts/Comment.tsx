import React, { ReactElement, useState } from "react";
import { CommentEntity } from "../../Domain/CommentEntity";
import { CommentApiService } from "../../Service/CommentApiService";
import BlogButton from "./Button";
import { StyledButton } from "./Button.styles";
import { CommentContainer } from "./Comment.styles";

const api: CommentApiService = new CommentApiService();

function Comment (commentEntity:CommentEntity) : ReactElement {
    const onDelete = () : void => {
        api.delete(commentEntity.id);
        setShowComponent(false)
    }
    
    const [showComponent, setShowComponent] = useState(true)

    return (
        <React.Fragment>
        {showComponent ?
        <CommentContainer>
            <p>{commentEntity.content}</p>
            <p>By {commentEntity.user?.name}</p>
            <BlogButton onClick={onDelete} content='Delete'/>
        </CommentContainer>
        : null}
        </React.Fragment>
    )
}   
export default Comment