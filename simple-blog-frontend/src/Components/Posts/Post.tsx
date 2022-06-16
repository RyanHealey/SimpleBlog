import React, { useContext } from "react";
import { ReactElement, useState } from "react";
import { UserContext } from "../../App";
import { CurrentUserEntity } from "../../Domain/CurrentUserEntity";
import { PostEntity } from "../../Domain/PostEntity";
import { UserContextType } from "../../Domain/UserContextType";
import { hasPermissionToDeletePost, hasPermissionToWriteComment } from "../../Service/PermissionsService";
import { PostApiService } from "../../Service/PostApiService";
import BlogButton from "./Button";
import Comments from "./Comments";
import CreateCommentContainer from "./CreateCommentContainer";
import { PostContainer } from "./Post.styles";

const api: PostApiService = new PostApiService();

function Post (postEntity:PostEntity) : ReactElement {
    const currentUser:UserContextType = useContext(UserContext);
    const [isCommentsVisible, setIsCommentsVisible] = useState<Boolean>(false);
    const [showComponent, setShowComponent] = useState(true)

    const onShowComments = () : void => {
        setIsCommentsVisible(!isCommentsVisible)
    }

    const onDelete = () : void => {
        api.delete(postEntity.id ?? "");
        setShowComponent(false)
    }

    const canDelete = (currentUser: CurrentUserEntity): boolean => {
        return hasPermissionToDeletePost(postEntity, currentUser);
    }

    const canWriteComment = (currentUser: CurrentUserEntity): boolean => {
        return hasPermissionToWriteComment(currentUser);
    }


    return (
        <React.Fragment>
            {showComponent ?
            <PostContainer>
                <p>{postEntity.content}</p>
                <p>By {postEntity.user?.name}</p>
                {canDelete(currentUser.currentUser) ? <BlogButton onClick={onDelete} content='Delete' />: null}
                <BlogButton onClick={onShowComments} content={isCommentsVisible ? 'Hide Comments':'Show Comments'}/>
                {isCommentsVisible? <Comments postId={postEntity.id ?? ""}/> : null}
                {canWriteComment(currentUser.currentUser)?<CreateCommentContainer postId={postEntity.id ?? ""}/>:null}
            </PostContainer>
            :null}
        </React.Fragment>
        
    )
}   
export default Post