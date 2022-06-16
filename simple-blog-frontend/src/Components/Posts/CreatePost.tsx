import { useContext } from "react";
import { FormEvent, ReactElement } from "react"
import { UserContext } from "../../App";
import { mapToCurrentUserEntity } from "../../Domain/CurrentUserDto";
import { PostEntity } from "../../Domain/PostEntity";
import { UserContextType } from "../../Domain/UserContextType";
import { PostApiService } from "../../Service/PostApiService";

const postApi: PostApiService = new PostApiService();

function CreatePost () : ReactElement{
    const currentUser:UserContextType = useContext(UserContext);

    const onSubmit = (e:FormEvent<HTMLFormElement>):void => {
        // e.preventDefault();
        const form: HTMLFormElement | null = document.querySelector('#createPost');
        const formData: FormData = new FormData(form ?? undefined);
        const post : PostEntity = 
        {
            content: formData.get('post')?.toString(),
            user: currentUser.currentUser
        }
        postApi.postNew(post)
    }

    return(
        <form onSubmit={onSubmit} id="createPost">
            <textarea rows={5} cols={80} name="post"/>
            <button type = "submit">Publish</button>
        </form>
    )
}
export default CreatePost

