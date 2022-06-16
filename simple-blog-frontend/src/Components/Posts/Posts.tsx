import React, {ReactElement, useEffect, useState} from 'react';
import { PostEntity } from '../../Domain/PostEntity';
import { PostApiService } from '../../Service/PostApiService';
import Post from './Post';


const api: PostApiService = new PostApiService();

function Posts () : ReactElement {
    const [postList, setPostList] = useState<Array<ReactElement>>([]);

    const formatPosts  = (posts : Array<PostEntity>) : void => {
        setPostList(posts.map((post) => <Post id={post.id} content={post.content} user={post.user}/> ));
    }

    useEffect(() => {
        api.getAll().then(res => {formatPosts(res)});    
    },[]);
    return(
        <div>{postList}</div>
    )
}

export default Posts