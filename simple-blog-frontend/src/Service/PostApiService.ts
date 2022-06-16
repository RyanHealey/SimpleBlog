import { PostEntity } from "../Domain/PostEntity"
import { ApiService } from "./ApiService";


export class PostApiService extends ApiService<PostEntity>{
    
    constructor(){
        super("posts")
    }
}

 
