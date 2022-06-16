import React from "react";
import { ReactElement, useState } from "react";
import { PostEntity } from "../../Domain/PostEntity";
import { PostApiService } from "../../Service/PostApiService";
import BlogButton from "./Button";
import Comments from "./Comments";
import { PostContainer } from "./Post.styles";

const api: PostApiService = new PostApiService();

function Post (postEntity:PostEntity) : ReactElement {
    
    const [isCommentsVisible, setIsCommentsVisible] = useState<Boolean>(false);
    const [showComponent, setShowComponent] = useState(true)

    const onShowComments = () : void => {
        setIsCommentsVisible(!isCommentsVisible)
    }

    const onDelete = () : void => {
        api.delete(postEntity.id);
        setShowComponent(false)
    }


    return (
        <React.Fragment>
            {showComponent ?
            <PostContainer>
                <p>{postEntity.content}</p>
                <p>By {postEntity.user?.name}</p>
                <BlogButton onClick={onDelete} content='Delete'/>
                <BlogButton onClick={onShowComments} content={isCommentsVisible ? 'Hide Comments':'Show Comments'}/>
                {isCommentsVisible? <Comments postId={postEntity.id}/> : null}
            </PostContainer>
            :null}
        </React.Fragment>
        
    )
}   
export default Post