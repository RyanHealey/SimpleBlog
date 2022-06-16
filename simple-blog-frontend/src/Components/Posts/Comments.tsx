import React, {ReactElement, useEffect, useState} from 'react';
import { CommentEntity } from '../../Domain/CommentEntity';
import { PostEntity } from '../../Domain/PostEntity';
import { CommentApiService } from '../../Service/CommentApiService';
import Comment from './Comment';


const api: CommentApiService = new CommentApiService();

type Props = {
    postId:string
}

function Comments (props: Props) : ReactElement {
    const [commentList, setCommentList] = useState<Array<ReactElement>>([]);

    const formatComments  = (comments : Array<CommentEntity>) : void => {
        setCommentList(comments.map((comment) => <Comment id={comment.id} content={comment.content} user={comment.user}/> ));
    }

    useEffect(() => {
        api.getByPostId(props.postId).then(res => {formatComments(res)});    
    },[]);
    return(
        <div>{commentList}</div>
    )
}

export default Comments