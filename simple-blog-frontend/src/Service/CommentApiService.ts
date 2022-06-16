import { CommentEntity } from "../Domain/CommentEntity";
import { ApiService } from "./ApiService";


export class CommentApiService extends ApiService<CommentEntity>{
    
    constructor(){
        super("comments")
    }

    getByPostId(id: string): Promise<Array<CommentEntity>> {
        return this.sendRequest(this.endpoint+"/post/"+id,'GET',null)
        .then(res => res.json());
    }
}

 
