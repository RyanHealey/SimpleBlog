import { useContext } from "react";
import { FormEvent, ReactElement } from "react"
import { UserContext } from "../../App";
import { mapToCurrentUserEntity } from "../../Domain/CurrentUserDto";
import { CommentEntity } from "../../Domain/CommentEntity";
import { UserContextType } from "../../Domain/UserContextType";
import { CommentApiService } from "../../Service/CommentApiService";

const CommentApi: CommentApiService = new CommentApiService();

export interface CreateCommentInterface{
    postId:string
}

function CreateComment (props:CreateCommentInterface) : ReactElement{
    const currentUser:UserContextType = useContext(UserContext);

    const onSubmit = (e:FormEvent<HTMLFormElement>):void => {
        const form: HTMLFormElement | null = document.querySelector('#createComment');
        e.preventDefault();
        const formData: FormData = new FormData(form ?? undefined);
        const comment : CommentEntity = 
        {
            content: formData.get('comment')?.toString(),
            user: currentUser.currentUser,
            post: { id: props.postId },
        }

        CommentApi.postNew(comment);

    }

    return(
        <form onSubmit={onSubmit} id="createComment">
            <textarea rows={3} cols={60} name="comment"/>
            <button type = "submit">Publish</button>
        </form>
    )
}
export default CreateComment

