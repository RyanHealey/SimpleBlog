import React, { ReactElement, useContext, useState } from "react";
import { UserContext } from "../../App";
import { CommentEntity } from "../../Domain/CommentEntity";
import { CurrentUserEntity } from "../../Domain/CurrentUserEntity";
import { UserContextType } from "../../Domain/UserContextType";
import { CommentApiService } from "../../Service/CommentApiService";
import { hasPermissionToDeleteComment } from "../../Service/PermissionsService";
import BlogButton from "./Button";
import { CommentContainer } from "./Comment.styles";

const api: CommentApiService = new CommentApiService();



function Comment (commentEntity:CommentEntity) : ReactElement {
    const currentUser:UserContextType = useContext(UserContext);
    const [showComponent, setShowComponent] = useState(true)
    

    const onDelete = () : void => {
        api.delete(commentEntity.id ?? "0");
        setShowComponent(false)
    }

    function canDelete(currentUser: CurrentUserEntity): boolean {
        return hasPermissionToDeleteComment(commentEntity, currentUser);
    }

    return (
        <React.Fragment>
            {showComponent ?
            <CommentContainer>
                <p>{commentEntity.content}</p>
                <p>By {commentEntity.user?.name}</p>
                {canDelete(currentUser.currentUser) ? <BlogButton onClick={onDelete} content='Delete' />: null}
            </CommentContainer>
            : null}
        </React.Fragment>
    )
}   
export default Comment