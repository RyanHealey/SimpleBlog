import { UserEntity } from "../Domain/UserEntity";
import { ApiService } from "./ApiService";


export class UserApiService extends ApiService<UserEntity>{
    
    constructor(){
        super("user")
    }
}

 
