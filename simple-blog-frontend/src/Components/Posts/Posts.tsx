import React, {ReactElement, useEffect, useState} from 'react';
import { PostEntity } from '../Domain/PostEntity';


function Posts () : ReactElement {
    const [postList, setPostList] = useState<Array<PostEntity>>([]);

    const getPosts = () : void => {
        fetch("/posts",{headers:{'content-type': 'application/json'}})
        .then(res => res.json())
        .then(res => {setPostList(res)});
    }

    useEffect(getPosts,[]);
    return(
        <div>{JSON.stringify(postList)}</div>
    )
}

export default Posts